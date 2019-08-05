package co.grandcircus.coffeeshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.grandcircus.coffeeshop.entity.Product;

@Repository
@Transactional
public class ProductsDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Product> findAll() {
		// BeanPropertyRowMapper uses the rows from the SQL result create
		// new Product objects and fill in the values by calling the setters.
		// Use .query for SQL SELECT statements.
		return em.createQuery("FROM Product", Product.class).getResultList();
	}
	
	public Product findById(Long id) {
		// The last parameters of .query let us specify values for the (?) parameters in our SQL statement.
		// While .query returns a list, .queryForObject assumes only one result. 
		// If nothing matched, match will be null.
		return em.find(Product.class, id);
	}
	
	public void update(Product Product) {
		// Use .update for SQL INSERT, UPDATE, and DELETE
		// All the parameters after the first specify values to fill in the ?s in the SQL.
		em.merge(Product);
	}
	
	public void create(Product Product) {
		em.persist(Product);
	}
	
	public void delete(Long id) {
		Product product = em.getReference(Product.class, id);
		em.remove(product);
	}
}
