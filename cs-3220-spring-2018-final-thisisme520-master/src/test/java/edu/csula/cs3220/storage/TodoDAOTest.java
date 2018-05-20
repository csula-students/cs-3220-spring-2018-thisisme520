package edu.csula.cs3220.storage;

import edu.csula.cs3220.models.Todo;
import edu.csula.cs3220.storage.Database;
import edu.csula.cs3220.storage.TodoDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.sql.*;

import org.junit.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TodoDAOTest {
	private Database context;
	private TodoDAO dao;

	@Test
	public void getAll() throws Exception {
		ResultSet rs = mock(ResultSet.class);
		when(rs.next()).thenReturn(true).thenReturn(false);
		when(rs.getInt(1)).thenReturn(1);
		when(rs.getString(2)).thenReturn("first todo");
		when(rs.getBoolean(3)).thenReturn(false);
		when(rs.getInt(4)).thenReturn(0);

		Statement stmt = mock(Statement.class); 
		when(stmt.executeQuery(TodoDAO.getAllQuery)).thenReturn(rs);

		Connection c = mock(Connection.class);
		when(c.createStatement()).thenReturn(stmt);

		context = mock(Database.class);
		when(context.getConnection()).thenReturn(c);

		dao = new TodoDAO(context);

		// set up initial mock state
		List<Todo> mock = new ArrayList<>();
		mock.add(new Todo(1, "first todo", false, 0));

		// actual method execution
		List<Todo> actual = dao.getAll();

		// assert and verify
		assertEquals(1, actual.size());
	}

	@Test
	public void getById() throws Exception {
		ResultSet rs = mock(ResultSet.class);
		when(rs.next()).thenReturn(true).thenReturn(false);
		when(rs.getInt(1)).thenReturn(1);
		when(rs.getString(2)).thenReturn("first todo");
		when(rs.getBoolean(3)).thenReturn(false);
		when(rs.getInt(4)).thenReturn(0);

		PreparedStatement stmt = mock(PreparedStatement.class); 
		doNothing().when(stmt).setInt(anyInt(), anyInt());
		when(stmt.executeQuery()).thenReturn(rs);

		Connection c = mock(Connection.class);
		when(c.prepareStatement(TodoDAO.getByIdQuery)).thenReturn(stmt);

		context = mock(Database.class);
		when(context.getConnection()).thenReturn(c);

		dao = new TodoDAO(context);

		// actual method execution
		Optional<Todo> actual = dao.getById(1);

		// assert and verify
		assertTrue(actual.isPresent());
		assertEquals(actual.get(), new Todo(1, "first todo", false, 0));
	}

	@Test
	public void set() throws Exception {
		PreparedStatement statement = mock(PreparedStatement.class);
		doNothing().when(statement).setString(anyInt(), anyString());
		doNothing().when(statement).setInt(anyInt(), anyInt());
		when(statement.executeUpdate()).thenReturn(1);

		Connection getAllConnection = mock(Connection.class);
		when(getAllConnection.prepareStatement(TodoDAO.setQuery)).thenReturn(statement);

		context = mock(Database.class);
		when(context.getConnection()).thenReturn(getAllConnection);

		dao = new TodoDAO(context);

		// actual execution
		dao.set(1, "updated description");

		// verify
		verify(getAllConnection, times(1)).prepareStatement(TodoDAO.setQuery);
		verify(statement, times(1)).executeUpdate();
	}

	@Test
	public void add() throws Exception {
		PreparedStatement addStatement = mock(PreparedStatement.class);
		doNothing().when(addStatement).setString(anyInt(), anyString());
		when(addStatement.executeUpdate()).thenReturn(1);

		Connection getAllConnection = mock(Connection.class);
		when(getAllConnection.prepareStatement(TodoDAO.addQuery)).thenReturn(addStatement);

		context = mock(Database.class);
		when(context.getConnection()).thenReturn(getAllConnection);

		dao = new TodoDAO(context);

		// actual execution
		dao.add("new todo item");

		// verify
		verify(getAllConnection, times(1)).prepareStatement(TodoDAO.addQuery);
		verify(addStatement, times(1)).executeUpdate();
	}

	@Test
	public void complete() throws Exception {
		PreparedStatement stmt = mock(PreparedStatement.class);
		doNothing().when(stmt).setInt(anyInt(), anyInt());
		when(stmt.executeUpdate()).thenReturn(1);

		Connection c = mock(Connection.class);
		when(c.prepareStatement(TodoDAO.completeQuery)).thenReturn(stmt);

		context = mock(Database.class);
		when(context.getConnection()).thenReturn(c);

		dao = new TodoDAO(context);

		// actual execution
		dao.complete(1);

		// verify
		verify(c, times(1)).prepareStatement(TodoDAO.completeQuery);
		verify(stmt, times(1)).executeUpdate();
	}

	@Test
	public void incrementPomodoroCounter() throws Exception {
		PreparedStatement stmt = mock(PreparedStatement.class);
		doNothing().when(stmt).setString(anyInt(), anyString());
		when(stmt.executeUpdate()).thenReturn(1);

		Connection c = mock(Connection.class);
		when(c.prepareStatement(TodoDAO.incrementPomodoroCounterQuery)).thenReturn(stmt);

		context = mock(Database.class);
		when(context.getConnection()).thenReturn(c);

		dao = new TodoDAO(context);

		// actual execution
		dao.incrementPomodoroCounter(1);

		// verify
		verify(c, times(1)).prepareStatement(TodoDAO.incrementPomodoroCounterQuery);
		verify(stmt, times(1)).executeUpdate();
	}
}

