<template>
	<div class="footer">
		<div class="container">
			<p class="alt">
				&copy; 版权所有：Evan-Nightly &nbsp;
				<span>技术支持：</span>
				<a href="" target="_blank">Evan & MMK</a>
			</p>
		</div>
	</div>
</template>

<script>
export default {
	name: 'Footer',
};
</script>

<style scoped lang="less">
* {
	margin: 0;
	padding: 0;
	font-family: '微软雅黑', Arial, Helvetica, sans-serif;
}

body {
	font-size: 12px;
}

div {
	font-size: 12px;
}

span {
	font-size: 12px;
}

.footer {
	background: #2b2e33;
	text-align: center;
	.container {
		border-top: 1px #1f1f1f solid;
	}
}

.footer .alt {
	overflow: hidden;
	padding: 20px 0;
	width: 1160px;
	margin: auto;
	color: #999;
	line-height: 0;
}

.footer .alt .foot {
	width: 138px;
	float: left;
}

.footer .alt .foot p {
	color: #fff;
	line-height: 28px;
}

a {
	text-decoration: none;
	color: #999;
}

.footer .alt .foot a {
	color: #999;
	display: block;
	line-height: 24px;
}
</style>
