package com.amar.SpringRestApp.restservice.todo;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.amar.SpringRestApp.restservice.todo.service.TodoJPAService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TodoResource {
	@Autowired
	private TodoJPAService todoJpaService;
	
	@GetMapping("/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable("username") String userName){
		System.out.println("getAllTodos called");
		return todoJpaService.findAll(userName);
	}
	
	@GetMapping("/users/{username}/todos/{id}")
	public Todo getAllTodo(@PathVariable("username") String userName , @PathVariable("id") long id){
		System.out.println("getAllTodo called");
		return todoJpaService.findById(id);
	}
	
	@DeleteMapping("users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable("username") String userName, @PathVariable("id") long id) {
		
		/*if (todo != null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();*/
		todoJpaService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("users/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable("username") String userName, @PathVariable("id") long id , @RequestBody Todo todo) {
		Todo updatedTodo = todoJpaService.updateTodo(todo);	
		return new ResponseEntity<Todo>(updatedTodo,HttpStatus.OK);
	}
	
	@PostMapping("users/{username}/todos/")
	public ResponseEntity<Void> createTodo(@PathVariable("username") String userName , @RequestBody Todo todo) {
		Todo updatedTodo = todoJpaService.saveTodo(todo);
		URI uri= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(updatedTodo.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
