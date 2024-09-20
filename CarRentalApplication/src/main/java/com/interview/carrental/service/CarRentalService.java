package com.interview.carrental.service;

import com.interview.carrental.model.Car;
import com.interview.carrental.model.RateRange;
import com.interview.carrental.repository.CarRepository;
import com.interview.carrental.repository.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarRentalService {
    @Autowired
    CarRepository  carRepository;
    @Autowired
    RateRepository rateRepository;

    public List<Car> getAvailableCars() {
        return carRepository.findAll();
    }

    public void addCar(Car car) {
        carRepository.save(car);
    }

    public Car getCarById(Long carId) {
        return carRepository.findById(carId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid car ID"));
    }

    public double calculateRentalCost(Car car, int rentalDuration) {
        Optional<RateRange> rateRange = car.getRate()
            .getRateRanges()
            .stream()
            .filter(range -> rentalDuration >= range.getMinDays() && (
                rentalDuration <= range.getMaxDays() || range.getMaxDays() == Integer.MAX_VALUE))
            .findFirst();
        if (rateRange.isPresent()) {
            return rateRange.get().getRatePerDay() * rentalDuration;
        } else {
            throw new IllegalArgumentException("No rate available for the given duration");
        }
    }
}
