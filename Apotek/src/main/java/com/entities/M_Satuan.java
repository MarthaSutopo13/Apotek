package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="m_satuan")
public class M_Satuan {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_satuan")
	private String id_satuan;
	
	@Column(name="nama_satuan")
	private String nama_satuan;

	@Column(name="hasil_jumlah_konversi")
	private Integer hasil_jumlah_konversi;
	
	@Column(name="konversi_ke")
	private String konversi_ke;

	public String getId_satuan() {
		return id_satuan;
	}

	public void setId_satuan(String id_satuan) {
		this.id_satuan = id_satuan;
	}

	public String getNama_satuan() {
		return nama_satuan;
	}

	public void setNama_satuan(String nama_satuan) {
		this.nama_satuan = nama_satuan;
	}

	public Integer getHasil_jumlah_konversi() {
		return hasil_jumlah_konversi;
	}

	public void setHasil_jumlah_konversi(Integer hasil_jumlah_konversi) {
		this.hasil_jumlah_konversi = hasil_jumlah_konversi;
	}

	public String getKonversi_ke() {
		return konversi_ke;
	}

	public void setKonversi_ke(String konversi_ke) {
		this.konversi_ke = konversi_ke;
	}
}
