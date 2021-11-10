import { AppState } from '@/store/types/AppState';
import { NavigationGuardNext, RouteLocationNormalized, Router } from 'vue-router';
import { Store } from 'vuex';

// 注意，不能直接在这个文件执行router.befoereEach，需要导出函数在main.ts执行才生效
export const routerBeforeEach = (router: Router, store: Store<AppState>): void => {
	router.beforeEach((to: RouteLocationNormalized, from: RouteLocationNormalized, next: NavigationGuardNext) => {
		if (to.meta['requireAuth']) {
			if (store.state.user.username) {
				next();
			} else {
				next({
					path: 'login',
					query: { redirect: to.fullPath },
				});
			}
		} else {
			next();
		}
	});
};
