package com.myproject.todo.controller

import com.myproject.todo.entity.Todo
import com.myproject.todo.service.TodoService
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import static org.springframework.http.HttpStatus.*

import spock.lang.Specification

class TodoControllerSpec extends Specification {
	def todoController = new TodoController()
	def todoService = Mock(TodoService)
	
	MockMvc mockMvc = MockMvcBuilders.standaloneSetup(todoController).build()
	
	def setup(){
		todoController.todoService = todoService
	}

	def 'get list of todos'() {
		when:
			mockMvc.perform(get('/todos'))
			
		then:
			1 * todoService.findAll()
	}
}
