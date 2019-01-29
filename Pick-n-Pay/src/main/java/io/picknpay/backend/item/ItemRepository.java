package io.picknpay.backend.item;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	Item findById(int id);
	
	@Query("SELECT i FROM Item i WHERE pid = :pid")
	List<Item> findByFk(int pid);
}
