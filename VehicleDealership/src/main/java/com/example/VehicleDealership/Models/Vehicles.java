package com.example.VehicleDealership.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vehicles {
    @Id
    private int vin;
    private int year;
    private String vehicleMake;
    private String vehicleModel;
    private String vehicleType;
    private String color;
    private int odometer;
    private double price;
    private boolean sold;
}
