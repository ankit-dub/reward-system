package com.example.hackathon.model;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class MyTransaction extends Reward{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@JsonIgnore
	@ManyToOne
	@JoinColumn
	private Customer customer;

	private Double amount;

	private String description;

	private int tenure;

	@Temporal(TemporalType.TIMESTAMP)
	private Date saveDate;


	@Override
	public Long getPoints() {
		this.points = 0l;
		
		if (this.amount > 10000 && this.amount <= 75000) {
			this.points += 2;
		}
		if (this.amount > 75000 && this.amount <= 125000) {
			this.points += 4;  //4 point for every emi spent over 75k
		}
		if (this.amount > 125000 && this.amount <= 225000) {
			this.points += 6;
		}
		if (this.amount > 225000 && this.amount <= 350000) {
			this.points += 8;
		}
		if (this.amount > 350000 && this.amount <= 500000) {
			this.points += 10;  //10 point for every emi spent over 350k
		}
		this.points += this.tenure/3;

		return this.points;
	}

}
