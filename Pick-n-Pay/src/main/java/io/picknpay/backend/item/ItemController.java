package io.picknpay.backend.item;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/item")
	public List<Item> getItems() {
		return itemService.getItems();
	}
	
	@GetMapping("/item/{id}")
	public Item getItem(@PathVariable int id) {
		return itemService.getItem(id);
	}
	
	@PostMapping(value="/item")
	public void addItem(@RequestBody Item item) {
		itemService.addItem(item);
	}
	
	@DeleteMapping("/item")
	public void deleteItems() {
		itemService.deleteItems();
	}
	
	@DeleteMapping(value="/item/{id}")
	public void deleteItem(@PathVariable int id) {
		Item item = itemService.getItem(id);
		itemService.deleteItem(item);
	}
	
	@GetMapping("/item/fk/{pid}")
	public List<Item> getItemByFk(@PathVariable int pid) {
		return itemService.getItemByFk(pid);
	}
	
	@PutMapping(value="/item/{id}")
	public void updateItem(@RequestBody Item item, @PathVariable int id) {
		Item i = itemService.getItem(id);
		i.setItemsavailable(item.getItemsavailable());
		itemService.updateItem(id, i);
	}
	
	/*cart*/
	public List<Item> items = new ArrayList<>();
	@PostMapping(value="/item/temp")
	public int addToCart(@RequestBody Item item) {
		items.add(item);
		return items.size();
	}
	
	@GetMapping("/item/temp")
	public List<Item> getCart(){
		return items;
	}
	
	@DeleteMapping("/item/temp")
	public void deleteCart() {
		items.removeAll(items);
	}
	
	@DeleteMapping(value="/item/temp/{id}")
	public void deleteCartItem(@PathVariable int id) {
		items.remove(id);
	}
	
	@PostMapping(value="/item/temp/{id}")
	public List<Item> updateCart(@RequestBody Item itm){
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getId() == itm.getId()) {
				items.get(i).setQuantity(itm.getQuantity());
				items.get(i).setPrice(itm.getPrice());
			}
		}
		
		return items;
	}
	/*cart*/
}