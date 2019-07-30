package co.grandcircus.coffeeshop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.grandcircus.coffeeshop.Product;

@Repository
public class ProductsDao {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	public List<Product> findAll() {
		// BeanPropertyRowMapper uses the rows from the SQL result create
		// new Product objects and fill in the values by calling the setters.
		// Use .query for SQL SELECT statements.
		String sql = "SELECT * FROM Product";
		return jdbc.query(sql, new BeanPropertyRowMapper<>(Product.class));
	}
	
	public Product findById(Long id) {
		// The last parameters of .query let us specify values for the (?) parameters in our SQL statement.
		// While .query returns a list, .queryForObject assumes only one result. 
		// If nothing matched, match will be null.
		String sql = "SELECT * FROM Product WHERE id = ?";
		return jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(Product.class), id);
	}
	
	public void update(Product Product) {
		// Use .update for SQL INSERT, UPDATE, and DELETE
		// All the parameters after the first specify values to fill in the ?s in the SQL.
		String sql = "UPDATE Products SET name=?, description=?, price=? WHERE id=?";
		jdbc.update(sql, Product.getName(), Product.getDescription(), Product.getPrice(), Product.getId());
		
	}
	
	public void create(Product Product) {
		String sql = "INSERT INTO Products (name, description, price) VALUES (?, ?, ?)";
		jdbc.update(sql, Product.getName(), Product.getDescription(), Product.getPrice());
	}
	
	public void delete(Long id) {
		String sql = "DELETE FROM Products WHERE id = ?";
		jdbc.update(sql, id);
	}
	
}
