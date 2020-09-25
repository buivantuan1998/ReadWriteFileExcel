/**
 * 
 */
package com.xtel.readfileexcel;

/**
 * @author admin
 *
 */
public class Employee {
	
	private String maSV;
	private String tenSV;
	private String email;
	private String diaChi;
	private double luong;
	
	public Employee() {
		super();
	}

	public Employee(String maSV, String tenSV, String email, String diaChi, double luong) {
		super();
		this.maSV = maSV;
		this.tenSV = tenSV;
		this.email = email;
		this.diaChi = diaChi;
		this.luong = luong;
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getTenSV() {
		return tenSV;
	}

	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public double getLuong() {
		return luong;
	}

	public void setLuong(double luong) {
		this.luong = luong;
	}
	
}
