WhatToReadNext.Router.map(function() {
	this.resource('books', { path: '/' });
});

WhatToReadNext.BooksRoute = Ember.Route.extend({
	queryParams: {
		keywords: {
			refreshModel: true
		}
	},
	model: function(params) {
		return this.store.find('book', params);
	}
});
