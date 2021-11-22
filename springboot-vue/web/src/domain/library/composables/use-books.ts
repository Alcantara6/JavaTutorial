import { onMounted, Ref, ref, watch } from 'vue';
import { Book, BookListProps } from '../interface/library.interface';
import bookService from '../service/bookService';
import { AxiosResponse } from 'axios';
import { getBody, isSuccess } from '@/shared/utils/http.util';

async function loadBooks(categoryId: number) {
	if (categoryId > 0) {
		return await listByCategory(categoryId);
	} else {
		return await listAllBooks();
	}
}

async function listAllBooks() {
	return await bookService.getBooks().then((res: AxiosResponse) => {
		if (isSuccess(res)) {
			return getBody(res);
		}
		return [];
	});
}

async function listByCategory(categoryId: number) {
	return await bookService.listByCategory(categoryId).then((res: AxiosResponse) => {
		if (isSuccess(res)) {
			return getBody(res);
		}
		return [];
	});
}

export function useBooks(props: BookListProps) {
	const books: Ref<Book[]> = ref([]);
	const currBook: Ref<Book | null> = ref(null);

	onMounted(async () => {
		books.value = await loadBooks(props.category);
	});

	watch(
		() => props.category,
		async (categoryId: number) => {
			books.value = await loadBooks(categoryId);
		},
	);

	return {
		books,
		currBook,
		loadBooks,
		listByCategory,
	};
}
