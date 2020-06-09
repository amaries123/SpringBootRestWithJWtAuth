package com.amar.SpringRestApp.restservice.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amar.SpringRestApp.restservice.todo.Todo;

@Repository
public interface TodoJPARepository extends JpaRepository<Todo, Long> {
	List<Todo> findByuserName(String userName);

}
