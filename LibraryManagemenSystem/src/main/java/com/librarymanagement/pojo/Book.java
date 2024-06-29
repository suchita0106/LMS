package com.librarymanagement.pojo;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

	public Book() {
 	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    
    @Column(name = "title")
    private String title;
    
    @Column(name = "author")
    private String author;   
    
    @Column(name = "quantity")
    private Long quantity;

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		System.out.println("TITLE --"+title);
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		System.out.println("author --"+author);
		this.author = author;
	}
    
    

}
	