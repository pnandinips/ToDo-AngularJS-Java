package org.todo.service;

import org.junit.Test;
import org.todo.model.ToDoItem;

import junit.framework.TestCase;

public class ToDoServiceImplTest extends TestCase {

	private ToDoServiceImpl serviceObj = null;
	
	protected void setUp() throws Exception {
		super.setUp();
		serviceObj = new ToDoServiceImpl();
	}
	
	@Test
	public void testAddDelete() {
		serviceObj.addNewList("personnal");

		ToDoItem item1 = new ToDoItem();
		item1.setId(new Long(1000));
		item1.setToDo("Bank Work");
		item1.setTag("");
		item1.setListName("personnal");
		item1.setCompleted(false);

		ToDoItem item2 = new ToDoItem();
		item2.setId(new Long(2000));
		item2.setToDo("Workout");
		item2.setTag("");
		item2.setListName("personnal");
		item2.setCompleted(false);
		serviceObj.addToDoItem("personnal", item1);
		serviceObj.addToDoItem("personnal", item2);

		assertTrue(serviceObj.getAllToDoItems().getToDoItems().size() == 1);
		assertTrue(serviceObj.getAllToDoItems().getToDoItems().get("personnal").size() == 2);

		serviceObj.addNewList("Melbourne Trip");

		ToDoItem item3 = new ToDoItem();
		item3.setId(new Long(3000));
		item3.setToDo("Clothes");
		item3.setTag("");
		item3.setListName("Melbourne Trip");
		item3.setCompleted(false);

		ToDoItem item4 = new ToDoItem();
		item4.setId(new Long(4000));
		item4.setToDo("Jackets");
		item4.setTag("");
		item4.setListName("Melbourne Trip");
		item4.setCompleted(false);
		serviceObj.addToDoItem("Melbourne Trip", item3);
		serviceObj.addToDoItem("Melbourne Trip", item4);

		assertTrue(serviceObj.getAllToDoItems().getToDoItems().size() == 2);
		assertTrue(serviceObj.getAllToDoItems().getToDoItems().get("Melbourne Trip").size() == 2);

		serviceObj.addToDoItem("Melbourne Trip", null);
		assertTrue(serviceObj.getAllToDoItems().getToDoItems().get("Melbourne Trip").size() == 2);

		serviceObj.addNewList(null);
		assertTrue(serviceObj.getAllToDoItems().getToDoItems().size() == 2);

		serviceObj.deleteToDoItem("Melbourne Trip", item3);
		assertTrue(serviceObj.getAllToDoItems().getToDoItems().get("Melbourne Trip").size() == 1);

		serviceObj.deleteToDoItem("Melbourne Trip", item4);
		assertTrue(serviceObj.getAllToDoItems().getToDoItems().size() == 1);

	}
}
