package com.test.pojo.elastic;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Document(indexName="goods",replicas=1,shards=2,type="food")
public class Goods extends BasePojo{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6599896559912948627L;
//	@Id
//	@Field
//	private long id;
	@Field(searchAnalyzer="ik_max_word",analyzer="ik_max_word")//ik进行分词
	String name;
	@Field(searchAnalyzer="ik",analyzer="ik")//ik进行分词
	String product;
	@Field(searchAnalyzer="ik",analyzer="ik")//ik进行分词
	String brand;
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
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
