package co.grandcircus.coffeeshop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.grandcircus.coffeeshop.User;

@Repository
public class UserDao {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	public List<User> findAll() {
		// BeanPropertyRowMapper uses the rows from the SQL result create
		// new User objects and fill in the values by calling the setters.
		// Use .query for SQL SELECT statements.
		String sql = "SELECT * FROM User";
		return jdbc.query(sql, new BeanPropertyRowMapper<>(User.class));
	}
	
	public User findById(Long id) {
		// The last parameters of .query let us specify values for the (?) parameters in our SQL statement.
		// While .query returns a list, .queryForObject assumes only one result. 
		// If nothing matched, match will be null.
		String sql = "SELECT * FROM User WHERE id = ?";
		return jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
	}
	
	public void update(User User) {
		// Use .update for SQL INSERT, UPDATE, and DELETE
		// All the parameters after the first specify values to fill in the ?s in the SQL.
		String sql = "UPDATE User SET name=?, username=?, password=? WHERE id=?";
		jdbc.update(sql, User.getName(), User.getUsername(), User.getPassword(), User.getId());
		
	}
	
	public void create(User User) {
		String sql = "INSERT INTO Users (id, name, username, password) VALUES (?, ?, ?, ?)";
		jdbc.update(sql, User.getId(), User.getName(), User.getUsername(), User.getPassword());
	}
	
	public void delete(Long id) {
		String sql = "DELETE FROM User WHERE id = ?";
		jdbc.update(sql, id);
	}
}
