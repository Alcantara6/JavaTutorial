<template>
	<a-card class="box-card">
		<template #header>
			<span class="header">最近更新</span>
		</template>
		<div class="block">
			<a-timeline>
				<a-timeline-item>
					<a-card>
						<h4>实现上传至服务器和输入 URL 两种方式添加封面</h4>
						<p>Evan 提交于 2019/4/13 21:32</p>
					</a-card>
				</a-timeline-item>
				<a-timeline-item>
					<a-card>
						<h4>实现图书分类功能</h4>
						<p>Evan 提交于 2019/4/11 09:02</p>
					</a-card>
				</a-timeline-item>
				<a-timeline-item>
					<a-card>
						<h4>实现图书分页，修复图书添加的 BUG</h4>
						<p>Evan 提交于 2019/4/8 22:10</p>
					</a-card>
				</a-timeline-item>
				<a-timeline-item>
					<a-card>
						<h4>实现搜索框模糊查询</h4>
						<p>Evan 提交于 2019/4/6 19:51</p>
					</a-card>
				</a-timeline-item>
				<a-timeline-item>
					<a-card>
						<h4>实现图书修改功能</h4>
						<p>Evan 提交于 2019/4/5 22:52</p>
					</a-card>
				</a-timeline-item>
			</a-timeline>
		</div>
	</a-card>
</template>

<script setup lang="ts"></script>

<script lang="ts">
import { defineComponent } from 'vue';
export default defineComponent({
	data() {
		return {};
	},
	watch: {},
	computed: {},
	methods: {},
});
</script>

<style lang="less" scoped>
.box-card {
	margin-top: 5px;
	width: 988px;
	height: 1050px;
	text-align: left;
}
.header {
	font-weight: bold;
	font-size: 20px;
}
</style>
