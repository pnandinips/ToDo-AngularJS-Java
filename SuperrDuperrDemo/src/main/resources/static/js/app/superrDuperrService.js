function superrDuperrApi($http) {

	var REST_SERVICE_URI = 'http://localhost:8080/SuperrDuperr/';
	
    this.AddToDoItemList = function(toDoItemListName){
	    return $http.post(REST_SERVICE_URI + 'toDo/addNewList/'+ toDoItemListName);
  	}

  	this.AddToDoItem = function(toDoItemValue,selectedList){
	    var postObject = new Object();
	    postObject.toDo = toDoItemValue;
	    postObject.tag = "";
	    postObject.listName = selectedList;
	    postObject.completed = false;

	    return $http.post(REST_SERVICE_URI + 'toDo/addItem/'+ selectedList, postObject)
	    
  	}

  	this.UpdateCheckbox = function(completedFlag, toDoItemValue, selectedList){
	    var postObject = new Object();
	    postObject.toDo = toDoItemValue;
	    postObject.tag = "";
	    postObject.listName = selectedList;
	    postObject.completed = completedFlag;

	    return $http.post(REST_SERVICE_URI + 'toDo/addItem/' + selectedList, postObject);

  	}

  	this.DeleteToDoItem = function(toDoItemValue,selectedList){
        var postObject = new Object();
        postObject.toDo = toDoItemValue;
        postObject.tag = "";
        postObject.listName = selectedList;
        postObject.completed = false;

        return $http.post(REST_SERVICE_URI + 'toDo/deleteItem/' + selectedList, postObject);
    }

	this.getAllToDoItems = function(){
        return $http.get(REST_SERVICE_URI + 'toDo/getAllItems');
    }
}