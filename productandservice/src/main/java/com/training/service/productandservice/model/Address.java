package com.training.service.productandservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name="address")
public class Address {

@Id
@GeneratedValue(strategy=GenerationType.AUTO)  
private int id;
@Column(name="flat_no")
private String flatNo;
@Column(name="flat_name")
private String flatName;
private String street;
private String area;
@Column(name="city/village")
private String cityOrVillageName;
@Column(name="pin")
private String pinCode;


	
}
