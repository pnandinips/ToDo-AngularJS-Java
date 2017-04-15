package org.todo.springboot;

import org.todo.model.ToDoItem;
import org.todo.model.ToDoItems;
import org.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages={"org.todo"})
@RestController
public class SuperrDuperrDemoApplication {
	
	@Autowired
	private ToDoService toDoService;
	
	@RequestMapping(value = "/SuperrDuperr/toDo/addNewList/{toDoItemListName}", method=RequestMethod.POST)
    public @ResponseBody void addNewList(@PathVariable("toDoItemListName") String toDoItemListName){
        toDoService.addNewList(toDoItemListName);
    }
 	
 	
 	@RequestMapping(value = "/SuperrDuperr/toDo/getAllItems", method=RequestMethod.GET)
    public @ResponseBody ToDoItems getAllToDoItems(){
        return toDoService.getAllToDoItems();
    }
 
 	
    @RequestMapping(value = "/SuperrDuperr/toDo/addItem/{toDoItemListName}", method = RequestMethod.POST)
    public @ResponseBody void addToDoItem(@PathVariable("toDoItemListName") String toDoItemListName, @RequestBody ToDoItem toDoItem){
        toDoService.addToDoItem(toDoItemListName, toDoItem);
    }

 	
    @RequestMapping(value = "/SuperrDuperr/toDo/deleteItem/{toDoItemListName}", method = RequestMethod.POST)
    public @ResponseBody void deleteToDoItem(@PathVariable("toDoItemListName") String toDoItemListName, @RequestBody ToDoItem toDoItem){
        toDoService.deleteToDoItem(toDoItemListName, toDoItem);
    }

	public static void main(String[] args) {
		SpringApplication.run(SuperrDuperrDemoApplication.class, args);
	}
}
