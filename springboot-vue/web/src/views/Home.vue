<template>
	<nav-menu></nav-menu>
	<router-view></router-view>
</template>

<script setup lang="ts"></script>

<script lang="ts">
import { defineComponent } from 'vue';
import NavMenu from './layout/NavMenu.vue';

export default defineComponent({
	components: { NavMenu },
});
</script>

<style lang="less" scoped></style>
