WhatToReadNext.Router.map(function() {
	this.resource('books', { path: '/' });
});

WhatToReadNext.BooksRoute = Ember.Route.extend({
	model: function() {
		return this.store.find('book');
	}
});
