package com.interview.carrental.controller;
import com.interview.carrental.model.Car;
import com.interview.carrental.model.Rental;
import com.interview.carrental.service.CarRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/rental")
public class CarRentalController {
    @Autowired
    private CarRentalService carRentalService;
    @GetMapping("/cars")
    public List<Car> getAvailableCars() {
        return carRentalService.getAvailableCars();
    }
    @PostMapping("/cars")
    public String addCar(@RequestBody Car car) {
        carRentalService.addCar(car);
        return "Car added: " + car;
    }
    @GetMapping("/calculateCost/{carId}/{days}")
    public String calculateRentalCost(@PathVariable Long carId, @PathVariable int days) {
        Car selectedCar = carRentalService.getCarById(carId);
        double totalCost = carRentalService.calculateRentalCost(selectedCar, days);
        return "Total cost for renting " + selectedCar.getModel() + " for " + days + " days is $" + totalCost;
    }
    @PostMapping("/rent")
    public String rentCar(@RequestParam Long carId, @RequestParam String customerName,
        @RequestParam int days) {
        Car selectedCar = carRentalService.getCarById(carId);
        Rental rental = new Rental(selectedCar, days);
        double totalCost = rental.calculateTotalCost();
        return "Customer " + customerName + " rented the " + selectedCar.getModel() + " for " + days + " days. Total cost: $" + totalCost;
    }
}