WhatToReadNext.Author = DS.Model.extend({
	firstname: DS.attr('string'),
	lastname: DS.attr('string'),
	books: DS.hasMany('book', { async: true })
});

WhatToReadNext.Book = DS.Model.extend({
	title: DS.attr('string'),
	authors: DS.hasMany('author', { async: true }),
	description: DS.attr('string'),
	imageUrl: DS.attr('string')
});
