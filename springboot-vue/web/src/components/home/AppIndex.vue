<template>
	<div class="containter">
		<side-menu id="side-menu"></side-menu>
		<div class="home">
			<div id="header-div">
				<div style="height: 150px"></div>
				<carousel></carousel>
				<quick-nav style="float: right; margin-top: -450px; margin-right: 480px"></quick-nav>
			</div>
			<update-card id="update-card"></update-card>
			<slogan id="slogan"></slogan>
			<about id="about"></about>
		</div>
	</div>
</template>

<script>
import { defineComponent } from 'vue';

export default defineComponent({
	name: 'AppIndex',
});
</script>

<script setup>
import { ref } from 'vue';

const count = ref(0);

// 函数
function log() {
	console.log(count.value++);
}
</script>

<style scoped>
.container {
	margin-top: 40px;
}
</style>
