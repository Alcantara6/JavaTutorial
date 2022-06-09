<template>
	<div class="wall-paper">
		<a-card class="register-container">
			<h3 class="register-title">用户注册</h3>
			<a-form :labelCol="{ style: { width: '80px' } }" :wrapperCol="{ span: 14 }">
				<a-form-item label="账号" v-bind="validateInfos.username">
					<a-input v-model:value="modelRef.username" placeholder="请输入用户名" />
				</a-form-item>
				<a-form-item label="密码" v-bind="validateInfos.password">
					<a-input type="password" v-model:value="modelRef.password" placeholder="请输入密码" />
				</a-form-item>
				<a-form-item :wrapperCol="{ span: 14, offset: 2 }">
					<a-button type="primary" @click="register">注册</a-button>
				</a-form-item>
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
import { registerService } from '@/domain/authentication/service/registerService';
import router from '@/router';
import { AxiosResponse } from 'axios';
import { isSuccess, StandardResponse } from '@/shared/utils/http.util';
import { message } from 'ant-design-vue';
import { User } from './store/types/AppState';

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

const register = () =>
	validate()
		.then(() => registerService.register(modelRef.username, modelRef.password))
		.then((res: AxiosResponse<StandardResponse<User>>) => {
			if (isSuccess(res)) {
				message.info('注册成功，跳转到登录');
				router.replace({ path: '/login' });
			} else {
				message.error(res.data.message);
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
	background: url('~@/assets/img/senery.png') no-repeat;
	background-position: center;
	background-size: cover;
	position: fixed;
	left: 0;
	right: 0;
	top: 0;
	bottom: 0;
}

.register-container {
	border-radius: 15px;
	background-clip: padding-box;
	width: 450px;
	background: #fff;
	border: 1px solid #eaeaea;
	box-shadow: 0 0 25px #cac6c6;
}

.register-title {
	margin: 0px auto 40px;
	text-align: center;
	color: #505458;
}
</style>
