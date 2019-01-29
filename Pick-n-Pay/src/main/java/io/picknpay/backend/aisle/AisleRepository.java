package io.picknpay.backend.aisle;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AisleRepository extends JpaRepository<Aisle, Integer> {
	Aisle findById(int id);
	Aisle findByName(String name);
}