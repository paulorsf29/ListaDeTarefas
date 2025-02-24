package com.example.ToDoList.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ToDoList.entity.todo;


public interface TodoRepository extends JpaRepository<todo, Long>{
    
    
} 
