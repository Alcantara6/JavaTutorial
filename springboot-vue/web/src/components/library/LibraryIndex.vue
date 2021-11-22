<template>
	<a-layout>
		<a-layout-sider class="sider">
			<side-menu :menus="menus" @change="onCategoryChange"></side-menu>
		</a-layout-sider>
		<a-layout-content class="content">
			<books :category="category"></books>
		</a-layout-content>
	</a-layout>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import Books from './Books.vue';
import SideMenu from '../common/SideMenu.vue';
import { CATEGORY_MENUS } from '@/domain/library/constants/book.constant';
export default defineComponent({
	components: { SideMenu, Books },
	data() {
		return {
			category: 0,
			menus: CATEGORY_MENUS,
		};
	},
	watch: {},
	computed: {},
	methods: {
		onCategoryChange(category: number) {
			this.category = category;
		},
	},
});
</script>

<script setup lang="ts"></script>

<style lang="less" scoped>
.sider {
	margin-top: 46px;
}
.content {
	margin: 60px 15px 15px;
}
</style>
