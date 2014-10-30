App.Router.map(function() {
	this.resource('books', { path: '/' }),
	this.resource('book', { path: '/:book_id' });
});

App.BooksRoute = Ember.Route.extend({
	queryParams: {
		keywords: {
			refreshModel: true
		}
	},
	setupController: function(controller, model) {
		controller.set('model', model);
		var keywords = model.query ? model.query.keywords : null;
		if (keywords) {
			controller.set('search', keywords.join(' '));
		}
	},
	model: function(params) {
		return this.store.find('book', params);
	}
});

App.BookRoute = Ember.Route.extend({
	model: function(params) {
		return this.store.find('book', params.book_id);
	}
});
