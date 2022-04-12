package com.app.pojos;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="district")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class District extends BaseEntity{
	@Column(length = 50)
	private String name;
	
	@ManyToOne
   private State state;
	//State-->District: M-->1
}
