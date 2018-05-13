package edu.csula.storage.mysql;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.sql.*;

import edu.csula.storage.EventsDAO;
import edu.csula.storage.Database;
import edu.csula.models.Event;

public class EventsDAOImpl implements EventsDAO {
	private final Database context;

	// TODO: fill the Strings with the SQL queries as "prepated statements" and
	//       use these queries variable accordingly in the method below
	protected static final String getAllQuery = "SELECT * FROM events;";
	protected static final String getByIdQuery = "SELECT * FROM events WHERE events.id = ?";
	protected static final String setQuery = "UPDATE events SET name = ? , description = ?, trigger_at = ? WHERE events.id = ?";
	protected static final String addQuery = "INSERT INTO events (name, description, trigger_at) VALUES (?, ?, ?)";
	protected static final String removeQuery = "DELETE FROM events WHERE events.id = ? ";

	public EventsDAOImpl(Database context) {
		this.context = context;
	}

	@Override
	public List<Event> getAll() {
   		// TODO: get all events from jdbc
           List<Event> events = new ArrayList<>();
           try (Connection c = context.getConnection();Statement stmt = c.createStatement()){
               ResultSet rs = stmt.executeQuery("SELECT * FROM events;");
               while(rs.next()){
                     Event event = new Event(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
         				events.add(event);
               			}
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
		return events;
      }      



	@Override
	public Optional<Event> getById(int id) {
		// TODO: get specific event by id
		try (Connection c = context.getConnection(); PreparedStatement stmt = c.prepareStatement(getByIdQuery)) {
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()){
				Event event = new Event(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				return Optional.of(event);
			}
		}catch(SQLException e){
			e.printStackTrace();
         Optional.empty();

		}
         return Optional.empty();
	}

	@Override
	public void set(int id, Event event) {
		// TODO: update specific event by id
		try (Connection c = context.getConnection(); PreparedStatement stmt = c.prepareStatement(setQuery)){
			stmt.setInt(1, event.getId());
			stmt.setString(2, event.getName());
			stmt.setString(3, event.getDescription());
			stmt.setInt(4, event.getTriggerAt());
			stmt.setInt(5, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void add(Event event) {
		// TODO: implement jdbc logic to add a new event
      try (Connection c = context.getConnection(); PreparedStatement stmt = c.prepareStatement(addQuery)) {
         stmt.setInt(1,event.getId());
			stmt.setString(2, event.getName());
			stmt.setString(3, event.getDescription());
			stmt.setInt(4, event.getTriggerAt());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(int id) {
		// TODO: implement jdbc logic to remove event by id
		try (Connection c = context.getConnection(); PreparedStatement stmt = c.prepareStatement(removeQuery)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
