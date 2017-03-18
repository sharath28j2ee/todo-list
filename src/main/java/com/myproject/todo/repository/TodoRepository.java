package com.myproject.todo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.myproject.todo.entity.Todo;

@Repository
public interface TodoRepository extends MongoRepository<Todo, String>{

	public void delete(Todo deleted);
	public List<Todo> findAll();	
	public Todo findOne(String id);
	public Todo save(Todo saved);
}
