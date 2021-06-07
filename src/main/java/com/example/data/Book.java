package com.example.data;

import java.time.LocalDateTime;

public class Book {
	private Long book_id;
	private String book_name;
	private String writer;
	private String publisher;
	private Long times;
	private String genre;
	private String borrow_confirm;
	private LocalDateTime registrationdate;
	private String story;
	private String image;
	public Book(Long book_id,String book_name, String writer, String publisher,String borrow_confirm,Long times,String genre,String story,String image)
	{
	this.book_id=book_id;
	this.book_name = book_name;
	this.writer = writer;
	this.publisher= publisher;
	this.borrow_confirm=borrow_confirm;
	this.genre=genre;
	this.times=times;
	this.story=story;
	this.image=image;

	}
	
	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getBook_id() {
		return book_id;
	}
	public void setBook_id(Long book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Long getTimes() {
		return times;
	}
	public void setTimes(Long times) {
		this.times = times;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getBorrow_confirm() {
		return borrow_confirm;
	}
	public void setBorrow_confirm(String borrow_confirm) {
		this.borrow_confirm = borrow_confirm;
	}
	public LocalDateTime getRegistrationdate() {
		return registrationdate;
	}
	public void setRegistrationdate(LocalDateTime registrationdate) {
		this.registrationdate = registrationdate;
	}
	
	
}
