package io.picknpay.backend.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;
	
	public List<Cart> getCarts() {
		return cartRepository.findAll();
	}
	
	public void addToCart(Cart cart) {
		cartRepository.save(cart);
	}
	
	public Cart getCart(int id) {
		return cartRepository.findById(id);
	}
	
	public void deleteCart(Cart cart) {
		cartRepository.delete(cart);
	}

}
