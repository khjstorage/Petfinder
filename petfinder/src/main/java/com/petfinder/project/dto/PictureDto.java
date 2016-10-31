package com.petfinder.project.dto;

public class PictureDto {
	private String file_no;
	private String file_name;
	private String file_extention;
	private String file_path;
	public PictureDto() {
	}
	public PictureDto(String file_no, String file_name, String file_extention,
			String file_path) {
		super();
		this.file_no = file_no;
		this.file_name = file_name;
		this.file_extention = file_extention;
		this.file_path = file_path;
	}
	public String getFile_no() {
		return file_no;
	}
	public void setFile_no(String file_no) {
		this.file_no = file_no;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getFile_extention() {
		return file_extention;
	}
	public void setFile_extention(String file_extention) {
		this.file_extention = file_extention;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
}
