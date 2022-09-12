import axios, { AxiosResponse } from 'axios';
import { StandardResponse } from '@/shared/utils/http.util';

export default {
	getMenu(): Promise<AxiosResponse<StandardResponse<any[]>>> {
		return axios.get(`/user/menu`);
	},
};
