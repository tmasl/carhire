package com.tanya.maslova.vehiclehire.service;

import com.tanya.maslova.vehiclehire.model.Car;
import com.tanya.maslova.vehiclehire.model.CarCategory;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VehicleCarHireServiceTest {
    private VehicleCarHireService vehicleCarHireService = new VehicleCarHireService();



    @Test
    public void givenListOfDifferentCars_whenCalculateHireCost_returnCostOfAllVehicles() {
        LocalDate dateFrom = LocalDate.parse("2020-09-17");
        LocalDate dateTo = LocalDate.parse("2020-09-20");
        int expectedResult = 330;
        assertEquals(expectedResult, vehicleCarHireService.calculateHireCost(getListOfDifferentCars(), dateFrom, dateTo));
    }

    @Test
    public void givenEmptyListOfCars_whenCalculateHireCost_returnZero(){
        LocalDate dateFrom = LocalDate.parse("2020-09-17");
        LocalDate dateTo = LocalDate.parse("2020-09-20");
        int expectedResult = 0;
        assertEquals(expectedResult, vehicleCarHireService.calculateHireCost(new ArrayList<Car>(), dateFrom, dateTo));
    }

    @Test
    public void givenNullArgument_whenCalculateHireCost_returnZero(){
        LocalDate dateFrom = LocalDate.parse("2020-09-17");
        LocalDate dateTo = LocalDate.parse("2020-09-20");
        int expectedResult = 0;
        assertEquals(expectedResult, vehicleCarHireService.calculateHireCost(null, dateFrom, dateTo));
    }

    private List<Car> getListOfDifferentCars(){
        return Arrays.asList(new Car[]{Car.builder().carCategory(CarCategory.ESTATE).build(),
                Car.builder().carCategory(CarCategory.SMALL).build(),
                Car.builder().carCategory(CarCategory.VAN).build()});
    }
}
