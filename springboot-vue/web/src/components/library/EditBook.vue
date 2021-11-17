<template>
	<!-- 因为不能定义一个ref(props.value),没有响应式，所以无法使用v-model:visible -->
	<a-modal title="添加/修改图书" :visible="visible" @cancel="onCancel">
		<a-form :label-col="labelCol" :wrapperCol="wrapperCol">
			<a-form-item label="书名" v-bind="validateInfos.title">
				<a-input v-model:value="modelRef.title" placeholder="不加《》"></a-input>
			</a-form-item>
			<a-form-item label="作者" v-bind="validateInfos.author">
				<a-input v-model:value="modelRef.author"></a-input>
			</a-form-item>
			<a-form-item label="出版日期" v-bind="validateInfos.date">
				<a-input v-model:value="modelRef.date"></a-input>
			</a-form-item>
			<a-form-item label="出版社" v-bind="validateInfos.press">
				<a-input v-model:value="modelRef.press"></a-input>
			</a-form-item>
			<a-form-item label="封面" v-bind="validateInfos.cover">
				<a-input v-model:value="modelRef.cover" placeholder="图片 URL"></a-input>
			</a-form-item>
			<a-form-item label="简介" v-bind="validateInfos.abs">
				<a-textarea v-model:value="modelRef.abs"></a-textarea>
			</a-form-item>
			<a-form-item label="分类" v-bind="validateInfos.cid">
				<a-select v-model:value="modelRef.category.id" placeholder="请选择分类">
					<a-select-option value="1">文学</a-select-option>
					<a-select-option value="2">流行</a-select-option>
					<a-select-option value="3">文化</a-select-option>
					<a-select-option value="4">生活</a-select-option>
					<a-select-option value="5">经管</a-select-option>
					<a-select-option value="6">科技</a-select-option>
				</a-select>
			</a-form-item>
		</a-form>
		<template #footer>
			<a-button @click="onCancel">取 消</a-button>
			<a-button type="primary" @click="onSubmit">确 定</a-button>
		</template>
	</a-modal>
</template>

<script lang="ts">
import { defineComponent, defineEmits, defineProps, reactive, ref, toRaw } from 'vue';

export default defineComponent({
	props: {
		visible: {
			type: Boolean,
		},
	},
	data() {
		return {
			labelCol: { span: 4 },
			wrapperCol: { span: 14 },
		};
	},
	emits: ['onSubmit', 'onCancel'],
	watch: {},
	computed: {},
	methods: {},
});
</script>

<script setup lang="ts">
import { BookForm } from '@/domain/library/library.interface';
import { useForm } from 'ant-design-vue/lib/form';

const emit = defineEmits(['onSubmit', 'onCancel']);

const modelRef = reactive<BookForm>({
	id: '',
	title: '',
	author: '',
	date: '',
	press: '',
	cover: '',
	abs: '',
	category: {
		id: '',
		name: '',
	},
});
const rulesRef = reactive({
	title: [
		{
			required: true,
			message: '请输入标题',
		},
	],
});

const { validate, validateInfos } = useForm(modelRef, rulesRef, {
	onValidate: (...args) => console.log(...args),
});

const onSubmit = () => {
	validate().then(() => {
		const book: BookForm = toRaw(modelRef);
		emit('onSubmit', book);
	});
};

const onCancel = () => {
	emit('onCancel');
};
</script>

<style lang="less" scoped></style>
