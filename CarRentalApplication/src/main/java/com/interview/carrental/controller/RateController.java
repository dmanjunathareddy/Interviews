package com.interview.carrental.controller;

import com.interview.carrental.model.Rate;
import com.interview.carrental.repository.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rate")
public class RateController {
    @Autowired
    private RateRepository rateRepository;

    @PostMapping("/add")
    public String addRate(
        @RequestBody
        Rate rate) {
        rateRepository.save(rate);
        return "Rate for " + rate.getCarModel() + " added.";
    }

    @GetMapping("/{id}")
    public Rate getRate(
        @PathVariable
        Long id) {
        return rateRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Rate not found"));
    }

    @GetMapping("/all")
    public List<Rate> getAllRates() {
        return rateRepository.findAll();
    }
}