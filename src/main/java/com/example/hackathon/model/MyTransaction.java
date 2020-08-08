package com.example.hackathon.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @Override
    public Long getPoints() {
        this.points = 0l;

        if (this.amount > 1000 && this.amount <= 5000) {
            this.points += 10;
        }
        if (this.amount > 5000 && this.amount <= 15000) {
            this.points += 20;
        }
        if (this.amount > 15000 && this.amount <= 25000) {
            this.points += 30;
        }
        if (this.amount > 25000) {
            this.points += 40;
        }

        return this.points;
    }

    @Override
    public Double getEmiAmount() {
        return null;
    }
}
