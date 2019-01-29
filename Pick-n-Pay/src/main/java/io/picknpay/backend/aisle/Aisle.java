package io.picknpay.backend.aisle;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import io.picknpay.backend.product.Product;

@Entity
public class Aisle {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String image;
	
	@OneToMany(mappedBy = "aisle", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Product> product;
	
	public Aisle(int id, String name, String image) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
	}

	public Aisle() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setImage(String image) {
		this.image = image;
	}
}