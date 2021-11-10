<template>
	<a-layout>
		<a-layout-sider class="sider">
			<side-menu :menus="menus"></side-menu>
		</a-layout-sider>
		<a-layout-content class="content">
			<div id="header-div">
				<carousel></carousel>
				<quick-nav class="quick-nav"></quick-nav>
			</div>
			<update-card id="update-card"></update-card>
			<slogan id="slogan"></slogan>
			<about id="about"></about>
		</a-layout-content>
	</a-layout>
</template>

<script>
import { defineComponent } from 'vue';
import Carousel from './Carousel.vue';

export default defineComponent({
	components: { Carousel },
	name: 'AppIndex',
	data() {
		return {
			menus: [
				{
					id: '1',
					name: '技术采用',
					href: '#header-div',
				},
				{
					id: '2',
					name: '最近更新',
					href: '#update-card',
				},
				{
					id: '3',
					name: '下载源码',
					href: '#slogan',
				},
				{
					id: '4',
					name: '关于我们',
					href: '#about',
				},
			],
		};
	},
});
</script>

<script setup>
import SideMenu from '../common/SideMenu.vue';
</script>

<style scoped lang="less">
.sider {
	margin-top: 20px;
}
.content {
	width: 990px;
}
#header-div {
	padding-bottom: 20px;
	padding-left: 5px;
	background-color: white;
	.quick-nav {
		float: right;
		margin-top: -450px;
		margin-right: 480px;
	}
}
</style>
