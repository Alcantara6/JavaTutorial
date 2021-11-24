import { onMounted, Ref, ref, watch } from 'vue';
import { Book, BookListProps } from '../interface/library.interface';
import bookService from '../service/bookService';
import { getPaginationBody, getTotal, isSuccess } from '@/shared/utils/http.util';

async function loadBooks(categoryId: number, pageNo: number, pageSize: number) {
	if (categoryId > 0) {
		return await bookService.listByCategory(categoryId, pageNo, pageSize);
	} else {
		return await bookService.getBooks(pageNo, pageSize);
	}
}

export function useBooks(props: BookListProps) {
	const books: Ref<Book[]> = ref([]);
	const currBook: Ref<Book | null> = ref(null);
	const pageNo = ref(1);
	const PAGE_SIZE = 10;
	const total = ref(0);
	const keywords: Ref<string | null> = ref(null);

	onMounted(async () => {
		const res = await loadBooks(props.category, pageNo.value, PAGE_SIZE);
		if (isSuccess(res)) {
			books.value = getPaginationBody(res);
			total.value = getTotal(res);
		}
	});

	watch(
		() => props.category,
		async (categoryId: number) => {
			console.log(categoryId);
			keywords.value = null;
			const res = await loadBooks(categoryId, pageNo.value, PAGE_SIZE);
			if (isSuccess(res)) {
				books.value = getPaginationBody(res);
				total.value = getTotal(res);
			}
		},
	);

	return {
		books,
		currBook,
		pageNo,
		PAGE_SIZE,
		total,
		keywords,
		loadBooks,
	};
}
