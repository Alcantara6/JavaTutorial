<template>
	<a-menu v-model:selectedKeys="current" mode="horizontal">
		<a-menu-item v-for="nav of navs" :key="nav.link">
			<router-link :to="nav.link">{{ nav.name }}</router-link>
		</a-menu-item>
		<span class="nav-title">Alcantara6</span>
		<div class="nav-more">
			<AppstoreOutlined />
			<a class="nav-more-link" href="#nowhere">更多功能</a>
		</div>
		<div class="log-out" @click="logout">
			<LogoutOutlined />
			<span>登出</span>
		</div>
	</a-menu>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import { loginService } from '@/domain/authentication/service/loginService';

export default defineComponent({
	data() {
		return {
			navs: [
				{ link: '/index', name: '首页' },
				{ link: '/jotter', name: '笔记本' },
				{ link: '/library', name: '图书馆' },
				{ link: '/admin', name: '个人中心' },
			],
		};
	},
});
</script>

<script setup lang="ts">
import { ref } from 'vue';
import AppstoreOutlined from '@ant-design/icons-vue/AppstoreAddOutlined';
import LogoutOutlined from '@ant-design/icons-vue/LogoutOutlined';
import { AxiosResponse } from 'axios';
import { getBody, getMessage, isSuccess, StandardResponse } from '@/shared/utils/http.util';
import store from '@/store';
import router from '@/router';
import { message } from 'ant-design-vue';

const current = ref<string[]>(['/index']);
const logout = () => {
	loginService.logout().then((res: AxiosResponse<StandardResponse<boolean>>) => {
		if (isSuccess(res) && getBody(res)) {
			store.commit('logout');
			router.replace({ path: '/login' });
		} else {
			message.error(getMessage(res));
		}
	});
};
</script>

<style lang="less" scoped>
.nav {
	&-title {
		position: absolute;
		right: 43%;
		font-size: 20px;
		font-weight: bold;
	}
	&-more {
		position: absolute;
		right: 80px;
		color: #222;
	}
}
.log-out {
	position: absolute;
	right: 20px;
	cursor: pointer;
}
</style>
