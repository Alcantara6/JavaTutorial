import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router';

const routes: Array<RouteRecordRaw> = [
	{
		path: '/',
		name: 'root',
		redirect: '/index',
	},
	{
		path: '/login',
		name: 'Login',
		component: () => import(/* webpackChunkName: "account" */ '@/Login.vue'),
	},
	{
		path: '/register',
		name: 'Register',
		component: () => import(/* webpackChunkName: "account" */ '@/Register.vue'),
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
