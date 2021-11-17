export interface Category {
	id: string;
	name: string;
}

export interface BookForm {
	id: string;
	title: string;
	author?: string;
	date?: string;
	press?: string;
	cover?: string;
	abs?: string;
	category: Category;
}
