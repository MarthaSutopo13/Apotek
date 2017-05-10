package com.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class KendoWindowBrowse {

	public KendoWindowBrowse(String id, String value) {
		super();
		this.id = id;
		this.value = value;
	}

	@Id
	private String id;
	
	private String value;

	public String getNo() {
		return id;
	}

	public void setNo(String id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
