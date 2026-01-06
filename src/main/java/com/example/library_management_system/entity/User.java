package com.example.library_management_system.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="userdetails")
@Getter
@Setter
public class User{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY,generator="user_id_generator")
	@SequenceGenerator(name="user_id_generator",initialValue=201,allocationSize=1)
	private int userId;
	private String name;
	private long phoneNumber;
	private String email;
	@OneToOne
	private Address address;
}
