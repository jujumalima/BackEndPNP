package io.picknpay.backend.item;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
	@Autowired
	private ItemRepository itemRepository;

	public List<Item> getItems() {
		return itemRepository.findAll();
	}
	
	public void addItem(Item item) {
		itemRepository.save(item);
	}
	
	public Item getItem(int id) {
		return itemRepository.findById(id);
	}
	
	public void updateItem(int id, Item item) {
		itemRepository.saveAndFlush(item);
	}
	
	public void deleteItems() {
		itemRepository.deleteAll();
	}

	public void deleteItem(Item item) {
		itemRepository.delete(item);
	}

	public List<Item> getItemByFk(int pid){
		return itemRepository.findByFk(pid);
	}
	
	public void updateItem(long id, Item item) {
		itemRepository.saveAndFlush(item);
	}
}