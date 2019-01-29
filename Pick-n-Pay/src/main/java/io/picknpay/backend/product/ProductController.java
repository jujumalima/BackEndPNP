package io.picknpay.backend.product;

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
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/product")
	public List<Product> getProduct() {
		return productService.getProduct();
	}
	
	@GetMapping("/product/{id}")
	public Product getProduct(@PathVariable int id) {
		return productService.getProduct(id);
	}
	
	@GetMapping("/product/name/{name}")
	public Product getProductByName(@PathVariable String name) {
		return productService.getProductByName(name);
	}
	
	@PostMapping(value="/product")
	public void addProduct(@RequestBody Product product) {
		productService.addProduct(product);
	}
	
	@DeleteMapping("/product")
	public void deleteProducts() {
		productService.deleteProducts();
	}
	
	@DeleteMapping(value="/product/{id}")
	public void deleteProduct(@PathVariable int id) {
		Product product = productService.getProduct(id);
		productService.deleteProduct(product);
	}
	
	
	@GetMapping("/product/fk/{fk}")
	public List<Product> getProductByFk(@PathVariable int fk) {
		return productService.getProductByFk(fk);
	}
}
