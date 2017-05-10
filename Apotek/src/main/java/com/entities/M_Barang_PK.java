package com.entities;

import java.io.Serializable;

import javax.persistence.Column;

public class M_Barang_PK implements Serializable{

	private static final long serialVersionUID = 1L;
	
    @Column(name="id_barang")
	private String id_barang;  
	
	@Column(name="id_detail_barang")
	private String id_detail_barang;

	public String getId_barang() {
		return id_barang;
	}

	public void setId_barang(String id_barang) {
		this.id_barang = id_barang;
	}

	public String getId_detail_barang() {
		return id_detail_barang;
	}

	public void setId_detail_barang(String id_detail_barang) {
		this.id_detail_barang = id_detail_barang;
	}
}
