package com.example.ToDoList.service;

import java.util.List;
import java.util.Properties;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.stereotype.Service;

import com.example.ToDoList.entity.todo;
import com.example.ToDoList.repository.TodoRepository;

@Service
public class TodoService {

    private TodoRepository todoRepository;
    

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }


    public List<todo> create(todo Todo){
        todoRepository.save(Todo);
        return list();
    }

    public List<todo> list(){
        org.springframework.data.domain.Sort.by("prioridade").descending().and(
            org.springframework.data.domain.Sort.by("nome").ascending()
        );
        return todoRepository.findAll();
    }

    public List<todo> update(todo Todo){
        todoRepository.save(Todo);
        return list();
    }
    public List<todo> delete(Long id){
        todoRepository.deleteById(id);
        return list();
    }
}
