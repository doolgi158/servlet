package com.example;

public class BookDTO {
	private String title;
	private String writer;
	private String publicer;
	
	public BookDTO() {	}
	
	public BookDTO(String title, String writer, String publicer) {
		super();
		this.title = title;
		this.writer = writer;
		this.publicer = publicer;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPublicer() {
		return publicer;
	}
	public void setPublicer(String publicer) {
		this.publicer = publicer;
	}
	
	@Override
	public String toString() {
		return "BookDTO [title=" + title + ", writer=" + writer + ", publicer=" + publicer + "]";
	}
}
