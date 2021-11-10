import { message, Button, Card, Form, Input, Menu } from 'ant-design-vue';
import { App } from 'vue';

export function installAntd(app: App<Element>): void {
	app.config.globalProperties.$message = message;
	app.use(Button);
	app.use(Card);
	app.use(Form);
	app.use(Input);
	app.use(Menu);
}
