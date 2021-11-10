<template>
	<a-menu class="categories" v-model:selectedKeys="current" @click="onMenuClick">
		<a-menu-item v-for="item in menus" :key="item.id">
			<template #icon>
				<AppstoreOutlined />
			</template>
			{{ item.name }}
		</a-menu-item>
	</a-menu>
</template>

<script lang="ts">
import { defineComponent, PropType } from 'vue';
import AppstoreOutlined from '@ant-design/icons-vue/AppstoreOutlined';
import { SideMenu } from './common.interface';

export default defineComponent({
	components: {
		AppstoreOutlined,
	},
	props: {
		menus: {
			type: Array as PropType<SideMenu[]>,
		},
	},
	data() {
		return {};
	},
	watch: {},
	computed: {},
	methods: {},
});
</script>

<script setup lang="ts">
import { ref } from 'vue';
import { MenuInfo } from './antd.interface';

const current = ref<string[]>(['1']);

const onMenuClick = (e: MenuInfo) => {
	console.log('click', e);
};
</script>

<style lang="less" scoped></style>
