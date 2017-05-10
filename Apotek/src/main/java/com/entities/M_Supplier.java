package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="m_supplier")
public class M_Supplier {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_supplier")
	private String id_supplier;
	
	@Column(name="nama_supplier")
	private String nama_supplier;
	
	@Column(name="alamat")
	private String alamat;
	
	@Column(name="email")
	private String email;
	
	@Column(name="no_telp")
	private String no_telp;
	
	@Column(name="keterangan")
	private String keterangan;
	
	public String getId_supplier() {
		return id_supplier;
	}

	public void setId_supplier(String id_supplier) {
		this.id_supplier = id_supplier;
	}

	public String getNama_supplier() {
		return nama_supplier;
	}

	public void setNama_supplier(String nama_supplier) {
		this.nama_supplier = nama_supplier;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNo_telp() {
		return no_telp;
	}

	public void setNo_telp(String no_telp) {
		this.no_telp = no_telp;
	}

	public String getKeterangan() {
		return keterangan;
	}

	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}
}
