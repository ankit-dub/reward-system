package com.example.hackathon.model;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Customer {
	@Id
	@GeneratedValue
	private Integer id;

	private String email;

	private Long Apprvamount;

	@JsonIgnore
	@OneToMany(mappedBy="customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<MyTransaction> transactions;

	@Transient
	private Long rewardPoints;

	@Transient
	private Double totalPurchases;

	public Customer(Integer id, String email,Long Apprvamount) {
		super();
		this.id = id;
		this.email = email;
		this.Apprvamount=Apprvamount;
	}

	public Long getRewardPoints() {
		if (transactions == null || transactions.isEmpty()) return 0l;
		
		return transactions.stream().map(x -> x.getPoints().intValue()).reduce(0, (a,b) -> a + b).longValue();
	}
	public Double getTotalPurchases() {
		if (transactions == null || transactions.isEmpty()) return 0d;
		
		return transactions.stream().map(x -> x.getAmount().doubleValue()).reduce(0d, (a,b) -> a + b).doubleValue();
	}
	
	
}
