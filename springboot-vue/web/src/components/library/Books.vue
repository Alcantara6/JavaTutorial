<template>
	<div>
		<a-button type="primary" @click="onAdd">添加</a-button>
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
			<a-pagination v-model:current="currentPage" :defaultPageSize="10" :total="20"></a-pagination>
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
import { isSuccess } from '@/shared/utils/http.util';
import { message, Modal } from 'ant-design-vue';

const props = defineProps(['category']);
const { books, currBook, loadBooks } = useBooks(props as BookListProps);

const isBookFormVisible = ref(false);

const onConfirmEdit = async (book: Book) => {
	isBookFormVisible.value = false;
	const response = await bookService.saveOrUpdate(book);
	if (isSuccess(response)) {
		message.success('添加/更新成功!');
		books.value = await loadBooks(props.category);
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
				books.value = await loadBooks(props.category);
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

const currentPage = ref(1);
</script>

<style lang="less" scoped>
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
