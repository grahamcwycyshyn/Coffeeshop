package co.grandcircus.coffeeshop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import co.grandcircus.coffeeshop.Product;
import co.grandcircus.coffeeshop.User;

@Controller
public class CoffeeShopController {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private ProductsDao productsDao;
	
	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("redirect:/products");
	}

	@RequestMapping("/products")
	public ModelAndView list() {
		List<Product> leListOfProducts = productsDao.findAll();
		return new ModelAndView("index", "products", leListOfProducts);
	}
	
	@RequestMapping("/products/detail")
	public ModelAndView detail(@RequestParam("id") Long id) {
		Product product = productsDao.findById(id);
		
		return new ModelAndView("detail", "product", product);
	}
	
	@RequestMapping("/register")
	public ModelAndView add() {		
		return new ModelAndView("register");
	}
	
	@PostMapping("/register")
	public ModelAndView addSubmit(User user) {
		userDao.create(user);
		return new ModelAndView("redirect:/products");
	}
}
