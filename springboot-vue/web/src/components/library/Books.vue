<template>
	<div>
		<a-row class="book-row">
			<a-tooltip placement="right" v-for="item in books" :key="item.id">
				<template #title>
					<p>{{ item.title }}</p>
					<p>
						<span>{{ item.author }}</span>
						/
						<span>{{ item.date }}</span>
						/
						<span>{{ item.press }}</span>
					</p>
					<p class="book-abstract">{{ item.abs }}</p>
				</template>
				<!-- 图片card -->
				<a-card hoverable class="book-item" bodyStyle="padding:10px">
					<template #cover>
						<img :src="item.cover" alt="封面" />
					</template>
					<a-card-meta :title="item.title">
						<template #description>{{ item.author }}</template>
					</a-card-meta>
				</a-card>
			</a-tooltip>
		</a-row>
		<a-row>
			<a-pagination v-model:current="currentPage" :defaultPageSize="10" :total="20"></a-pagination>
		</a-row>
	</div>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
export default defineComponent({
	data() {
		return {
			books: [
				{
					id: 1,
					cover: 'https://i.loli.net/2019/04/10/5cada7e73d601.jpg',
					title: '三体',
					author: '刘慈欣',
					date: '2019-05-05',
					press: '重庆出版社',
					abs: '文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……',
				},
				{
					id: 2,
					cover: 'https://i.loli.net/2019/04/10/5cada7e73d601.jpg',
					title: '三体',
					author: '刘慈欣',
					date: '2019-05-05',
					press: '重庆出版社',
					abs: '文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……',
				},
			],
		};
	},
	watch: {},
	computed: {},
	methods: {},
});
</script>

<script setup lang="ts">
import { ref } from 'vue';

const currentPage = ref(1);
</script>

<style lang="less" scoped>
.book-row {
	height: 840px;
}
.book-item {
	width: 155px;
	height: 295px;
	margin: 0 15px 20px 0;
}
</style>
