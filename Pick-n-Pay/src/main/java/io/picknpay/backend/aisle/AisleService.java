package io.picknpay.backend.aisle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AisleService {

	@Autowired
	private AisleRepository aisleRepository;
	
	public List<Aisle> getAisle() {
		return aisleRepository.findAll();
	}

	public void addAisle(Aisle aisle) {
		aisleRepository.save(aisle);	
	}

	public Aisle getAisle(int id) {
		return aisleRepository.findById(id);
	}

	public Aisle getAisleByName(String name) {
		return aisleRepository.findByName(name);		 
	}

	public void updateAisle(long id, Aisle aisle) {
		aisleRepository.saveAndFlush(aisle);
	}

	public void deleteAisles() {
		aisleRepository.deleteAll();
	}

	public void deleteAisle(Aisle aisle) {
		aisleRepository.delete(aisle);
	}
}
