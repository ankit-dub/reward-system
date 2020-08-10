package com.example.hackathon.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

	private Long rewardPoints;

	@JsonIgnore
	@OneToOne(mappedBy="customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private MyEmi emi;

	@JsonIgnore
	@OneToMany(mappedBy="customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<MyTransaction> transactions;



	@Transient
	private Double totalPaid;

	public Customer(Integer id, String email,Long Apprvamount,Long rewardPoints) {
		super();
		this.id = id;
		this.email = email;
		this.Apprvamount=Apprvamount;
		this.rewardPoints=rewardPoints;
	}

	public Long getRewardPoints() {
		if (emi == null) return 0l;
		if(transactions==null || transactions.isEmpty()) return emi.getPoints()+5000l;
		return emi.getPoints()+transactions.stream().map(x -> x.getPoints().intValue()).reduce(0, (a,b) -> a + b).longValue()+5000l;
	}
	public Double getTotalPaid() {
		if (transactions == null || transactions.isEmpty()) return 0d;
		
		return transactions.stream().map(x -> x.getAmount().doubleValue()).reduce(0d, (a,b) -> a + b).doubleValue();
	}

}
