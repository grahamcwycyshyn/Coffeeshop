//package co.grandcircus.coffeeshop.entity;
//
//import java.util.ArrayList;
//
//import javax.persistence.Entity;
//import javax.persistence.ForeignKey;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//@Entity
//@Table(name="Carts")
//public class Cart {
//	
//	
//	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private Long id;
//	@ForeignKey@GeneratedValue(strategy=GenerationType.AUTO)
//	private User userId;
//	private ArrayList<Product> product;
//	
//	public Cart() {}
//	
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public User getUser() {
//		return user;
//	}
//	public void setUser(User user) {
//		this.user = user;
//	}
//	public ArrayList<Product> getProduct() {
//		return product;
//	}
//	public void setProduct(ArrayList<Product> product) {
//		this.product = product;
//	}
//	
//}
