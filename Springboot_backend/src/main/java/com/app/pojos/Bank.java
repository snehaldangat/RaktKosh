//package com.app.pojos;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Entity
//@Table(name="bank")
//@NoArgsConstructor
//@Data
//@AllArgsConstructor
//@Getter
//@Setter
//public class Bank  {
//	@Id
//	@Column(length = 30)
//	private String email;
//	
//	@Column(length = 50,name="name", nullable = false)
//	private String bankName ;
//	
//	@Column(length = 50, name="hospital", nullable = false)
//	private String parentHospital;
//	
//	@Column(length = 15)
//	private String shortName;
//	
//	@Enumerated(EnumType.STRING)
//	@Column(length = 15)
//	private Category category;
//	
//	@Column(length = 15,   nullable = false, unique = true)
//	private String licence;
//	
//	@Column(length = 15, name="person", nullable = false)
//	private String personName;
//	
//	
//	
//	@Column(length = 15, unique = true)
//	private String contact;
//	
//
//	@ManyToOne
//	@JoinColumn(name="city_id", nullable = false)
//	private City city;
//	
//	
//	@Enumerated(EnumType.STRING)
//	@Column(length = 5, nullable = false)
//	private  ComponentFacility facility;
//	
//	private int beds;
//	
//	@Column(length = 30)
//	private String	website;
//	
//	@Column(length = 15, nullable = false)
//	private String password;
//	
//	@Column(length = 100, nullable = false)
//	private String address;
//	
//	
//
//}
