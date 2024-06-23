package com.example.VehicleDealership.Repositories;

import com.example.VehicleDealership.Models.Vehicles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicles, Long> {

    List<Vehicles> findAllByPriceGreaterThan(Double price);

    List<Vehicles> findAllByPriceLessThan(Double price);

    List<Vehicles> findAllByVehicleMake(String vehicleMake);

    List<Vehicles> findAllByVehicleModel(String vehicleModel);

    List<Vehicles> findAllByYearGreaterThanEqual(Integer year);

    List<Vehicles> findAllByYearLessThanEqual(Integer year);

    List<Vehicles> findAllByColor(String color);

    List<Vehicles> findAllByOdometerGreaterThanEqual(Integer miles);

    List<Vehicles> findAllByOdometerLessThanEqual(Integer miles);

    List<Vehicles> findAllByVehicleType(String vehicleType);
}