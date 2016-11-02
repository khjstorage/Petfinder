package com.petfinder.dto;

public class FindsDto {
	private String find_id;
	private String id;
	private int file_no;
	private String password;
	private String dog;
	private String size;
	private String color;
	private String gender;
	private String phone;
	private String find_date;
	private String find_region;
	private String detail;
	private String complete;
	public FindsDto() {
	}
	public FindsDto(String find_id, String id, int file_no, String password,
			String dog, String size, String color, String gender, String phone,
			String find_date, String find_region, String detail, String complete) {
		super();
		this.find_id = find_id;
		this.id = id;
		this.file_no = file_no;
		this.password = password;
		this.dog = dog;
		this.size = size;
		this.color = color;
		this.gender = gender;
		this.phone = phone;
		this.find_date = find_date;
		this.find_region = find_region;
		this.detail = detail;
		this.complete = complete;
	}
	public String getFind_id() {
		return find_id;
	}
	public void setFind_id(String find_id) {
		this.find_id = find_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getFile_no() {
		return file_no;
	}
	public void setFile_no(int file_no) {
		this.file_no = file_no;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getFind_date() {
		return find_date;
	}
	public void setFind_date(String find_date) {
		this.find_date = find_date;
	}
	public String getFind_region() {
		return find_region;
	}
	public void setFind_region(String find_region) {
		this.find_region = find_region;
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

	
}
