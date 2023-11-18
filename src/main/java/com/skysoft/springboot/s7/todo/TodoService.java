package com.skysoft.springboot.s7.todo;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;

import org.springframework.boot.jdbc.metadata.TomcatDataSourcePoolMetadata;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList();
	private static int id;
//	static {
//		todos.add(new Todo(++id, "hama","Learn AWS", 
//							LocalDate.now().plusYears(1), false ));
//		
//	}
	

	
	public void addTodo(String desc,String username,LocalDate localDate, boolean isDone) {
		++id;
		Todo todo=new Todo(id,username,desc,localDate,isDone);
		todos.add(todo);
	}
	public List<Todo> findByUsername(String userNamwe){
		System.out.print("size :- "+todos.size());
		System.out.print("size :- "+userNamwe);
		Predicate<? super Todo> pre = todo -> todo.getUsername().equalsIgnoreCase(userNamwe);
		
		
		
		
		return todos.stream().filter(pre).toList();
	}
	
	public void deleteById(int id) {
		Predicate<? super Todo> pre =todo1 -> todo1.getId() == id;
		todos.removeIf(pre);
	}
	public Todo findById(int id) {
		Predicate<? super Todo> pre=todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(pre).findFirst().get();
		
		return todo;
		
	}
	public void updateTodo(@Valid Todo todo) {
		
		deleteById(todo.getId());
		todos.add(todo);
		
	}
}
