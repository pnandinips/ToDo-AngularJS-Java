function superrDuperrCtrl($scope, $http, superrDuperrApi){

	$scope.foundLists = false;
	$scope.newToDoItemList = null;

	$scope.AddToDoItemList = function(toDoItemListName){
		superrDuperrApi.AddToDoItemList(toDoItemListName).then(function(response){
			$scope.getAllToDoItems();
		});
		$scope.newToDoItemList = null;
	}

	$scope.AddToDoItem = function(toDoItemValue,selectedList){
		superrDuperrApi.AddToDoItem(toDoItemValue,selectedList).then(function(response){
			$scope.getAllToDoItems();
		});

		$scope.newToDoItemValue = null;
		$scope.selectedListName = selectedList;
	}

	$scope.UpdateCheckbox = function(completedFlag, toDoItemValue, selectedList){
		superrDuperrApi.UpdateCheckbox(completedFlag, toDoItemValue, selectedList).then(function(response){
			$scope.getAllToDoItems();
		});
	}

	$scope.DeleteToDoItem = function(toDoItemValue,selectedList){
		superrDuperrApi.DeleteToDoItem(toDoItemValue,selectedList).then(function(response){
			$scope.getAllToDoItems();
		});
	}

	$scope.getAllToDoItems = function(){
		superrDuperrApi.getAllToDoItems().then(function(response){
			$scope.toDoItemLists = response.data.toDoItems;
			$scope.foundLists = (Object.keys($scope.toDoItemLists).length > 0);
		});
	}

	$scope.getAllToDoItems();

}

