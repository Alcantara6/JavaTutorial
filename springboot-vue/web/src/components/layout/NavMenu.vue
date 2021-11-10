<template>
	<a-menu v-model:selectedKeys="current" mode="horizontal">
		<a-menu-item v-for="nav of navs" :key="nav.link">
			<router-link :to="nav.link">{{ nav.name }}</router-link>
		</a-menu-item>
		<span class="nav-title">Alcantara6</span>
		<div class="nav-more">
			<AppstoreOutlined />
			<a href="#nowhere">更多功能</a>
		</div>
	</a-menu>
</template>

<script lang="ts">
import { defineComponent } from 'vue';

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

const current = ref<string[]>(['/index']);
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
		right: 20px;
		color: #222;
	}
}
</style>
