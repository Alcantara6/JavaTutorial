<template>
	<div @click="log">Hello World! {{ count }}</div>
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

<style scoped></style>
