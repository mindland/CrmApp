package com.myclass.dao;

import java.util.ArrayList;
import java.util.List;

import com.myclass.entity.Product;

public class ProductDao {
	
	private List<Product> list = null;
	
	public ProductDao() {
		list = new ArrayList<Product>();
		list.add(new Product("sp01", "Nokia 1280", 1000,  300000, "dienthoai"));
		list.add(new Product("sp02", "Samsung Galaxy", 1000, 7000000, "dienthoai"));
	}

	public List<Product> findAll() {
		return list;
	}

	public Product findById(String id) {
		for (Product product : list) {
			if(product.getId().equals(id)) {
				return product;
			}
		}
		return null;
	}
	
	public void insert(Product product) {
		list.add(product);
	}
	
	public void update(Product product) {
		Product entity = findById(product.getId());
		if(entity != null) {
			entity.setName(product.getName());
			entity.setPrice(product.getPrice());
			entity.setQuantity(product.getQuantity());
		}
	}
	
	public void delete(String id) {
		Product entity = findById(id);
		if(entity != null) {
			list.remove(entity);
		}
	}
}
