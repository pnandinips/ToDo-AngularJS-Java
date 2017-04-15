'use strict';

var superrDuperrApp = angular.module('SuperrDuperrApp', []);

superrDuperrApp.controller("superrDuperrCtrl",superrDuperrCtrl);

function superrDuperrCtrl($scope,$http){
	

	  console.log("superrDuperrCtrl");

	  var REST_SERVICE_URI = 'http://localhost:8080/SuperrDuperr/';

	  $scope.foundLists = 'No';

	  $scope.AddToDoItemList = function(toDoItemListName){
	    console.log("AddToDoItemList");
	    console.log(toDoItemListName);

	    $http.post(REST_SERVICE_URI + 'toDo/addNewList/'+ toDoItemListName).then(function(response){
	        $scope.getAllToDoItems();
	    });
	    $scope.newToDoItemList = null;
	  }

	  $scope.AddToDoItem = function(toDoItemValue,selectedList){
	    console.log("AddToDoItem");
	    console.log(toDoItemValue);
	    console.log(selectedList);

	    var postObject = new Object();
	    postObject.toDo = toDoItemValue;
	    postObject.tag = "";
	    postObject.listName = selectedList;
	    postObject.completed = false;

	    $http.post(REST_SERVICE_URI + 'toDo/addItem/'+ selectedList, postObject).then(function(response){
	            $scope.getAllToDoItems();
	      });

	    console.log("AddToDoItem Success");
	    $scope.newToDoItemValue = null;
	    $scope.selectedListName = null;
	  }

	  $scope.UpdateCheckbox = function(completedFlag, toDoItemValue, selectedList){
	    console.log("UpdateCheckbox");
	    console.log(completedFlag);
	    console.log(toDoItemValue);
	    console.log(selectedList);

	    var postObject = new Object();
	    postObject.toDo = toDoItemValue;
	    postObject.tag = "";
	    postObject.listName = selectedList;
	    postObject.completed = completedFlag;

	    $http.post(REST_SERVICE_URI + 'toDo/addItem/' + selectedList, postObject).then(function(response){
	        $scope.getAllToDoItems();
	    });

	  }

	  $scope.DeleteToDoItem = function(toDoItemValue,selectedList){
	        console.log("DeleteToDoItem");
	        console.log(selectedList);
	        console.log(toDoItemValue);

	        var postObject = new Object();
	        postObject.toDo = toDoItemValue;
	        postObject.tag = "";
	        postObject.listName = selectedList;
	        postObject.completed = false;

	        $http.post(REST_SERVICE_URI + 'toDo/deleteItem/' + selectedList, postObject).then(function(response){
	            $scope.getAllToDoItems();
	        });
	    }

	  $scope.getAllToDoItems = function(){
	        console.log("GetAllToDoItems");

	        $http.get(REST_SERVICE_URI + 'toDo/getAllItems').then(function(response){
	          $scope.toDoItemLists = response.data.toDoItems;
	          if(Object.keys($scope.toDoItemLists).length === 0){
	            $scope.foundLists = 'No';
	          }else{
	            $scope.foundLists = 'Yes';
	          }
	          console.log($scope.foundLists);
	          console.log($scope.toDoItemLists);
	        });

	        console.log("GetAllToDoItems Success")
	    }

	$scope.getAllToDoItems();

	$scope.changeFocus = function(){
	  document.getElementById("focus-me").focus();
	}
}
