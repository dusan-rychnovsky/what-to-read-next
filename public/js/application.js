Ember.Handlebars.helper('truncate', function(str, len) {
  if (str.length > len) {
    return str.substring(0, len - 3) + '...';
  } else {
    return str;
  }
});

window.App = Ember.Application.create();

App.ApplicationAdapter = DS.RESTAdapter.extend({
	host: 'http://localhost:8080'
});

App.BooksController = Ember.ArrayController.extend(Ember.Evented, {
	
	queryParams: ['keywords'],
	keywords: [],
	
	search: '',
	
	actions: {
		doSearch: function() {
			var tokens = this.get('search').split(' ');
			this.set('keywords', tokens);
		}
	}
});
