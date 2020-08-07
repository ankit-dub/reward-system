package com.example.hackathon.model;

import java.text.DecimalFormat;
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

	//private Date saveDate;


	@Override
	public Long getPoints() {
		this.points = 0l;
		
		if (this.amount > 10000 && this.amount <= 75000) {
			this.points += 20;

		}
		if (this.amount > 75000 && this.amount <= 125000) {
			this.points += 40;
		}
		if (this.amount > 125000 && this.amount <= 225000) {
			this.points += 60;
		}
		if (this.amount > 225000 && this.amount <= 350000) {
			this.points += 80;
		}
		if (this.amount > 350000 && this.amount <= 500000) {
			this.points += 100;  //10 point for every emi spent over 350k
		}
		this.points += this.tenure*5/3;

		return this.points;
	}

	@Override
	public Double getEmiAmount() {

		DecimalFormat df = new DecimalFormat("#.##");

		if (this.tenure==3) {
			this.emiAmount=this.amount*0.12;
		}
		if (this.tenure==6) {
			this.emiAmount=this.amount*0.12;
		}
		if (this.tenure==9) {
			this.emiAmount =this.amount*0.12;
		}
		if (this.tenure==12) {
			this.emiAmount =this.amount*0.13;
		}
		if (this.tenure==18) {
			this.emiAmount = this.amount*0.13;
		}
		if (this.tenure==24) {
			this.emiAmount = this.amount*0.15;
		}
		if (this.tenure==36) {
			this.emiAmount = this.amount*0.18;
		}
		this.emiAmount = Double.valueOf(df.format(this.emiAmount));
		return this.emiAmount;
	}

}
