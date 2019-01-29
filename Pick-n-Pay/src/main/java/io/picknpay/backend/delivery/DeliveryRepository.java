package io.picknpay.backend.delivery;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Integer>{
	Delivery findById(int id);
}
