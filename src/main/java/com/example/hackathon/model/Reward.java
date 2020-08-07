package com.example.hackathon.model;

import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;

public abstract class Reward {

	@Transient    //marking a field as not persistable
	protected Long points;

	@Transient
	protected Double emiAmount;

	public abstract Long getPoints();

	public abstract Double getEmiAmount();

}
