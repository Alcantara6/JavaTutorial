import { AxiosResponse } from 'axios';
import { Page } from '../interface/pagination';

export interface StandardResponse<T> {
	code: string;
	message: string;
	body: T;
}

export function isSuccess(res: AxiosResponse) {
	return res.data.code === '200';
}

// 正式项目应该在拦截器中就把AxiosResponse适配了
export function getBody<T>(res: AxiosResponse<StandardResponse<T>>) {
	return res.data.body;
}

export function getPaginationBody<T>(res: AxiosResponse<StandardResponse<Page<T>>>) {
	return res.data.body.content;
}

export function getTotal<T>(res: AxiosResponse<StandardResponse<Page<T>>>) {
	return res.data.body.totalElements;
}
