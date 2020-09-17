package com.tanya.maslova.vehiclehire.service;

import com.tanya.maslova.vehiclehire.dao.VehicleHireRepository;
import com.tanya.maslova.vehiclehire.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class VehicleCarHireService {
    @Autowired
    private VehicleHireRepository vehicleHireRepository;

    public List<Car> getAllAvailableCars(){
       return vehicleHireRepository.findCarsByHiredFalse();
    }

    public List<Car> getAllHiredCars(){
        return vehicleHireRepository.findCarsByHiredTrue();
    }

    public int calculateHireCost(List<Car> carsToHire, LocalDate from, LocalDate to){
        return (from != null && to != null)? Optional.ofNullable(carsToHire)
                       .map(Collection::stream)
                       .orElseGet(Stream::empty)
                       .mapToInt(car ->car.getHireCost(from,to))
                       .sum(): 0;
    }
}





