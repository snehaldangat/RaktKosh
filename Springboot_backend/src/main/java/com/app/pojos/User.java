package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="user")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class User {
	
	
	@Id
	@Column(length = 30)
	private String email;
	
	@Column(length = 15, nullable = false)
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 15, nullable = false)
	private UserRole role;
}
