import { StandardResponse } from '../utils/http.util';

export interface MenuInfo {
	key: string;
	keyPath: string[];
	item: unknown;
	domEvent: MouseEvent;
}

export interface FileItem {
	uid: string;
	name?: string;
	status?: string;
	response?: StandardResponse<string>;
	url?: string;
}

export interface FileInfo {
	file: FileItem;
	fileList: FileItem[];
}
