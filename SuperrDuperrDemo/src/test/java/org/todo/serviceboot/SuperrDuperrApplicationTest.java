package org.todo.serviceboot;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.todo.model.ToDoItem;
import org.todo.service.ToDoService;
import org.todo.service.ToDoServiceImpl;
import org.todo.springboot.SuperrDuperrApplication;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

/**
 * @author Josh Long
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SuperrDuperrApplication.class)
@WebAppConfiguration
public class SuperrDuperrApplicationTest {


    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;

    private String userName = "bdussault";

    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    private ToDoService toDoService = new ToDoServiceImpl();

    
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {

        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
            .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
            .findAny()
            .orElse(null);

        assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
    }

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();

        ToDoItem item1 = new ToDoItem();
		item1.setId(new Long(1000));
		item1.setToDo("Bank Work");
		item1.setTag("");
		item1.setListName("personnal");
		item1.setCompleted(false);
		 
		ToDoItem item3 = new ToDoItem();
		item3.setId(new Long(3000));
		item3.setToDo("Clothes");
		item3.setTag("");
		item3.setListName("Melbourne Trip");
		item3.setCompleted(false);
			
		this.toDoService.addNewList("Personnal");	
		this.toDoService.addNewList("Melbourne Trip");	
        this.toDoService.addToDoItem("Personnal", item1);
        this.toDoService.addToDoItem("Melbourne Trip", item3);
     }

    @Test
    public void addNewList() throws Exception {
        mockMvc.perform(post("/SuperrDuperr/toDo/addNewList/grocery"))
                .andExpect(status().isOk());
    }

    @Test
    public void getAllToDoItems() throws Exception {
        mockMvc.perform(get("/SuperrDuperr/toDo/getAllItems"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType));
    }
}
