package com.example.library_management_system.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter


public class Library {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY,generator="lib_id_generator")
	@SequenceGenerator(name="lib_id_generator",initialValue=501,allocationSize=1)
	private int libraryId;
	private String name;
	private long phoneNumber;
	
	@OneToOne
	private Address address;
	
	@OneToMany
	private List<Book>books;
}
