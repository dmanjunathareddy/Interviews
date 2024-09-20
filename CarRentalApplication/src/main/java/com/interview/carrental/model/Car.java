package com.interview.carrental.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    @ManyToOne
    @JoinColumn(name = "rate_id")
    private Rate rate;
    // Constructors
    public Car() {}
    public Car(String model, Rate rate) {
        this.model = model;
        this.rate = rate;
    }
    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public Rate getRate() {
        return rate;
    }
    public void setRate(Rate rate) {
        this.rate = rate;
    }
}