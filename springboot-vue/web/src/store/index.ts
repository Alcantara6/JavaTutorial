import { storageService } from '@/shared/storageService';
import { createStore } from 'vuex';
import { AppState, User } from './types/AppState';

const localUser = storageService.getUser();
export default createStore<AppState>({
	state: {
		user: {
			username: localUser === null ? '' : (JSON.parse(localUser) as User).username,
		},
	},

	mutations: {
		login(state: AppState, user: User) {
			state.user = user;
			storageService.setUser(JSON.stringify(user));
		},
		logout(state: AppState) {
			state.user = {
				username: '',
			};
			storageService.removeUser();
		},
	},
});
