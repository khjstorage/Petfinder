package com.petfinder.dto;

public class MemberDto {
	private String id;
	private String password;
	private String name;
	private String phone;
	private String file_no;
	private String region;
	private String dog;
	private String size;
	private String color;
	private String gender;
	
	public MemberDto(){
		
	}
	public MemberDto(String id, String password, String name, String phone, String file_no,
			String region, String dog, String size, String color, String gender) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.file_no = file_no;
		this.region = region;
		this.dog = dog;
		this.size = size;
		this.color = color;
		this.gender = gender;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFile_no() {
		return file_no;
	}
	public void setFile_no(String file_no) {
		this.file_no = file_no;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
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
	
	
}
