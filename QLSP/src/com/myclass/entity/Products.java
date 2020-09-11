package com.myclass.entity;

import javax.sound.midi.Soundbank;

public class Products {
	private String id; 
	private String cateId; 
	private String name; 
	private int amount; 
	private float price;
	
	public Products() {
		id = ""; 
		cateId = ""; 
		name = ""; 
		amount = 0; 
		price = 0; 
	}

	public Products(String id, String cateId, String name, int amount, float price) {
		super();
		this.id = id;
		this.cateId = cateId;
		this.name = name;
		this.amount = amount;
		this.price = price;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	public String getCateId() {
		return cateId;
	}

	public void setCateId(String cateId) {
		this.cateId = cateId;
	}
	
	
}
