import { createApp } from 'vue';
import App from './App.vue';
import router from './router';

import axios, { Axios } from 'axios';
import { installAntd } from './plugins/antd';
import store from './store';
import { routerBeforeEach } from './router/guard';

declare module '@vue/runtime-core' {
	interface ComponentCustomProperties {
		$axios: Axios;
	}
}

axios.defaults.baseURL = '/api';

const app = createApp(App);
app.config.globalProperties.$axios = axios;
installAntd(app);

routerBeforeEach(router, store);

app.use(router).use(store).mount('#app');
