<template>
	<a-layout>
		<a-layout-sider class="sider">
			<side-menu :menus="menus"></side-menu>
		</a-layout-sider>
		<a-layout-content class="content">
			<books></books>
		</a-layout-content>
	</a-layout>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import Books from './Books.vue';
import SideMenu from '../common/SideMenu.vue';
export default defineComponent({
	components: { SideMenu, Books },
	data() {
		return {
			menus: [
				{
					id: '1',
					name: '全部',
				},
				{
					id: '2',
					name: '文学',
				},
				{
					id: '3',
					name: '流行',
				},
				{
					id: '4',
					name: '文化',
				},
			],
		};
	},
	watch: {},
	computed: {},
	methods: {},
});
</script>

<script setup lang="ts"></script>

<style lang="less" scoped>
.sider {
	margin-top: 20px;
}
.content {
	margin: 20px;
}
</style>
