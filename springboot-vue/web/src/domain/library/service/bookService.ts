import { Book } from '../interface/library.interface';
import axios, { AxiosResponse } from 'axios';
import { Page } from '@/shared/interface/pagination';
import { StandardResponse } from '@/shared/utils/http.util';

export default {
	getBooks(pageNo: number, pageSize: number): Promise<AxiosResponse<StandardResponse<Page<Book>>>> {
		return axios.get(`/books?pageNo=${pageNo - 1}&pageSize=${pageSize}`);
	},

	listByCategory(
		categoryId: number,
		pageNo: number,
		pageSize: number,
	): Promise<AxiosResponse<StandardResponse<Page<Book>>>> {
		return axios.get(`/categories/${categoryId}/books?pageNo=${pageNo - 1}&pageSize=${pageSize}`);
	},

	search(keywords: string, pageNo: number, pageSize: number): Promise<AxiosResponse<StandardResponse<Page<Book>>>> {
		return axios.get(`/books/search?keywords=${keywords}&pageNo=${pageNo - 1}&pageSize=${pageSize}`);
	},

	saveOrUpdate(book: Book): Promise<AxiosResponse<void>> {
		return axios.post('/books', book);
	},

	delete(book: Book): Promise<AxiosResponse<string>> {
		return axios.delete(`/books/${book.id}`);
	},
};
