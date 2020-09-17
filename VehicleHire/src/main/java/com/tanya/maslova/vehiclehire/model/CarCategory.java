package com.tanya.maslova.vehiclehire.model;

import java.time.LocalDate;
import java.time.Period;

public enum CarCategory {
    SMALL(25, "small"), ESTATE(35, "estate"), VAN(50, "van");

  private int pricePerDay;
  private String category;
    CarCategory(int pricePerDay, String category){
        this.pricePerDay = pricePerDay;
        this.category = category;
    }
    public int calculateCostPerDateRange(LocalDate from, LocalDate to){
       int days = Period.between(from, to).getDays();
       return this.pricePerDay * days;
    }
}

