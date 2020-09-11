package com.myclass.dao;

import java.util.ArrayList;
import java.util.List;

import com.myclass.entity.Category;

public class CategoryDao {
	
	private List<Category> listCate = null;
	
	public CategoryDao() {
		listCate = new ArrayList<Category>();
//		listCate.add(new Category("dienthoai", "Điện thoại", "Điện thoại thông minh"));
//		listCate.add(new Category("laptop", "Laptop", "Máy tính xách tay"));
	}
	
	public List<Category> findAll() {
		return listCate;
	}
	
	public Category findById(String id) {
		for (Category category : listCate) {
			if(category.getId().equals(id)) {
				return category;
			}
		}
		return null;
	}
	
	public void delete(String id) {
		for (int i = 0; i < listCate.size(); i++) {
			if(listCate.get(i).getId().equals(id)) {
				listCate.remove(i);
				break;
			}
		}
	}
	
	public void insert(Category category) {
		listCate.add(category);
	}
	
	public void update(Category category) {
		for (Category item : listCate) {
			if(item.getId().equals(category.getId())) {
				item.setName(category.getName());
				item.setDesc(category.getDesc());
			}
			break;
		}
	}
}
