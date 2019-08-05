package co.grandcircus.coffeeshop;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.coffeeshop.dao.ProductsDao;
import co.grandcircus.coffeeshop.dao.UserDao;
import co.grandcircus.coffeeshop.dao.UserRepository;
import co.grandcircus.coffeeshop.entity.Product;
import co.grandcircus.coffeeshop.entity.User;

@Controller
public class CoffeeShopController {

	@Autowired
	private UserDao userDao;
	@Autowired
	private ProductsDao productsDao;
	@Autowired 
	private UserRepository dao;

	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("redirect:/products");
	}

	@RequestMapping("/products")
	public ModelAndView list() {
		List<Product> leListOfProducts = productsDao.findAll();
		return new ModelAndView("index", "products", leListOfProducts);
	}

	@RequestMapping("/admin")
	public ModelAndView admin(
			@SessionAttribute(name = "user", required = false) User user) {
		if(user == null || user.getId() != 13 ) {
			return new ModelAndView("redirect:/");
		}
		List<Product> leListOfProducts = productsDao.findAll();
		return new ModelAndView("admin", "products", leListOfProducts);
	}

	@RequestMapping("/products/detail")
	public ModelAndView detail(@RequestParam("id") Long id) {
		Product product = productsDao.findById(id);

		return new ModelAndView("detail", "product", product);
	}

	@RequestMapping("/product/edit")
	public ModelAndView showEditForm(
			@RequestParam("id") Long id,
			@SessionAttribute(name = "user", required = false) User user) {
		if(user == null || user.getId() != 13 ) {
			return new ModelAndView("redirect:/");
		}
		ModelAndView mav = new ModelAndView("product-form");
		mav.addObject("product", productsDao.findById(id));
		mav.addObject("title", "Edit " + productsDao.findById(id).getName());
		return mav;
	}

	@PostMapping("/product/edit")
	public ModelAndView submitEditForm(Product product) {
		productsDao.update(product);
		return new ModelAndView("redirect:/admin");
	}

	@RequestMapping("/product/delete")
	public ModelAndView delete(
			@RequestParam("id") Long id,
			@SessionAttribute(name = "user", required = false)User user) {
		if(user == null || user.getId() != 13 ) {
			return new ModelAndView("redirect:/");
		}
		productsDao.delete(id);
		return new ModelAndView("redirect:/admin");
	}

	@RequestMapping("/product/add")
	public ModelAndView showAddForm(
			@SessionAttribute(name = "user", required = false) User user) {
		if(user == null || user.getId() != 13 ) {
			return new ModelAndView("redirect:/");
		}
		return new ModelAndView("product-form", "title", "Add a Product");
	}

	@PostMapping("/product/add")
	public ModelAndView submitAddForm(Product product) {
		productsDao.create(product);
		return new ModelAndView("redirect:/admin");
	}

	@RequestMapping("/register")
	public ModelAndView add() {
		return new ModelAndView("register");
	}

	@PostMapping("/register")
	public ModelAndView addSubmit(User user, HttpSession session) {
		session.setAttribute("user", user);
		userDao.create(user);
		return new ModelAndView("redirect:/products");
	}
	
	@RequestMapping("/login")
	public ModelAndView showLogin() {
		return new ModelAndView("login-form");
	}
	
	@PostMapping("/login")
	public ModelAndView login(
		@RequestParam("username") String username,
		@RequestParam("password") String password,
		HttpSession session) {
		
		User user = dao.findByUsernameAndPassword(username, password);
		if(user == null) {
			return new ModelAndView("login-form", "message", "Incorrect username or password");
		}
		session.setAttribute("user", user);
		return new ModelAndView("redirect:/"	);
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		return new ModelAndView("redirect:/");
	}
}
