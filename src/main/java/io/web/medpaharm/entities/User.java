package io.web.medpaharm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
//@Table(name="user")
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Column(name="id")
	private long id;
	
//	@NotBlank(message = "Name is mandatory")
	@Column(name="username", nullable=true)
	private String name;
	
	@Column(name="unit")
	private String unit;
	
	@Column(name="user_code")
	private String userCode;

}
