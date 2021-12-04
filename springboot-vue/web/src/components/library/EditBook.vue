<template>
	<!-- 因为不能定义一个ref(props.value),没有响应式，所以无法使用v-model:visible -->
	<a-modal title="添加/修改图书" :visible="visible" @cancel="onCancel">
		<a-form :label-col="labelCol" :wrapperCol="wrapperCol">
			<a-form-item label="书名" v-bind="formInfos.title">
				<a-input v-model:value="modelRef.title" placeholder="不加《》"></a-input>
			</a-form-item>
			<a-form-item label="作者" v-bind="formInfos.author">
				<a-input v-model:value="modelRef.author"></a-input>
			</a-form-item>
			<a-form-item label="出版日期" v-bind="formInfos.date">
				<a-input v-model:value="modelRef.date"></a-input>
			</a-form-item>
			<a-form-item label="出版社" v-bind="formInfos.press">
				<a-input v-model:value="modelRef.press"></a-input>
			</a-form-item>
			<a-form-item label="封面" v-bind="formInfos.cover">
				<a-input v-model:value="modelRef.cover" placeholder="图片 URL"></a-input>
				<image-upload :uploadUrl="uploadUrl" @uploaded="onUpload"></image-upload>
			</a-form-item>
			<a-form-item label="简介" v-bind="formInfos.abs">
				<a-textarea v-model:value="modelRef.abs"></a-textarea>
			</a-form-item>
			<a-form-item label="分类" v-bind="formInfos.cid">
				<!-- 绑定种类id，注意前后端都是数字类型 -->
				<a-select v-model:value="modelRef.category.id" :options="categoryOptions" placeholder="请选择分类"></a-select>
			</a-form-item>
		</a-form>
		<template #footer>
			<a-button @click="onCancel">取 消</a-button>
			<a-button type="primary" @click="onSubmit">确 定</a-button>
		</template>
	</a-modal>
</template>

<script lang="ts">
import { defineComponent, ref } from 'vue';
import ImageUpload from '../common/ImageUpload.vue';

export default defineComponent({
	components: { ImageUpload },
	props: {
		visible: {
			type: Boolean,
		},
	},
	data() {
		return {
			labelCol: { span: 4 },
			wrapperCol: { span: 14 },
			uploadUrl: '/api/books/cover',
		};
	},
	emits: ['onSubmit', 'onCancel'],
	watch: {},
	computed: {},
	methods: {},
});
</script>

<script setup lang="ts">
import { defineEmits, defineProps } from 'vue';
import { BookFormProps } from '@/domain/library/interface/library.interface';
import { useBookForm } from '@/domain/library/composables/use-book-form';
import { SelectProps } from 'ant-design-vue';
import { CATEGORY_OPTIONS } from '@/domain/library/constants/book.constant';
import { useForm } from 'ant-design-vue/lib/form';

const emit = defineEmits(['onSubmit', 'onCancel']);
const props = defineProps(['currBook', 'visible']);

const categoryOptions = ref<SelectProps['options']>(CATEGORY_OPTIONS);
const { modelRef, validateForm, formInfos, rulesRef } = useBookForm(props as BookFormProps);

const onUpload = (url: string) => {
	modelRef.value = {
		...modelRef.value,
		cover: url,
	};
	const { validateInfos } = useForm(modelRef, rulesRef);
	formInfos.value = validateInfos;
};

const onSubmit = () => {
	validateForm.value().then(() => {
		const book = modelRef.value;
		emit('onSubmit', book);
	});
};

const onCancel = () => {
	emit('onCancel');
};
</script>

<style lang="less" scoped></style>
