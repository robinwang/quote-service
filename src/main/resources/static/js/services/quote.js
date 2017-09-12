'use strict'

angular.module('app.services', [])

.factory('QuoteService', function($resource) {
	return $resource('/api/quote/:quote', {quote:'@quote'}, {
		random: {
			method: 'GET',
			url: '/api/quote/random'
		}
	})
});
