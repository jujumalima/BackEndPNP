package io.picknpay.backend.item;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.picknpay.backend.product.Product;

@Entity
public class Item {
	@Id
	private int id;
	private String name;
	private double price;
	private String weight;
	private String category;
	private Boolean promotion;
	private String brand;
	private Boolean discovery;
	private String barcode;
	private String discription;
	private String image;
	private int unit;
	private int quantity;
	private int pid;
	private int itemsavailable;
	
	@ManyToOne
	@JoinColumn(name = "pid1", referencedColumnName="id")
	@JsonIgnore
	private Product product;

	public Item(int id, String name, double price, String weight, String category, Boolean promotion, String brand,
			Boolean discovery, String barcode, String discription, String image, int unit, int quantity,
			Product product, int pid, int itemsavailable) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.weight = weight;
		this.category = category;
		this.promotion = promotion;
		this.brand = brand;
		this.discovery = discovery;
		this.barcode = barcode;
		this.discription = discription;
		this.image = image;
		this.unit = unit;
		this.quantity = quantity;
		this.product = product;
		this.pid = pid;
		this.itemsavailable = itemsavailable;
	}

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Boolean getPromotion() {
		return promotion;
	}

	public void setPromotion(Boolean promotion) {
		this.promotion = promotion;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Boolean getDiscovery() {
		return discovery;
	}

	public void setDiscovery(Boolean discovery) {
		this.discovery = discovery;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getItemsavailable() {
		return itemsavailable;
	}

	public void setItemsavailable(int itemsavailable) {
		this.itemsavailable = itemsavailable;
	}
}
