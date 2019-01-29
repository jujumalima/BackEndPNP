package io.picknpay.backend.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getProduct() {
		return productRepository.findAll();
	}

	public void addProduct(Product product) {
		productRepository.save(product);	
	}

	public Product getProduct(int id) {
		return productRepository.findById(id);
	}

	public Product getProductByName(String name) {
		return productRepository.findByName(name);		 
	}

	public void updateProduct(long id, Product product) {
		productRepository.saveAndFlush(product);
	}

	public void deleteProducts() {
		productRepository.deleteAll();
	}

	public void deleteProduct(Product product) {
		productRepository.delete(product);
	}
	
	public List<Product> getProductByFk(int aid){
		return productRepository.findByFk(aid);
	}
}
