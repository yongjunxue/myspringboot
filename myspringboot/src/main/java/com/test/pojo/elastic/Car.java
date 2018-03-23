package com.test.pojo.elastic;

import java.io.Serializable;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Document(indexName="car",replicas=1,shards=3,type="car")
public class Car extends BasePojo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7855702045597219816L;
//	@Id
//	@Field
//	private long id;
	@Field(searchAnalyzer="ik",analyzer="ik")
	String name;
	@Field(searchAnalyzer="ik",analyzer="ik")
	String brand;
	@Field(searchAnalyzer="ik",analyzer="ik")
	String product;
	@Field
	double price;
	
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
