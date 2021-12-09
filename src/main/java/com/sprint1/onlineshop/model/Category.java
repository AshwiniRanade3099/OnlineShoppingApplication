package com.sprint1.onlineshop.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="category")
public class Category {

	@Id
	int catid;
	@Column(name="categoryName")
	String categoryName;
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(int catid, String categoryName) {
		super();
		this.catid = catid;
		this.categoryName = categoryName;
	}
	public int getCatid() {
		return catid;
	}
	public void setCatid(int catid) {
		this.catid = catid;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
