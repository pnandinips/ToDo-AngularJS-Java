package org.todo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.todo.model.ToDoItem;
import org.todo.model.ToDoItems;
import org.springframework.stereotype.Service;

@Service("toDoService")
public class ToDoServiceImpl implements ToDoService{
	
	private ToDoItems toDoItems;
	
	public ToDoServiceImpl(){
		toDoItems = new ToDoItems();
		Map<String, ArrayList<ToDoItem>> newMap = new HashMap<String, ArrayList<ToDoItem>>();
		
		toDoItems.setToDoItems(newMap);
	}	
    
    @Override
    public ToDoItems getAllToDoItems() {
        return toDoItems;
    }

	@Override
	public void addNewList(String newListName) {
		
		if(newListName != null)
			toDoItems.getToDoItems().put(newListName, new ArrayList<ToDoItem>());	
	}

	@Override
	public void addToDoItem(String listName, ToDoItem newToDoItem) {
		ArrayList<ToDoItem> toDoItemList = toDoItems.getToDoItems().get(listName);
		
		boolean foundMatch = false;
		
		for(ToDoItem toDoItem : toDoItemList){
			
			if(newToDoItem != null && toDoItem.equals(newToDoItem)){
				// item already exists. So update the item. 
				foundMatch = true;
				toDoItem.setCompleted(newToDoItem.isCompleted());
				//toDoItem.setReminder(newToDoItem.getReminder());
				toDoItem.setTag(newToDoItem.getTag());
				break;
			}	
		}
		
		if(newToDoItem != null && !foundMatch){
			toDoItemList.add(newToDoItem);
		}
	}

	@Override
	public void deleteToDoItem(String listName, ToDoItem toDoItem) {
		ArrayList<ToDoItem> toDoItemList = toDoItems.getToDoItems().get(listName);
		toDoItemList.remove(toDoItem);
		
		if(toDoItemList.size()==0){
			toDoItems.getToDoItems().remove(listName);
		}
	}  
}
