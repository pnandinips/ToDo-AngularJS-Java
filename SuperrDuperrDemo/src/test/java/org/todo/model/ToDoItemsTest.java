package org.todo.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class ToDoItemsTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetToDoItems() {
		
		 Map<String, ArrayList<ToDoItem>> toDoItems = new HashMap<String, ArrayList<ToDoItem>>();
		 
		 List<ToDoItem> items = new ArrayList<ToDoItem>();
		 
		 ToDoItem item1 = new ToDoItem();
		 item1.setId(new Long(1000));
		 item1.setToDo("Bank Work");
		 item1.setTag("");
		 item1.setListName("personnal");
		 item1.setCompleted(false);
		 items.add(item1);
		 
		 ToDoItem item2 = new ToDoItem();
		 item2.setId(new Long(2000));
		 item2.setToDo("Central Shopping");
		 item2.setTag("");
		 item2.setListName("personnal");
		 item2.setCompleted(false);
		 items.add(item2);
		 
		 ToDoItem item3 = new ToDoItem();
		 item3.setId(new Long(3000));
		 item3.setToDo("Buy Cookware");
		 item3.setTag("");
		 item3.setListName("personnal");
		 item3.setCompleted(false);
		 items.add(item3);
		 
		 ToDoItem item4 = new ToDoItem();
		 item4.setId(new Long(4000));
		 item4.setToDo("Visit Hospital");
		 item4.setTag("");
		 item4.setListName("personnal");
		 item4.setCompleted(true);
		 items.add(item4);
		 
		 toDoItems.put(item4.getListName(), (ArrayList<ToDoItem>) items);
			
		 items = new ArrayList<ToDoItem>();
		 
		 ToDoItem item5 = new ToDoItem();
		 item5.setId(new Long(5000));
		 item5.setToDo("Pack Clothes");
		 item5.setTag("");
		 item5.setListName("Sydney Trip");
		 item5.setCompleted(false);
		 items.add(item5);
		 
		 ToDoItem item6 = new ToDoItem();
		 item6.setId(new Long(6000));
		 item6.setToDo("medicin");
		 item6.setTag("");
		 item6.setListName("Sydney Trip");
		 item6.setCompleted(true);
		 items.add(item6);
		 
		 ToDoItem item7 = new ToDoItem();
		 item7.setId(new Long(7000));
		 item7.setToDo("shoes");
		 item7.setTag("");
		 item7.setListName("Sydney Trip");
		 item7.setCompleted(false);
		 items.add(item7);
		 
		 toDoItems.put(item7.getListName(), (ArrayList<ToDoItem>) items);
		 ToDoItems toDoItemsObj = new ToDoItems();
		 toDoItemsObj.setToDoItems(toDoItems);
		
		assertTrue(toDoItemsObj.getToDoItems().size() == 2);
		assertTrue(toDoItemsObj.getToDoItems().get("personnal").size() == 4);
		assertTrue(toDoItemsObj.getToDoItems().get("Sydney Trip").size() == 3);
		
		Map<String, ArrayList<ToDoItem>> toDoItems1 = (Map<String, ArrayList<ToDoItem>>)toDoItemsObj.getToDoItems();
		toDoItems1.get("personnal").remove(0);
		assertTrue(toDoItemsObj.getToDoItems().get("personnal").size() == 3);

	}

}
