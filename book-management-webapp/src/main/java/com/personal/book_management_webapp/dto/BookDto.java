package com.personal.book_management_webapp.dto;

import java.util.Objects;

public class BookDto {
	private int id;
	private String title;
	private String author;
	private String category;
	private float price;
	

	public BookDto(int id, String title, String author, String category, float price) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.category = category;
		this.price = price;
	}

	public BookDto() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}


	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	@Override
	public int hashCode() {
		return Objects.hash(author, category, id, price, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookDto other = (BookDto) obj;
		return Objects.equals(author, other.author) && Objects.equals(category, other.category) && id == other.id
				&& Float.floatToIntBits(price) == Float.floatToIntBits(other.price)
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "BookDto [id=" + id + ", title=" + title + ", author=" + author + ", category=" + category + ", price="
				+ price + "]";
	}

}
