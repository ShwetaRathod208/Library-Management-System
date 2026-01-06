package com.example.library_management_system.entity;


import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY,generator="book_id_generator")
	@SequenceGenerator(name="book_id_generator",initialValue=1001,allocationSize=1)
	private int bookId;
	private String title;
	private String author;
	private LocalDateTime borrowedTime;
	private LocalDateTime returnTime;
	private boolean borrowed;
	@ManyToOne
	private User user;
}
