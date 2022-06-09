import axios, { AxiosResponse } from 'axios';

export const registerService = {
	register(username: string, password: string): Promise<AxiosResponse> {
		return axios.post('/register', {
			username,
			password,
		});
	},
};
