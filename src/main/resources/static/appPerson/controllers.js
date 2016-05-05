(function(angular) {
  var AppController = function($scope, Person) {
    Person.query(function(response) {
      $scope.persons = response ? response : [];
    });
    
    $scope.submit = function() {
      new Person({
        placeOfBirth: $scope.placeOfBirth,
        familyName : $scope.familyName,
        givenName : $scope.givenName,
        middleNames : $scope.middleNames,
        twitterId : $scope.twitterId,
        dateOfBirth : $scope.dateOfBirth,
        dateOfDeath : $scope.dateOfDeath
      }).$save(function(person) {
        $scope.persons.push(person);
      });
      $scope.newPerson = "";
    };
    
    $scope.updatePerson = function(person) {
      person.$update();
    };
    
    $scope.deletePerson = function(person) {
      person.$remove(function() {
        $scope.persons.splice($scope.persons.indexOf(person), 1);
      });
    };
  };
  
  AppController.$inject = ['$scope', 'Person'];
  angular.module("myApp.controllers").controller("AppController", AppController);
}(angular));