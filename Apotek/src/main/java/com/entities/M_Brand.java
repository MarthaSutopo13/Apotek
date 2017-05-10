package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="m_brand")
public class M_Brand {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_brand")
	private String id_brand;
	
	@Column(name="nama_brand")
	private String nama_brand;

	public String getId_brand() {
		return id_brand;
	}

	public void setId_brand(String id_brand) {
		this.id_brand = id_brand;
	}

	public String getNama_brand() {
		return nama_brand;
	}

	public void setNama_brand(String nama_brand) {
		this.nama_brand = nama_brand;
	}
}
