package com.example.hackathon.model;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

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

	@Column(name = "email",unique = true)
	@NotNull(message ="fill the email")
	@Email(message="invalid email")
	private String email;

	@OneToMany(mappedBy="customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<MyTransaction> transactions;

	@Transient
	private Long rewardPoints;

	@Transient
	private Double totalPurchases;

	public Customer(Integer id, String email) {
		super();
		this.id = id;
		this.email = email;
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
