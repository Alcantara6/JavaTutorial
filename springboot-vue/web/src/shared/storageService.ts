export const storageService = {
	get(key: string): string | null {
		return window.localStorage.getItem(key);
	},

	set(key: string, value: string): void {
		window.localStorage.setItem(key, value);
	},

	getUser(): string | null {
		return this.get('user' || '[]');
	},

	setUser(value: string): void {
		return this.set('user' || '[]', value);
	},
};
