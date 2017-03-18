package com.myproject.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.todo.dto.TodoDTO;
import com.myproject.todo.entity.Todo;
import com.myproject.todo.service.TodoService;

@RestController
@RequestMapping(consumes = "application/json", produces = "application/json")
class TodoController {

	@Autowired
	private TodoService todoService;
	
	@RequestMapping(value="/todo", method = RequestMethod.POST)
	public Todo createTodo(@RequestBody Todo todo) {
		return todoService.createTodo(todo);
	}
	
	@RequestMapping(value="todo/{id}", method = RequestMethod.GET)
	public Todo retrieveTodo(@PathVariable(name="id") String todoId) {
		return todoService.retrieveTodo(todoId);
	}
	
	@RequestMapping(value="/todo", method = RequestMethod.DELETE)
	public void deleteTodo(@RequestBody Todo todo) {
		todoService.deleteTodo(todo);
	}
	
	@RequestMapping(value="/todo", method = RequestMethod.PUT)
	public Todo updateTodo(@RequestBody Todo todo) {
		return todoService.updateTodo(todo);
	}
	
	@RequestMapping(value="/todos", method = RequestMethod.GET)
	public TodoDTO findAll(){
		TodoDTO dto = new TodoDTO();
		dto.setTodos(todoService.findAll());
		return dto;
	}
}
