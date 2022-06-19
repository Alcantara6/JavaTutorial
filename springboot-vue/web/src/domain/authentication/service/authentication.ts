import axios, { AxiosResponse } from 'axios';

export const authenticationService = {
	authentication(): Promise<AxiosResponse> {
		return axios.get('/authentication');
	},
};
