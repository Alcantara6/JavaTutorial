<template>
	<nav-menu class="nav-menu"></nav-menu>
	<router-view></router-view>
</template>

<script setup lang="ts"></script>

<script lang="ts">
import { defineComponent } from 'vue';
import NavMenu from './NavMenu.vue';

export default defineComponent({
	components: { NavMenu },
});
</script>

<style lang="less" scoped>
.nav-menu {
	box-shadow: 0 2px 4px 0 rgba(0, 0, 0, 0.05);
	position: fixed;
	left: 0;
	right: 0;
	z-index: 99;
}
</style>
