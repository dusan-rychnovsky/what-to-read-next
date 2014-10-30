Ember.Handlebars.helper('truncate', function(str, len) {
  if (str.length > len) {
    return str.substring(0, len - 3) + '...';
  } else {
    return str;
  }
});

window.WhatToReadNext = Ember.Application.create();

WhatToReadNext.ApplicationAdapter = DS.RESTAdapter.extend({
	host: 'http://localhost:8080'
});

WhatToReadNext.BooksController = Ember.ArrayController.extend(Ember.Evented, {
	
	queryParams: ['keywords'],
	keywords: [],
	
	search: "",
	
	actions: {
		doSearch: function() {
			var tokens = this.get('search').split(' ');
			this.set('keywords', tokens);
		}
	}
});
