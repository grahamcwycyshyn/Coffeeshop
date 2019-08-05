package co.grandcircus.coffeeshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import co.grandcircus.coffeeshop.entity.Product;
import co.grandcircus.coffeeshop.entity.User;

@Repository
@Transactional
public class UserDao {
	
	@PersistenceContext
	EntityManager em;
	
	public List<User> findAll() {
		// BeanPropertyRowMapper uses the rows from the SQL result create
		// new User objects and fill in the values by calling the setters.
		// Use .query for SQL SELECT statements.
		return em.createQuery("FROM Users", User.class).getResultList();
	}
	
	public User findById(Long id) {
		// The last parameters of .query let us specify values for the (?) parameters in our SQL statement.
		// While .query returns a list, .queryForObject assumes only one result. 
		// If nothing matched, match will be null.
		return em.find(User.class, id);
	}
	
	public void update(User User) {
		// Use .update for SQL INSERT, UPDATE, and DELETE
		// All the parameters after the first specify values to fill in the ?s in the SQL.
		em.merge(User);
	}
	
	public void create(User User) {
		em.persist(User);
	}
	
	public void delete(Long id) {
		User user = em.getReference(User.class, id);
		em.remove(user);
	}
}
