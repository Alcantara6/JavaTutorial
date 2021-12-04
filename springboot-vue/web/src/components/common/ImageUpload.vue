<template>
	<!-- name: 发到后台的文件参数名，默认"file" -->
	<a-upload v-model:file-list="fileList" name="file" :action="uploadUrl" @change="handleChange">
		<a-button class="upload-btn" type="primary">
			<upload-outlined></upload-outlined>
			点击上传
		</a-button>
	</a-upload>
</template>

<script lang="ts">
import { defineComponent, ref } from 'vue';
import UploadOutlined from '@ant-design/icons-vue/UploadOutlined';
import { FileInfo, FileItem } from '../../shared/interface/antd.interface';
export default defineComponent({
	props: {
		uploadUrl: {
			type: String,
		},
	},
	emits: ['uploaded'],
});
</script>

<script setup lang="ts">
import { UploadStatus } from '@/shared/constants/antd.constant';
import { message } from 'ant-design-vue';
import { defineEmits } from 'vue';

const emits = defineEmits(['uploaded']);

const fileList = ref<FileItem[]>([]);

// 限制为一张
const updateFileList = (info: FileInfo) => {
	let resFileList = [...info.fileList];
	resFileList = resFileList.slice(-1);
	fileList.value = resFileList;
};

const handleChange = (info: FileInfo) => {
	updateFileList(info);
	const fileName = info.file.name;
	if (info.file.status === UploadStatus.Done) {
		const response = info.file.response;
		if (response !== undefined && response.code === '200') {
			const url = response.body;
			emits('uploaded', url);
			message.success(`${fileName}上传成功`);
		} else {
			message.error(`${fileName}上传失败`);
		}
	} else if (info.file.status === 'error') {
		message.error(`${fileName}上传失败`);
	}
};
</script>

<style lang="less" scoped>
.upload-btn {
	margin: 5px;
}
</style>
