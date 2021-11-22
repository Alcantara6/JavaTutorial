import { useForm } from 'ant-design-vue/lib/form';
import { ref, watch } from 'vue';
import { Book, BookFormProps } from '../interface/library.interface';

function createModelRef(book: Book) {
	// 因为会修改所有属性，所以用ref不用reactive，免得挨个挨个更新属性值
	let modelRef = ref<Book>({
		id: null,
		title: '',
		author: '',
		date: '',
		press: '',
		cover: '',
		abs: '',
		category: {
			id: null,
			name: '',
		},
	});
	if (book != null) {
		modelRef = ref<Book>({ ...book });
	}
	return modelRef;
}

function createRulesRef() {
	return ref({
		title: [
			{
				required: true,
				message: '请输入标题',
			},
		],
	});
}

function createForm(book: Book) {
	const modelRef = createModelRef(book);
	const rulesRef = createRulesRef();
	const { validate, validateInfos } = useForm(modelRef, rulesRef, {
		onValidate: (...args) => console.log(...args),
	});

	return {
		modelRef,
		rulesRef,
		validate,
		validateInfos,
	};
}

export function useBookForm(props: BookFormProps) {
	const { modelRef, rulesRef, validate, validateInfos } = createForm(props.currBook);

	// watch中会更新，因此转成响应式属性
	const formInfos = ref(validateInfos);
	const validateForm = ref(validate);

	watch(
		() => props.currBook,
		(currBook: Book) => {
			const updatedForm = createForm(currBook);
			modelRef.value = updatedForm.modelRef.value;
			rulesRef.value = updatedForm.rulesRef.value;
			formInfos.value = updatedForm.validateInfos;
			validateForm.value = updatedForm.validate;
		},
	);

	return {
		modelRef,
		rulesRef,
		validateForm,
		formInfos,
	};
}
