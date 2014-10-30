App.Router.map(function() {
	this.resource('books', { path: '/' });
});

App.BooksRoute = Ember.Route.extend({
	queryParams: {
		keywords: {
			refreshModel: true
		}
	},
	model: function(params) {
		return this.store.find('book', params);
	}
});
