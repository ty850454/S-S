package com.dreammakerteam.ss.ssweb.service.impl;

import com.dreammakerteam.ss.ssweb.sdk.utils.DtoUtil;
import com.dreammakerteam.ss.ssweb.service.api.TodoService;
import com.dreammakerteam.ss.ssweb.service.dto.TodoDTO;
import com.dreammakerteam.ss.ssweb.service.impl.dao.api.TodoDao;
import com.dreammakerteam.ss.ssweb.service.impl.dao.entity.TodoEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TodoServiceImpl implements TodoService {


    private TodoDao todoDao;

    public TodoServiceImpl(TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(TodoDTO todoDto) {
        todoDao.save(DtoUtil.copyProperties(todoDto, TodoEntity.class));
    }
}
