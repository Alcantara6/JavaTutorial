<template>
	<a-card class="card-carousel">
		<a-carousel class="push" autopaly>
			<div v-for="item in items" :key="item.id">
				<a :href="item.link" target="_blank">
					<img :src="item.img" alt="" class="carousel-img" />
				</a>
				<h3>{{ item.title }}</h3>
			</div>
		</a-carousel>
	</a-card>
</template>

<script setup lang="ts"></script>

<script lang="ts">
import { defineComponent } from 'vue';
export default defineComponent({
	data() {
		return {
			items: [
				{
					id: 1,
					title: 'How2J.cn - Java 全栈学习网站',
					img: require('@/assets/img/carousel/how2j.png'),
					link: 'http://how2j.cn?p=50613',
				},
				{
					id: 2,
					title: 'Vue.js - 渐进式 JavaScript 框架',
					img: require('@/assets/img/carousel/vue.png'),
					link: 'https://cn.vuejs.org/',
				},
				{
					id: 3,
					title: 'element-ui - 网站快速成型工具',
					img: require('@/assets/img/carousel/element.png'),
					link: 'http://element-cn.eleme.io/#/zh-CN',
				},
			],
		};
	},
	watch: {},
	computed: {},
	methods: {},
});
</script>

<style lang="less" scoped>
.card-carousel {
	margin-left: 20px;
	width: 680px;
	height: 320px;
}
.push {
	/*margin-left: -15px;*/
}

.carousel-img {
	height: 100%;
	width: 100%;
	text-align: center;
}

.el-carousel__item:nth-child(2n) {
	background: black;
}
.el-carousel__item:nth-child(2n + 1) {
	background: black;
}

.el-carousel__item h3 {
	color: black;
	font-size: 15px;
	/*line-height: 300px;*/
	bottom: 43px;
	float: left;
	position: relative;
}
</style>
