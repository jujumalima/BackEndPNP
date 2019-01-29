package io.picknpay.backend.delivery;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Delivery {
	@Id
	private int id;
	private String address;
	private String name;
	private String nickname;
	
	public Delivery(int id, String address, String name, String nickname) {
		super();
		this.id = id;
		this.address = address;
		this.name = name;
		this.nickname = nickname;
	}

	public Delivery() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}
