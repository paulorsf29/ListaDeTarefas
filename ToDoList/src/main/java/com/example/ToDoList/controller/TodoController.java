package com.example.ToDoList.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.ToDoList.entity.todo;
import com.example.ToDoList.service.TodoService;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private TodoService todoService;

    
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    List<todo> create(@RequestBody todo Todo){
        return todoService.create(Todo);
    }
    @GetMapping

    List<todo> list(){
        return todoService.list();
    }
    @PutMapping
    List<todo> update(@RequestBody todo Todo){
        return todoService.update(Todo);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    List<todo> delete(@PathVariable("id") Long id){
        return todoService.delete(id);
    }

}
