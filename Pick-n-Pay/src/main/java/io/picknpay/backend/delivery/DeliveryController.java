package io.picknpay.backend.delivery;

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
public class DeliveryController {
	
	@Autowired
	private DeliveryService deliveryService;
	
	@GetMapping("/delivery")
	public List<Delivery> getDeliveries() {
		return deliveryService.getDeliveries();
	}
	
	@GetMapping("/delivery/{id}")
	public Delivery getDelivery(@PathVariable int id) {
		return deliveryService.getDelivery(id);
	}
	
	@PostMapping(value="/delivery")
	public void addDelivery(@RequestBody Delivery delivery) {
		deliveryService.addDelivery(delivery);
	}
	
	@DeleteMapping("/delivery")
	public void deleteDeliveries() {
		deliveryService.deleteDeliveries();
	}
	
	@DeleteMapping(value="/delivery/{id}")
	public void deleteProduct(@PathVariable int id) {
		Delivery delivery = deliveryService.getDelivery(id);
		deliveryService.deleteDelivery(delivery);
	}

}