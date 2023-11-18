package com.skysoft.springboot.s7.JPA;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skysoft.springboot.s7.todo.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer>{
	
	public List<Todo>findByUsername (String username);

}
