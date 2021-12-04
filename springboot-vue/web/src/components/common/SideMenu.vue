<template>
	<a-menu class="menu" v-model:selectedKeys="current" @click="onMenuClick">
		<a-menu-item v-for="item in menus" :key="item.id">
			<template #icon>
				<AppstoreOutlined />
			</template>
			<a :href="item.href">
				{{ item.name }}
			</a>
		</a-menu-item>
	</a-menu>
</template>

<script lang="ts">
import { defineComponent, PropType } from 'vue';
import { SideMenu } from '../../shared/interface/common.interface';

export default defineComponent({
	props: {
		menus: {
			type: Array as PropType<SideMenu[]>,
		},
	},
	data() {
		return {};
	},
	emits: ['change'],
	watch: {},
	computed: {},
	methods: {},
});
</script>

<script setup lang="ts">
import { ref } from 'vue';
import { MenuInfo } from '../../shared/interface/antd.interface';
import AppstoreOutlined from '@ant-design/icons-vue/AppstoreOutlined';
import { defineEmits } from 'vue';

const current = ref<number[]>([0]);
const emits = defineEmits(['change']);

const onMenuClick = (e: MenuInfo) => {
	emits('change', e.key);
};
</script>

<style lang="less" scoped>
a {
	text-decoration: none;
	color: inherit;
}
.ant-menu {
	height: 100%;
}
</style>
