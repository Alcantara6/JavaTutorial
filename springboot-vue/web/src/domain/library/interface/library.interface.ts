export interface Category {
	id: number | null;
	name: string;
}

export interface Book {
	id: number | null;
	title: string;
	author?: string;
	date?: string;
	press?: string;
	cover?: string;
	abs?: string;
	category: Category;
}

export interface BookFormProps {
	visible: boolean;
	currBook: Book;
}

export interface BookListProps {
	category: number;
}
