/**
 * 
 */
package org.todo.model;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * @author Nandini Palaniswamy
 *
 */
public class ToDoItemTest extends TestCase {

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	@Test
    public void testSetToDo() {
       ToDoItem item = new ToDoItem();
       item.setToDo("Assignment");
        assertTrue(item.getToDo().equals("Assignment"));
    }
	
	@Test
    public void testGetToDo() {
       ToDoItem item = new ToDoItem();
       item.setToDo("Meeting at 10");
        assertTrue(item.getToDo().equals("Meeting at 10"));
    }

	@Test
    public void testSetIDo() {
       ToDoItem item = new ToDoItem();
       item.setId(new Long("1000"));
        assertTrue(item.getId().equals(new Long(1000)));
    }
	
	@Test
    public void testGetID() {
		ToDoItem item = new ToDoItem();
        item.setId(new Long(2000));
        assertTrue(item.getId().equals(new Long(2000)));
    }
	
	@Test
    public void testSetListName() {
       ToDoItem item = new ToDoItem();
       item.setListName("Company");
        assertTrue(item.getListName().equals("Company"));
    }
	
	@Test
    public void testGetListName() {
		ToDoItem item = new ToDoItem();
        item.setListName("Personnal");
        assertTrue(item.getListName().equals("Personnal"));
    }
	
	@Test
    public void testToString() {
       ToDoItem item = new ToDoItem();
       item.setCompleted(true);
       item.setToDo("Buy Milk");
       item.setListName("Grocery");
       item.setTag("");
        assertTrue(item.toString().equals("ToDoItem [item=" + item.getToDo() + ", list= "+ item.getListName() + ",tag= " + item.getTag()
       	+ ", completed=true]"));    
	}
	
	@Test
    public void testToEquals() {
		ToDoItem item1 = new ToDoItem();
		 item1.setId(new Long(1000));
		 item1.setToDo("Bank Work");
		 item1.setTag("");
		 item1.setListName("personnal");
		 item1.setCompleted(false);
		 
		 ToDoItem item2 = new ToDoItem();
		 item2.setId(new Long(2000));
		 item2.setToDo("Bank Work");
		 item2.setTag("");
		 item2.setListName("personnal");
		 item2.setCompleted(false);
		 
		 assertEquals(item1, item2);
		 assertTrue( item1.hashCode()==item2.hashCode());
		 
	}
	
}
