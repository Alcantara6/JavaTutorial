import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router';

const routes: Array<RouteRecordRaw> = [
	{
		path: '/login',
		name: 'Login',
		component: () => import(/* webpackChunkName: "login" */ '@/views/Login.vue'),
	},
	{
		path: '/home',
		name: 'Home',
		component: () => import(/* webpackChunkName: "login" */ '@/views/Home.vue'),
		redirect: '/index',
		children: [
			{
				path: '/index',
				name: 'AppIndex',
				// route level code-splitting
				// this generates a separate chunk (about.[hash].js) for this route
				// which is lazy-loaded when the route is visited.
				component: () => import(/* webpackChunkName: "about" */ '@/views/AppIndex.vue'),
				meta: {
					requireAuth: true,
				},
			},
			{
				path: '/library',
				name: 'Library',
				component: () => import(/* webpackChunkName: "about" */ '@/components/library/LibraryIndex.vue'),
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
