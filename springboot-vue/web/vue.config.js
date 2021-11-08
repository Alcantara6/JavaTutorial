module.exports = {
	publicPath: '.',
	configureWebpack: (config) => {
		config.devServer = {
			disableHostCheck: true,
			proxy: {
				'/api': {
					target: 'http://localhost:8443',
					changeOrigin: true,
					pathRewrite: {
						'^/api': '',
					},
				},
			},
		};
	},
	css: {
		loaderOptions: {
			less: {
				lessOptions: {
					javascriptEnabled: true,
				},
			},
		},
	},
};
