<template>
	<div>
		<a-card class="box-card">
			<div class="show-code">Talk is nothing, show you my code.</div>
			<a href="https://github.com/Antabot/White-Jotter" target="_blank">
				<img src="@/assets/img/icon/icon6.png" alt="" class="git-link" />
			</a>
			<a href="https://blog.csdn.net/Neuf_Soleil" target="_blank">
				<img src="@/assets/img/icon/csdn.png" alt="" class="csdn-link" />
			</a>
		</a-card>
	</div>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
export default defineComponent({});
</script>

<style lang="less" scoped>
.box-card {
	width: 100%;
	height: 150px;
	background-color: #222;
	text-align: center;
	margin-top: 5px;
}
.show-code {
	font-size: 30px;
	color: azure;
	white-space: nowrap;
}
.slogan {
	width: 100%;
}

.git-link {
	width: 80px;
}

.csdn-link {
	width: 65px;
	margin-bottom: 7px;
	margin-left: 20px;
}
</style>
