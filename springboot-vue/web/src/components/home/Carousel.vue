<template>
	<a-card class="card-carousel">
		<a-carousel autopaly>
			<div v-for="item in items" :key="item.id">
				<a :href="item.link" target="_blank">
					<img :src="item.img" alt="" class="carousel-img" />
				</a>
				<h3 class="carousel-title">{{ item.title }}</h3>
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
					img: require('@/assets/img/carousel/1.jpg'),
				},
				{
					id: 2,
					title: 'Vue.js - 渐进式 JavaScript 框架',
					img: require('@/assets/img/carousel/2.jpg'),
					link: 'https://cn.vuejs.org/',
				},
				{
					id: 3,
					title: 'element-ui - 网站快速成型工具',
					img: require('@/assets/img/carousel/3.jpg'),
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
}

.carousel-img {
	height: 100%;
	width: 100%;
	text-align: center;
}

.carousel-title {
	color: black;
	bottom: 43px;
	text-align: center;
}

/** 注意deep */
.ant-carousel :deep(.slick-dots-bottom) {
	bottom: 50px;
}
</style>
