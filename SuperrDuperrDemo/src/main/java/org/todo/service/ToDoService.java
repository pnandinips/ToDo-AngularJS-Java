package org.todo.service;

import org.todo.model.ToDoItem;
import org.todo.model.ToDoItems;

public interface ToDoService {
	
	public ToDoItems getAllToDoItems();	
	public void addNewList(String newListName);
    public void addToDoItem(String listName, ToDoItem toDoItem);
    public void deleteToDoItem(String listName, ToDoItem toDoItem);
}
