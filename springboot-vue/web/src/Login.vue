<template>
	<div class="wall-paper">
		<a-card class="login-container">
			<h3 class="login-title">系统登录</h3>
			<a-form :labelCol="labelCol" :wrapperCol="wrapperCol">
				<a-form-item label="用户名" v-bind="validateInfos.username">
					<a-input v-model:value="modelRef.username" placeholder="请输入用户名" />
				</a-form-item>
				<a-form-item label="密码" v-bind="validateInfos.password">
					<a-input type="password" v-model:value="modelRef.password" placeholder="请输入密码" />
				</a-form-item>
				<a-form-item :wrapperCol="{ span: 14, offset: 2 }">
					<a-button type="primary" @click="login">登录</a-button>
				</a-form-item>
				<router-link class="login-to-register" to="/register">注册</router-link>
			</a-form>
		</a-card>
	</div>
</template>

<script lang="ts">
import { defineComponent } from 'vue';

export default defineComponent({
	data() {
		return {
			responseResult: [],
		};
	},
});
</script>

<script setup lang="ts">
import { Form } from 'ant-design-vue';
import { reactive } from 'vue';
import { loginService } from '@/domain/authentication/service/loginService';
import router from '@/router';
import { useStore } from 'vuex';
import { User } from '@/store/types/AppState';
import { useRoute } from 'vue-router';
import { AxiosResponse } from 'axios';
import { isSuccess, getBody, StandardResponse, getMessage } from '@/shared/utils/http.util';
import { message } from 'ant-design-vue';

const store = useStore();
const route = useRoute();
const labelCol = { style: { width: '80px' } };
const wrapperCol = { span: 14 };
const useForm = Form.useForm;
const modelRef = reactive({
	username: '',
	password: '',
});
const rulesRef = reactive({
	username: [
		{
			required: true,
			message: '请输入用户名',
		},
	],
	password: [
		{
			required: true,
			message: '请输入密码',
		},
	],
});

const { validate, validateInfos } = useForm(modelRef, rulesRef, {
	onValidate: (...args) => console.log(...args),
});

/** 默认跳到index */
const getRedirectPath = (): string => {
	const path = route.query.redirect as string;
	return path === '/' || path === undefined ? '/index' : path;
};

const login = () =>
	validate()
		.then(() => loginService.login(modelRef.username, modelRef.password))
		.then((res: AxiosResponse<StandardResponse<User>>) => {
			if (isSuccess(res)) {
				const user: User = getBody(res);
				store.commit('login', user);
				router.replace({ path: getRedirectPath() });
			} else {
				message.error(getMessage(res));
			}
		})
		.catch((failResponse) => {
			console.log(failResponse);
		});
</script>

<style scoped lang="less">
body {
	margin: 0px;
}

.wall-paper {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	background: url('~@/assets/img/poster.jpg') no-repeat;
	background-position: center;
	background-size: cover;
	position: fixed;
	left: 0;
	right: 0;
	top: 0;
	bottom: 0;
}

.login-container {
	border-radius: 15px;
	background-clip: padding-box;
	width: 450px;
	background: #fff;
	border: 1px solid #eaeaea;
	box-shadow: 0 0 25px #cac6c6;
}

.login-title {
	margin: 0px auto 40px;
	text-align: center;
	color: #505458;
}

.login-to-register {
	float: right;
}
</style>
