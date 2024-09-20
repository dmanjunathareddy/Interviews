package com.interview.carrental.model;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
@Entity
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String carModel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rate", fetch = FetchType.LAZY)
    private List<RateRange> rateRanges;
    // Constructors
    public Rate() {}
    public Rate(String carModel, List<RateRange> rateRanges) {
        this.carModel = carModel;
        this.rateRanges = rateRanges;
    }
    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCarModel() {
        return carModel;
    }
    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }
    public List<RateRange> getRateRanges() {
        return rateRanges;
    }
    public void setRateRanges(List<RateRange> rateRanges) {
        this.rateRanges = rateRanges;
    }
}