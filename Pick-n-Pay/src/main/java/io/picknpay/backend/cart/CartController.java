package io.picknpay.backend.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CartController {

	@Autowired
	public CartService cartService;
	
	@GetMapping("/cart")
	public List<Cart> getCarts() {
		return cartService.getCarts();
	}
	
	@GetMapping("/cart/{id}")
	public Cart getCart(@PathVariable int id) {
		return cartService.getCart(id);
	}
	
	@PostMapping(value="/cart")
	public void addToCart(@RequestBody Cart cart) {
		cartService.addToCart(cart);
	}
	
	@DeleteMapping(value="/cart/{id}")
	public void deleteCart(@PathVariable int id) {
		Cart cart = cartService.getCart(id);
		cartService.deleteCart(cart);
	}
}