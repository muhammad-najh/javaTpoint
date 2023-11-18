package com.skysoft.springboot.s7.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.skysoft.springboot.s7.JPA.TodoRepository;

import jakarta.validation.Valid;

import java.util.logging.Logger;

@Controller
@SessionAttributes("name")
public class TodoControllerJPA {

	private TodoService ts;
	private TodoRepository todoRepository;
	private Logger logger ;

	public TodoControllerJPA(TodoService ts, TodoRepository todoRepository) {
		super();
		this.ts = ts;
		this.todoRepository=todoRepository;
		 logger = Logger.getLogger(TodoControllerJPA
				 .class.getName());

	}
	
	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();

	}
	
	@RequestMapping("list-todo")
	public String goToTodoPage(ModelMap model){
		
		List<Todo>todos = todoRepository.findByUsername(getLoggedInUsername(model));

		model.addAttribute("todos",todos);
		
		return "listTodos";
	
		
	}
	
	@RequestMapping(value="add-todo",method=RequestMethod.GET)
	public String showNewTodoPage(ModelMap model){
		
	   
	    String name= getLoggedInUsername(model);
		Todo todo=new Todo(0,name,"",LocalDate.now().plusYears(1),false);
	
		model.put("todo", todo);

		return "todo";
	
		
	}
	
	@RequestMapping(value=TodoRoute.ADD_TODO,method=RequestMethod.POST)
	public String addNewTodoPage(ModelMap model,@Valid Todo todo,BindingResult result){
	if(result.hasErrors()) {
	return "todo";
		
	}
	
	String username=getLoggedInUsername(model);
	todo.setUsername(username);
		todoRepository.save(todo);
		return "redirect:list-todo";
		
	}
	
	@RequestMapping(TodoRoute.DELETE_TODO)
	public String deleteTodo(@RequestParam int id) {
	
		todoRepository.deleteById(id);
		return "redirect:list-todo";
		
	}
	
	@RequestMapping(value=TodoRoute.UPDATE_TODO,method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id,ModelMap model) {
	
		Todo todo=todoRepository.findById(id).get();
		model.addAttribute("todo",todo);
		
		return "todo";
		
	}
	
	@RequestMapping(value = TodoRoute.UPDATE_TODO,method = RequestMethod.POST)
	public String UpdateTodo(ModelMap model,@Valid Todo todo,BindingResult result) {
	
		if(result.hasErrors()) {
			logger.warning(result.hasErrors()+"");
			return "todo";
	
		}
		
		String username=getLoggedInUsername(model);
		todo.setUsername(username);
		todoRepository.save(todo);
				
		
		return "redirect:list-todo";
		
		
		
	}
	
	@RequestMapping("welcome")
	public String goToWelcomePage(){

		return "instraction";
	
	} 
}
