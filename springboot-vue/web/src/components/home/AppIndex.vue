<template>
	<a-layout>
		<a-layout-sider class="sider">
			<side-menu id="side-menu" :menus="menus"></side-menu>
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
import QuickNav from './QuickNav.vue';
import UpdateCard from './UpdateCard.vue';
import Slogan from './Slogan.vue';
import About from '../common/About.vue';

export default defineComponent({
	components: { Carousel, QuickNav, UpdateCard, Slogan, About },
	name: 'AppIndex',
	data() {
		return {
			menus: [
				{
					id: 1,
					name: '技术采用',
					href: '#header-div',
				},
				{
					id: 2,
					name: '最近更新',
					href: '#update-card',
				},
				{
					id: 3,
					name: '下载源码',
					href: '#slogan',
				},
				{
					id: 4,
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
	margin: 60px 15px 0;
}
#side-menu {
	position: fixed;
	width: 200px;
	left: 0px;
	top: 46px;
}
#header-div {
	padding-bottom: 20px;
	padding-left: 5px;
	margin-bottom: 30px;
	background-color: white;
	.quick-nav {
		float: right;
		margin-top: -315px;
		margin-right: 600px;
	}
}
</style>
