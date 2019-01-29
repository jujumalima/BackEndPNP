package io.picknpay.backend.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	Product findById(int id);
	Product findByName(String name);
	
	@Query("SELECT p FROM Product p WHERE p.aisle.id = :aid")
	List<Product> findByFk(int aid);
}