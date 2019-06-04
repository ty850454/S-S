package com.dreammakerteam.ss.ssweb.service.impl.dao.impl;

import com.dreammakerteam.ss.ssweb.service.impl.dao.api.TodoDao;
import com.dreammakerteam.ss.ssweb.service.impl.dao.entity.TodoEntity;
import com.dreammakerteam.ss.ssweb.service.impl.dao.repository.TodoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;


@Repository
public class TodoDaoImpl implements TodoDao {

    private TodoRepository todoRepository;

    public TodoDaoImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public void save(TodoEntity todoEntity) {
        TodoEntity save = todoRepository.save(todoEntity);

        ObjectMapper mapper = new ObjectMapper();
        try {
            System.out.println(mapper.writeValueAsString(save));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
