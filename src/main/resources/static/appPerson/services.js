(function(angular) {
  var PersonFactory = function($resource) {
    return $resource('/persons/:id', {
      id: '@id'
    }, {
      update: {
        method: "PUT"
      },
      remove: {
        method: "DELETE"
      }
    });
  };

  PersonFactory.$inject = ['$resource'];
  angular.module("myApp.services").factory("Person", PersonFactory);
}(angular));