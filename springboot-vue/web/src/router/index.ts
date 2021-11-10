import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router';

const routes: Array<RouteRecordRaw> = [
	{
		path: '/login',
		name: 'Login',
		component: () => import(/* webpackChunkName: "login" */ '@/Login.vue'),
	},
	{
		path: '/home',
		name: 'Home',
		component: () => import(/* webpackChunkName: "home" */ '@/components/layout/Home.vue'),
		redirect: '/index',
		children: [
			{
				path: '/index',
				name: 'AppIndex',
				// route level code-splitting
				// this generates a separate chunk (about.[hash].js) for this route
				// which is lazy-loaded when the route is visited.
				component: () => import(/* webpackChunkName: "index" */ '@/components/home/AppIndex.vue'),
				meta: {
					requireAuth: true,
				},
			},
			{
				path: '/library',
				name: 'Library',
				component: () => import(/* webpackChunkName: "library" */ '@/components/library/LibraryIndex.vue'),
				meta: {
					requireAuth: true,
				},
			},
		],
	},
];

const router = createRouter({
	history: createWebHistory(),
	routes,
});

export default router;
