package com.interview.carrental.model;
import java.util.Optional;
public class Rental {
    private Car car;
    private int rentalDuration;
    public Rental(Car car, int rentalDuration) {
        this.car = car;
        this.rentalDuration = rentalDuration;
    }
    public double calculateTotalCost() {
        Optional<RateRange> rateRange = car.getRate().getRateRanges().stream()
            .filter(range -> rentalDuration >= range.getMinDays() && rentalDuration <= range.getMaxDays())
            .findFirst();
        if (rateRange.isPresent()) {
            return rateRange.get().getRatePerDay() * rentalDuration;
        } else {
            throw new IllegalArgumentException("No rate available for the given duration");
        }
    }
}