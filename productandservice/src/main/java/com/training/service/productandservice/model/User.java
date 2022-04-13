package com.training.service.productandservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity(name="user")
public class User {

@Column(name="userid")
@Id
@GeneratedValue(strategy=GenerationType.AUTO)  
private int id;
private String name;
private String password;
@OneToOne
private Address addressId;
private String phone;
private int userStatus;


}
