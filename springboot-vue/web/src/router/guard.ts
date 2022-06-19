import { AxiosResponse } from 'axios';
import { authenticationService } from '@/domain/authentication/service/authentication';
import { getBody } from '@/shared/utils/http.util';
import { AppState } from '@/store/types/AppState';
import { NavigationGuardNext, RouteLocationNormalized, Router } from 'vue-router';
import { Store } from 'vuex';

// 注意，不能直接在这个文件执行router.befoereEach，需要导出函数在main.ts执行才生效
export const routerBeforeEach = (router: Router, store: Store<AppState>): void => {
	router.beforeEach(async (to: RouteLocationNormalized, from: RouteLocationNormalized, next: NavigationGuardNext) => {
		if (to.meta['requireAuth']) {
			if (store.state.user) {
				next();
			} else {
				const user = await authentication();
				if (user) {
					store.commit('login', user);
					next();
				} else {
					next({
						path: 'login',
						query: { redirect: to.fullPath },
					});
				}
			}
		} else {
			next();
		}
	});
};

async function authentication() {
	const authRespones: AxiosResponse = await authenticationService.authentication();
	return getBody(authRespones);
}
