<template>
	<div>
		<a-card class="box-card">
			<div class="show-code">Talk is nothing, show you my code.</div>
			<div class="slogans">
				<a href="https://github.com/Antabot/White-Jotter" class="slogan-icon" target="_blank">
					<img src="@/assets/img/icon/icon7.png" alt="" />
				</a>
				<a href="https://blog.csdn.net/Neuf_Soleil" class="slogan-icon" target="_blank">
					<img src="@/assets/img/icon/csdn.png" alt="" />
				</a>
			</div>
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
	font-size: 18px;
	color: azure;
	white-space: nowrap;
}
.slogan {
	width: 100%;
}

.slogans {
	display: flex;
	justify-content: center;
}
.slogan-icon {
	img {
		width: 40px;
		margin: 20px 10px 0;
		display: block;
	}
}
</style>
