function superrDuperrApi($http) {

	var API_URL = 'http://localhost:8080/SuperrDuperr/';
	
    this.AddToDoItemList = function(toDoItemListName){
	    return $http.post(API_URL + 'toDo/addNewList/'+ toDoItemListName);
  	}

  	this.AddToDoItem = function(toDoItemValue,selectedList){
	    var todoObj = {
		    toDo: toDoItemValue,
		    tag: "",
		    listName: selectedList,
		    completed: false
	    }

	    return $http.post(API_URL + 'toDo/addItem/'+ selectedList, todoObj)
	    
  	}

  	this.UpdateCheckbox = function(completedFlag, toDoItemValue, selectedList){
	    var todoObj = {
		    toDo: toDoItemValue,
		    tag: "",
		    listName: selectedList,
		    completed: completedFlag
	    }

	    return $http.post(API_URL + 'toDo/addItem/' + selectedList, todoObj);

  	}

  	this.DeleteToDoItem = function(toDoItemValue,selectedList){
        var todoObj = {
		    toDo: toDoItemValue,
		    tag: "",
		    listName: selectedList,
		    completed: false
	    }

        return $http.post(API_URL + 'toDo/deleteItem/' + selectedList, todoObj);
    }

	this.getAllToDoItems = function(){
        return $http.get(API_URL + 'toDo/getAllItems');
    }
}