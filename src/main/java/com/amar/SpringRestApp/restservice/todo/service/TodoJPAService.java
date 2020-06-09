package com.amar.SpringRestApp.restservice.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amar.SpringRestApp.restservice.todo.Todo;
import com.amar.SpringRestApp.restservice.todo.repository.TodoJPARepository;
@Service
public class TodoJPAService {
	@Autowired
	private TodoJPARepository todoJpaRepostory;

	public List<Todo> findAll(String userName) {
		return todoJpaRepostory.findByuserName(userName);
	}

	public Todo deleteById(Long id) {
		Todo todo = todoJpaRepostory.findById(id).get();
		return todo;
	}

	public Todo findById(Long id) {
		Todo todoByid = todoJpaRepostory.findById(id).get();
		return todoByid;
	}

	public Todo updateTodo(Todo todo) {
		System.out.println("updateTodo todo" + todo);
			deleteById(todo.getId());
			todoJpaRepostory.save(todo);
		return todo;
	}
	
	public Todo saveTodo(Todo todo) {
	System.out.println("insert todo" + todo);
	todoJpaRepostory.save(todo);
	return todo;
	}
}

