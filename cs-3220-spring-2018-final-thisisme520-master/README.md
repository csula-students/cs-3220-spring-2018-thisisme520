# CS 3220 Final

In this final, your task is to create a *TODO list application* with simpler
version of _pomodoro timer_. If you are not sure what a pomodoro timer is:
https://en.wikipedia.org/wiki/Pomodoro_Technique

## Demo

![Demo app](http://g.recordit.co/oNeN0Plavh.gif)

## Get Started

To get started, you will need to start off the assignment from
https://classroom.github.com/a/cdsA2dZJ

> This should create an additional _private_ repository for you and no one else

Once you have cloned the repository, you can run the following command to start
off server:

> For those of you who don't remember how to clone the repository, use 
> `git clone {repositoryURL}` command

### Running the application

```
gradle appRun
```

And on the front end side of things, you can run the following command under `client` folder after running `npm install`:

```
npm run build
```

> Upon running the `npm run build` command, it will build the bundled JavaScript
> file to `/src/main/webapp`. This means that you don't need to manually copy
> and paste the file to webapp anymore. They are in the right location.

### Tests

To run tests on Java side on root directory of the project:

```
gradle test
```

To run tests on JavaScript side, run the following command in `client` folder:

```
npm test
```

## Deliverables

| File name | Points |
| :-- | :-- |
| `schema.sql` | 0.5 |
| `TodoDAO.java` | 1.5 |
| `TodoServlet.java` | 1 |
| `index.jsp` | 1 |
| `EditTodoServlet.java` | 1 |
| `edit.jsp` | 0.5 |
| `CompleteTodoServlet.java` | 0.5 |
| `TodoPomodoroServlet.java` | 0.5 |
| `pomodoro.jsp` | 0.5 |
| `timer.js` | 0.5 |
| `utils.js` | 0.5 |
| `pomodoro.js` | 1 |
| `app.js` | 1 |

## Requirements

### Technical

* Application should work in CS 3 server
* No HTML code in Java Servlet
* No Java code in JSP
* Use TodoDAO in all Servlets
* JSP should all be hidden behind `WEB-INF` folder
* Should pass all unit tests

### Functional

* User should be able to add a todo item
* User should be able to edit a todo item
* User should be able to complete a todo item
* User should be able to start pomodoro timer on a todo item
* User should be able to track how many pomodoro counter for an item

## Hints

It may feel quite overwhelmed looking at all functionalities and files all
together. Here is suggested steps to finish this application:

1. Define `schema.sql`
2. Implement the `TodoDAO.java` and pass its unit test
3. `TodoServlet.java`
	* Render the JSP pages
	* Handle adding a new TODO Item in `doPost`
4. `EditTodoServlet.java`
	* Render the edit page
	* Handle editing the existing item in `doPost`
5. `CompleteTodoServlet.java`
	* Handle completing a todo list item in `doGet`
6. `TodoPomodoroServlet.java`
	* Render the pomodoro page
		- Need to import the `app.bundle.js` script
		- Use `pomodoro-timer` _custom element_
        - Should display both description, pomodoro counter
        - Pass in the `todo.id` to `window.todoID`
	* Handle increment pomodoro counter in `doPost`
7. `timer.js` and pass its unit test
8. `utils.js` and pass its unit test
9. `pomodoro.js` and pass its unit test
10. `app.js` and glue every js modules above together

At the end of the implementation, you should have the following URLs done:

```
GET /todo -> render index page
POST /todo -> add item
GET  /todo/edit?id=? -> render edit page
POST /todo/edit?id=? -> edit item
POST /todo/complete?id=? -> complete an item
GET /todo/pomodoro?id=? -> render pomodoro clock for an item
POST /todo/pomodoro?id=? -> increment pomodoro counter
```
