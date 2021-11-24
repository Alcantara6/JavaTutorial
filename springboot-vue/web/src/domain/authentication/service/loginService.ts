import axios, { AxiosResponse } from 'axios';

export const loginService = {
	login(username: string, password: string): Promise<AxiosResponse> {
		return axios.post('/login', {
			username,
			password,
		});
	},
};