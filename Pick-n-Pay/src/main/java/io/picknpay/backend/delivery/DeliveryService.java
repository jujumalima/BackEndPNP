package io.picknpay.backend.delivery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

	@Autowired
	private DeliveryRepository deliveryRepository;

	public List<Delivery> getDeliveries() {
		return deliveryRepository.findAll();
	}

	public void addDelivery(Delivery delivery) {
		deliveryRepository.save(delivery);	
	}

	public Delivery getDelivery(int id) {
		return deliveryRepository.findById(id);
	}

	public void deleteDeliveries() {
		deliveryRepository.deleteAll();
	}

	public void deleteDelivery(Delivery delivery) {
		deliveryRepository.delete(delivery);
	}
}
