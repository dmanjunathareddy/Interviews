package com.interview.carrental.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.data.annotation.Id;

@Entity
public class RateRange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int minDays;
    private int maxDays;
    private double ratePerDay;
    @ManyToOne
    @JoinColumn(name = "rate_id")
    private Rate rate;
    // Constructors
    public RateRange() {}
    public RateRange(int minDays, int maxDays, double ratePerDay, Rate rate) {
        this.minDays = minDays;
        this.maxDays = maxDays;
        this.ratePerDay = ratePerDay;
        this.rate = rate;
    }
    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getMinDays() {
        return minDays;
    }
    public void setMinDays(int minDays) {
        this.minDays = minDays;
    }
    public int getMaxDays() {
        return maxDays;
    }
    public void setMaxDays(int maxDays) {
        this.maxDays = maxDays;
    }
    public double getRatePerDay() {
        return ratePerDay;
    }
    public void setRatePerDay(double ratePerDay) {
        this.ratePerDay = ratePerDay;
    }
    public Rate getRate() {
        return rate;
    }
    public void setRate(Rate rate) {
        this.rate = rate;
    }
}