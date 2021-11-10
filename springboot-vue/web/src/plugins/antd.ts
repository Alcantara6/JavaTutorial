import { message, Button, Card, Form, Input, Menu, Layout, Tooltip, Pagination, Row } from 'ant-design-vue';
import { App } from 'vue';

export function installAntd(app: App<Element>): void {
	app.config.globalProperties.$message = message;
	app.use(Button);
	app.use(Card);
	app.use(Form);
	app.use(Layout);
	app.use(Input);
	app.use(Menu);
	app.use(Tooltip);
	app.use(Card);
	app.use(Pagination);
	app.use(Row);
}
