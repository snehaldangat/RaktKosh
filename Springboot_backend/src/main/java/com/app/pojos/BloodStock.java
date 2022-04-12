package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="stock")
@NoArgsConstructor
@Data
@AllArgsConstructor
@Getter
@Setter
public class BloodStock extends BaseEntity{
	@OneToOne
    //@MapsId
    @JoinColumn(name = "bank_id")
    private BloodBank bank;
	private int aPositive;
	private int bPositive;
	private int abPositive;
	private int oPositive;
	private int aNegative;
	private int bNegative ;
	private int abNegative;
	private int oNegative;

}
