package com.training.service.productandservice.data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
//@EqualsAndHashCode
@Data
@Entity(name = "user")
public class User {

	@Column(name = "userid")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String password;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addressid")
	private Address addressId;
	private String phone;
	@Column(name = "userstatus")
	private int userStatus;
	
	
//	public User() {
//		System.out.println("User object created");
//	}
	
	

}
