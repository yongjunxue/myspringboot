package com.test.pojo.elastic;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;

public class BasePojo  implements Serializable{
	/**
	 * 
	 */
	@Id
	@Field
	private long id;
	
	
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
}
