package io.picknpay.backend.product;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.picknpay.backend.aisle.Aisle;
import io.picknpay.backend.item.Item;

@Entity
public class Product {
	@Id
	private int id;
	private String name;
	private String category;
	private String brand;
	private String image;
	
	@ManyToOne
	@JoinColumn(name = "aid", referencedColumnName="id")
	@JsonIgnore
	private Aisle aisle;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Item> item;
	
	public Product(int id, int aid, String name, String category, String brand, String image) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.brand = brand;
		this.image = image;
	}

	public Product() {
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}