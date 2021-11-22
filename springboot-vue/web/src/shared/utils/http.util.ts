import { AxiosResponse } from 'axios';

export function isSuccess(res: AxiosResponse) {
	return res.data.code === '200';
}

export function getBody(res: AxiosResponse) {
	return res.data.body;
}
