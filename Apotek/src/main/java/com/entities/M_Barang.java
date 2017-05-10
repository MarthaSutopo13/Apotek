package com.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;

public class M_Barang {
	
	@EmbeddedId
	private M_Barang_PK pk;
	
	@Column(name="nama_barang") 
	private String nama_barang;
	
	@Column(name="nama_detail_barang") 
	private String nama_detail_barang;
	
	@Column(name="jumlah") 
	private Integer jumlah;
	
	@Column(name="kadaluarsa") 
	private String kadaluarsa;
	
	@Column(name="id_satuan") 
	private String id_satuan;
	
	@Column(name="total_jumlah") 
	private Integer total_jumlah;
	
	@Column(name="harga_jual1") 
	private Integer harga_jual1;
	
	@Column(name="harga_jual2") 
	private Integer harga_jual2;
	
	@Column(name="id_brand") 
	private String id_brand;
	
	@Column(name="id_kategori") 
	private String id_kategori;

	@Column(name="harga_beli") 
	private Integer harga_beli;

	public M_Barang_PK getPk() {
		return pk;
	}

	public void setPk(M_Barang_PK pk) {
		this.pk = pk;
	}

	public String getNama_barang() {
		return nama_barang;
	}

	public void setNama_barang(String nama_barang) {
		this.nama_barang = nama_barang;
	}

	public String getNama_detail_barang() {
		return nama_detail_barang;
	}

	public void setNama_detail_barang(String nama_detail_barang) {
		this.nama_detail_barang = nama_detail_barang;
	}

	public Integer getJumlah() {
		return jumlah;
	}

	public void setJumlah(Integer jumlah) {
		this.jumlah = jumlah;
	}

	public String getKadaluarsa() {
		return kadaluarsa;
	}

	public void setKadaluarsa(String kadaluarsa) {
		this.kadaluarsa = kadaluarsa;
	}

	public String getId_satuan() {
		return id_satuan;
	}

	public void setId_satuan(String id_satuan) {
		this.id_satuan = id_satuan;
	}

	public Integer getTotal_jumlah() {
		return total_jumlah;
	}

	public void setTotal_jumlah(Integer total_jumlah) {
		this.total_jumlah = total_jumlah;
	}

	public Integer getHarga_jual1() {
		return harga_jual1;
	}

	public void setHarga_jual1(Integer harga_jual1) {
		this.harga_jual1 = harga_jual1;
	}

	public Integer getHarga_jual2() {
		return harga_jual2;
	}

	public void setHarga_jual2(Integer harga_jual2) {
		this.harga_jual2 = harga_jual2;
	}

	public String getId_brand() {
		return id_brand;
	}

	public void setId_brand(String id_brand) {
		this.id_brand = id_brand;
	}

	public String getId_kategori() {
		return id_kategori;
	}

	public void setId_kategori(String id_kategori) {
		this.id_kategori = id_kategori;
	}

	public Integer getHarga_beli() {
		return harga_beli;
	}

	public void setHarga_beli(Integer harga_beli) {
		this.harga_beli = harga_beli;
	}
	
	public String getId_barang() {
		return pk.getId_barang();
	}

	public void setId_barang(String id_barang) {
		try 
		{
			this.pk.setId_barang(id_barang);
		}
		catch(Exception e)
		{
			this.setPk(new M_Barang_PK());
			this.pk.setId_barang(id_barang);
		}
	}

	public String getId_detail_barang() {
		return pk.getId_detail_barang();
	}

	public void setId_detail_barang(String id_detail_barang) {
		try 
		{
			this.pk.setId_detail_barang(id_detail_barang);
		}
		catch(Exception e)
		{
			this.setPk(new M_Barang_PK());
			this.pk.setId_detail_barang(id_detail_barang);
		}
	}
}
