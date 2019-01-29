package io.picknpay.backend.cart;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.picknpay.backend.customer.Customer;
import io.picknpay.backend.item.Item;
import io.picknpay.backend.payment.Payment;

@Entity
public class Cart {
	@Id
	@GeneratedValue
	private int id;
	private int quantity;
	private String date;
	private int iid;
	private int pid;
	private int cid;
	private int did;
	private int ordernum;
	
	@ManyToOne
	@JoinColumn(name = "iid1", referencedColumnName="id")
	@JsonIgnore
	private Item item;
	
	@ManyToOne
	@JoinColumn(name = "cid1", referencedColumnName="id")
	@JsonIgnore
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "pid1", referencedColumnName="id")
	@JsonIgnore
	private Payment payment;

	public Cart(int id, int quantity, String date, int iid, int pid, int cid, int did, int ordernum, Item item,
			Customer customer, Payment payment) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.date = date;
		this.iid = iid;
		this.pid = pid;
		this.cid = cid;
		this.did = did;
		this.ordernum = ordernum;
		this.item = item;
		this.customer = customer;
		this.payment = payment;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getIid() {
		return iid;
	}

	public void setIid(int iid) {
		this.iid = iid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public int getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(int ordernum) {
		this.ordernum = ordernum;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
}
