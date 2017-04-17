package org.todo.model;

import java.util.ArrayList;
import java.util.Map;

/*
 * Class holds ToDOItems List.
 *  @author Nandini Palaniswamy 
 */
public class ToDoItems {
	
	private Map<String, ArrayList<ToDoItem>> toDoItems;

	public Map<String, ArrayList<ToDoItem>> getToDoItems() {
		return toDoItems;
	}

	public void setToDoItems(Map<String, ArrayList<ToDoItem>> toDoItems) {
		if(toDoItems != null)
			this.toDoItems = toDoItems;
	}
}
