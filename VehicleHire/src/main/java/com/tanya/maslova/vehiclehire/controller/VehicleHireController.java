package com.tanya.maslova.vehiclehire.controller;

import com.tanya.maslova.vehiclehire.model.Car;
import com.tanya.maslova.vehiclehire.service.VehicleCarHireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class VehicleHireController {
    @Autowired
    private VehicleCarHireService vehicleCarHireService;
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("eventName", "FIFA 2018");
        return "index";
    }

    @GetMapping("/availableCars")
    public List<Car> getAvailableCars(){
        return vehicleCarHireService.getAllAvailableCars();
    }

    @GetMapping("/hiredCars")
    public List<Car> getHiredCars(){
        return vehicleCarHireService.getAllHiredCars();
    }

    @PostMapping("/calculateHireCost")
    public int calculateHireCost(@RequestBody List<Car> cars, LocalDate from, LocalDate to){
        return vehicleCarHireService.calculateHireCost(cars,from, to);
    }
}
