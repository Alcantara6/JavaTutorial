import { createApp } from 'vue';
import App from './App.vue';
import router from './router';

import axios, { Axios } from 'axios';
import { installAntd } from './plugins/antd';

declare module '@vue/runtime-core' {
	interface ComponentCustomProperties {
		$axios: Axios;
	}
}

axios.defaults.baseURL = '/api';

const app = createApp(App);
app.config.globalProperties.$axios = axios;
installAntd(app);

app.use(router).mount('#app');
