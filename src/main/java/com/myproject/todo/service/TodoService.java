package com.myproject.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.todo.entity.Todo;
import com.myproject.todo.repository.TodoRepository;

@Service
public class TodoService {

	@Autowired
	private TodoRepository repository;
	
	public Todo createTodo(Todo todo) {
		return repository.save(todo);
	}
	
	public Todo retrieveTodo(String id) {
		return repository.findOne(id);
	}
	
	public void deleteTodo(Todo todo) {
		repository.delete(todo);
	}
	
	public Todo updateTodo(Todo todo) {
		Todo existingTodo = repository.findOne(todo.getId());
		existingTodo.setDescription(todo.getDescription());
		existingTodo.setTitle(todo.getTitle());
		return repository.save(existingTodo);
	}
	
	public List<Todo> findAll() {
		return repository.findAll();
	}
}
