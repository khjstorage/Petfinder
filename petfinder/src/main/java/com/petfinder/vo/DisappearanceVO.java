package com.petfinder.vo;

public class DisappearanceVO {
	private String disappr_id;
	private String id;
	private String file_no;
	private String dog;
	private String size;
	private String color;
	private String gender;
	private String phone;
	private String emergency_phone;
	private String disappr_date;
	private String disappr_region;
	private String detail;
	private String complete;
	public DisappearanceVO() {
	}
	public String getDisappr_id() {
		return disappr_id;
	}
	public void setDisappr_id(String disappr_id) {
		this.disappr_id = disappr_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFile_no() {
		return file_no;
	}
	public void setFile_no(String file_no) {
		this.file_no = file_no;
	}
	public String getDog() {
		return dog;
	}
	public void setDog(String dog) {
		this.dog = dog;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmergency_phone() {
		return emergency_phone;
	}
	public void setEmergency_phone(String emergency_phone) {
		this.emergency_phone = emergency_phone;
	}
	public String getDisappr_date() {
		return disappr_date;
	}
	public void setDisappr_date(String disappr_date) {
		this.disappr_date = disappr_date;
	}
	public String getDisappr_region() {
		return disappr_region;
	}
	public void setDisappr_region(String disappr_region) {
		this.disappr_region = disappr_region;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getComplete() {
		return complete;
	}
	public void setComplete(String complete) {
		this.complete = complete;
	}
	public DisappearanceVO(String disappr_id, String id, String file_no,
			String dog, String size, String color, String gender, String phone,
			String emergency_phone, String disappr_date, String disappr_region,
			String detail, String complete) {
		super();
		this.disappr_id = disappr_id;
		this.id = id;
		this.file_no = file_no;
		this.dog = dog;
		this.size = size;
		this.color = color;
		this.gender = gender;
		this.phone = phone;
		this.emergency_phone = emergency_phone;
		this.disappr_date = disappr_date;
		this.disappr_region = disappr_region;
		this.detail = detail;
		this.complete = complete;
	}
	

}
