package com.myproject.todo.dto;

import java.util.List;

import com.myproject.todo.entity.Todo;

public class TodoDTO {
	
	List<Todo> todos;

	public List<Todo> getTodos() {
		return todos;
	}

	public void setTodos(List<Todo> todos) {
		this.todos = todos;
	}
}
