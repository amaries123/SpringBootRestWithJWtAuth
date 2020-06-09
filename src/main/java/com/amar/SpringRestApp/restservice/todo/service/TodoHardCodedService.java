package com.amar.SpringRestApp.restservice.todo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.amar.SpringRestApp.restservice.todo.Todo;
@Service
public class TodoHardCodedService {

	private static List<Todo> todos=new ArrayList<Todo>();
	private static Long idounter=0l;
	static {
		todos.add(new Todo(++idounter, "Amar", "learn to dance", new Date(), true));
		todos.add(new Todo(++idounter, "Amar", "learn to Spring boot", new Date(), false));
		todos.add(new Todo(++idounter, "Amar", "learn to Rest", new Date(), false));
		todos.add(new Todo(++idounter, "Amar", "learn to Angular", new Date(), false));
		
	}
	
	public List<Todo> findAll(){
		return todos;
	}
	
	public Todo deleteById(Long id) {
		Todo todo = findById(id);
		if (todos.remove(todo)) {
			return todo;
		}
		return null;
	}

	public Todo findById(Long id) {
		Todo todoByid = null;
		for (Todo todo : todos) {
			if (todo.getId() == id) {
				todoByid = todo;
			}
		}
		return todoByid;
	}
	
	public Todo saveTodo(Todo todo) {
		System.out.println("saveTodo todo"+todo);
		if(todos.contains(todo)) {
			System.out.println("update todo"+todo);
			deleteById(todo.getId());
			todos.add(todo);
		}else {
			System.out.println("insert todo"+todo);
			todo.setId(++idounter);
			todos.add(todo);
		}
		
		return todo;
		
	}
}
