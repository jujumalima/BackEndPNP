package io.picknpay.backend.aisle;

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
public class AisleController {
	@Autowired
	private AisleService aisleService;
	
	@GetMapping("/aisle")
	public List<Aisle> getAisle() {
		return aisleService.getAisle();
	}
	
	@GetMapping("/aisle/{id}")
	public Aisle getAisle(@PathVariable int id) {
		return aisleService.getAisle(id);
	}
	
	@GetMapping("/aisle/name/{name}")
	public Aisle getAisleByName(@PathVariable String name) {
		return aisleService.getAisleByName(name);
	}
	
	@PostMapping(value="/aisle")
	public void addAisle(@RequestBody Aisle aisle) {
		aisleService.addAisle(aisle);
	}
	
	@DeleteMapping("/aisle")
	public void deleteAisles() {
		aisleService.deleteAisles();
	}
	
	@DeleteMapping(value="/aisle/{id}")
	public void deleteAisle(@PathVariable int id) {
		Aisle aisle = aisleService.getAisle(id);
		aisleService.deleteAisle(aisle);
	}
}
