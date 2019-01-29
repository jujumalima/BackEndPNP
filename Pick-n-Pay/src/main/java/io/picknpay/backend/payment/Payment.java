package io.picknpay.backend.payment;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Payment {
	@Id
	private int id;
	private String name;
	private int cvv;
	private String  exdate;
	private int cardnum;
	
	public Payment(int id, String name, int cvv, String exdate, int cardnum) {
		super();
		this.id = id;
		this.name = name;
		this.cvv = cvv;
		this.exdate = exdate;
		this.cardnum = cardnum;
	}

	public Payment() {
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

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public String getExdate() {
		return exdate;
	}

	public void setExdate(String exdate) {
		this.exdate = exdate;
	}

	public int getCardnum() {
		return cardnum;
	}

	public void setCardnum(int cardnum) {
		this.cardnum = cardnum;
	}
}
