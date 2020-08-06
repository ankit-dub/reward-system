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

	@Temporal(TemporalType.TIMESTAMP)
	private Date saveDate;

	private int tenure;


	@Override
	public Long getPoints() {
		this.points = 0l;
		
		if (this.amount > 10 && this.amount <= 75) {
			this.points += 2;
		}
		if (this.amount > 75 && this.amount <= 125) {
			this.points += 4;  //4 point for every emi spent over 75k
		}
		if (this.amount > 125 && this.amount <= 225) {
			this.points += 6;
		}
		if (this.amount > 225 && this.amount <= 350) {
			this.points += 8;
		}
		if (this.amount > 350 && this.amount <= 500) {
			this.points += 10;  //10 point for every emi spent over 350k
		}
		this.points += this.tenure/3;

		return this.points;
	}

}
