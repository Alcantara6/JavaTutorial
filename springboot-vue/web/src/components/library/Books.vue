<template>
	<div>
		<a-button type="primary" @click="onAdd">添加</a-button>
		<a-input-search
			class="input-search"
			v-model:value="keywords"
			placeholder="通过书名或作者搜索..."
			enter-button
			@search="onSearch"
		/>
		<a-row class="book-row">
			<a-tooltip placement="right" v-for="item in books" :key="item.id">
				<template #title>
					<p>{{ item.title }}</p>
					<p>
						<span>{{ item.author }}</span>
						/
						<span>{{ item.date }}</span>
						/
						<span>{{ item.press }}</span>
					</p>
					<p class="book-abstract">{{ item.abs }}</p>
				</template>
				<!-- 图片card -->
				<a-card hoverable class="book-item" bodyStyle="padding:10px">
					<template #cover>
						<img :src="item.cover" alt="封面" @click="onEdit(item)" />
					</template>
					<a-card-meta :title="item.title">
						<template #description>
							{{ item.author }}
							<DeleteOutlined @click="deleteBook(item)" />
						</template>
					</a-card-meta>
				</a-card>
			</a-tooltip>
		</a-row>
		<a-row>
			<a-pagination
				v-model:current="pageNo"
				:defaultPageSize="PAGE_SIZE"
				:total="total"
				@change="onPageNoChange"
			></a-pagination>
		</a-row>
		<edit-book
			:currBook="currBook"
			:visible="isBookFormVisible"
			@onSubmit="onConfirmEdit"
			@onCancel="onCancelEdit"
		></edit-book>
	</div>
</template>

<script lang="ts">
import { createVNode, defineComponent } from 'vue';
import DeleteOutlined from '@ant-design/icons-vue/DeleteOutlined';
import EditBook from './EditBook.vue';
import { Book, BookListProps } from '@/domain/library/interface/library.interface';

export default defineComponent({
	components: { EditBook },
	props: {
		category: {
			type: Number,
		},
	},
});
</script>

<script setup lang="ts">
import { ref } from 'vue';
import { defineProps } from 'vue';
import { useBooks } from '@/domain/library/composables/use-books';
import bookService from '@/domain/library/service/bookService';
import { getPaginationBody, getTotal, isSuccess } from '@/shared/utils/http.util';
import { message, Modal } from 'ant-design-vue';

const props = defineProps(['category']);
const { books, currBook, pageNo, PAGE_SIZE, total, keywords, loadBooks } = useBooks(props as BookListProps);

const isBookFormVisible = ref(false);

const onSearch = async (keywords: string) => {
	const res = await bookService.search(keywords, 1, PAGE_SIZE);
	if (isSuccess(res)) {
		books.value = getPaginationBody(res);
		total.value = getTotal(res);
	}
};

const onPageNoChange = async (pageNo: number, pageSize: number) => {
	const res = await loadBooks(props.category, pageNo, pageSize);
	if (isSuccess(res)) {
		books.value = getPaginationBody(res);
		total.value = getTotal(res);
	}
};

const onConfirmEdit = async (book: Book) => {
	isBookFormVisible.value = false;
	const response = await bookService.saveOrUpdate(book);
	if (isSuccess(response)) {
		message.success('添加/更新成功!');
		keywords.value = null;
		const res = await loadBooks(props.category, pageNo.value, PAGE_SIZE);
		if (isSuccess(res)) {
			books.value = getPaginationBody(res);
			total.value = getTotal(res);
		}
	} else {
		message.error('操作失败');
	}
};

const onCancelEdit = () => {
	isBookFormVisible.value = false;
};

const onAdd = () => {
	currBook.value = null;
	isBookFormVisible.value = true;
};

const onEdit = (book: Book) => {
	currBook.value = book;
	isBookFormVisible.value = true;
};

const deleteBook = (book: Book) => {
	Modal.confirm({
		title: '删除',
		content: createVNode('div', { style: 'color:red;' }, '此操作将永久删除该书籍, 是否继续?'),
		onOk: async () => {
			const response = await bookService.delete(book);
			if (isSuccess(response)) {
				message.success('删除成功!');
				keywords.value = null;
				const res = await loadBooks(props.category, pageNo.value, PAGE_SIZE);
				if (isSuccess(res)) {
					books.value = getPaginationBody(res);
					total.value = getTotal(res);
				}
			} else {
				message.error('删除失败');
			}
		},
		onCancel: () => {
			message.info('已取消删除');
		},
		class: 'editor-modal',
	});
};
</script>

<style lang="less" scoped>
.input-search {
	margin-left: 40px;
	width: 400px;
}

.book-row {
	margin-top: 15px;
	height: 760px;
}

.book-item {
	width: 155px;
	height: 295px;
	margin: 0 15px 20px 0;
}

.ant-card-cover img {
	height: 220px;
}
</style>
