package edu.csula.cs3220.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import java.sql.*;

import edu.csula.cs3220.models.Todo;

public class TodoDAO {
	private Database context;

	protected static final String getAllQuery = "todos";
	protected static final String getByIdQuery = "";
	protected static final String addQuery = "";
	protected static final String setQuery = "";
	protected static final String completeQuery = "";
	protected static final String incrementPomodoroCounterQuery = "";

	public TodoDAO(Database context) {
		this.context = context;
	}

	public List<Todo> getAll() {
		// TODO: retrieve a list of todo items that is not yet completd
      Object todos = context.getAttribute(getAllQuery);
      if (todos ==null){
         return new ArrayList<>();
         }
         return (ArrayList<Todo>) todos;
	}

	public Optional<Todo> getById(int id) {
		// TODO: getting a specific todo item by id
		Optional<Todo> result = Optional.empty();
		return result;
      
      List<Todo> todos = getAll();
      for (Todo todo : todos){
         if(todo.getId() == id){
            return Optional.of(todo);
            }
           }
		return Optional.empty();
	}
	

	public void add(String desc) {
		// TODO: add a new todo list item
      List<Todo> todos = getAll();
      todos.add(desc);
      context.setAttribute(getAllQuery, todos);
	}


	public void set(int id, String description) {
		// TODO: update specific todo item by id (should only update description)
      List<Todo> todos = getAll();
      for(int i=0; i< todos.size();i++){
         if(todos.get(i).getId() == id)
            todos.set(i,description);
            }
      context.setAttribute(getAllQuery, todos);
	}

	public void complete(int id) {
		// TODO: complete a specific todo item by id

	}

	public void incrementPomodoroCounter(int id) {
		// TODO: increment pomodoro counter of the todo item by id
	}
}
