import {
	message,
	Button,
	Card,
	Form,
	Input,
	Menu,
	Layout,
	Tooltip,
	Pagination,
	Row,
	Carousel,
	Timeline,
	Modal,
	Select,
	Upload,
} from 'ant-design-vue';
import { App } from 'vue';

export function installAntd(app: App<Element>): void {
	app.config.globalProperties.$message = message;
	app.use(Button);
	app.use(Modal);
	app.use(Card);
	app.use(Form);
	app.use(Select);
	app.use(Layout);
	app.use(Input);
	app.use(Menu);
	app.use(Tooltip);
	app.use(Card);
	app.use(Pagination);
	app.use(Row);
	app.use(Carousel);
	app.use(Timeline);
	app.use(Upload);
}
