import { Book } from '../interface/library.interface';
import axios, { AxiosResponse } from 'axios';

export default {
	getBooks(): Promise<AxiosResponse<Book[]>> {
		return axios.get('/books');
	},

	listByCategory(categoryId: number): Promise<AxiosResponse<Book[]>> {
		return axios.get(`/categories/${categoryId}/books`);
	},

	saveOrUpdate(book: Book): Promise<AxiosResponse<void>> {
		return axios.post('/books', book);
	},

	delete(book: Book): Promise<AxiosResponse<string>> {
		return axios.delete(`/books/${book.id}`);
	},
};
