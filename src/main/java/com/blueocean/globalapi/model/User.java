package com.blueocean.globalapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class User {
	@Id
	private int id;
	private String firstname;
	private String lastname;
	private String school;
	private String college;
}
