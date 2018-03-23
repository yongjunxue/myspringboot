package com.test.pojo.elastic;

import java.io.Serializable;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Document(indexName="user",replicas=1,shards=2,type="user")
public class User extends BasePojo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7855702045597219816L;
//	@Id
//	@Field
//	private long id;
	@Field(searchAnalyzer="ik",analyzer="ik")//ik进行分词
	String name;
	@Field
	String password;
	@Field
	String tel;
	@Field
	int age;
	@Field
	double money;
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", tel=" + tel
				+ ", age=" + age + ", money=" + money + "]";
	}
	
}
