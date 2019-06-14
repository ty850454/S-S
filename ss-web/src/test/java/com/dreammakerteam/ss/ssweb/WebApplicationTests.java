package com.dreammakerteam.ss.ssweb;

import com.dreammakerteam.ss.ssweb.service.api.TodoService;
import com.dreammakerteam.ss.ssweb.service.dto.TodoDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebApplicationTests {

    @Autowired
    private TodoService todoService;

    @Test
    public void contextLoads() throws JsonProcessingException {
        TodoDTO todo = new TodoDTO();
        todo.setName("待办1");
        todoService.save(todo);



    }

}
