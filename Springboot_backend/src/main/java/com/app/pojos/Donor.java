package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="donor")
@NoArgsConstructor
@Data
@AllArgsConstructor
@Getter
@Setter
public class Donor  {
	
	@Id
	@Column(length = 30)
	private String email;
	
	
	@Column(length = 15)
	private String firstName ;
	
	@Column(length = 15)
	private String lastName;
	
	private LocalDate birthDate;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 15)
	private Gender gender;
	
	@ManyToOne
	@JoinColumn(name="city_id", nullable = false)
	private City city;
	
	@Column(length = 15)
	private String mobile;
	
	@Column(length = 15)
	private String password;
	
	

}
