window.WhatToReadNext = Ember.Application.create();

WhatToReadNext.ApplicationAdapter = DS.RESTAdapter.extend({
	host: 'http://localhost:8080'
});
