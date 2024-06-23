package com.example.VehicleDealership.Controllers;

import com.example.VehicleDealership.Models.Vehicles;
import com.example.VehicleDealership.Repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/web/Vehicles")
public class VehicleController {
    @Autowired
    private VehicleRepository vehicleRepository;

    @GetMapping
    public ResponseEntity<List<Vehicles>> minPrice(Double price){
        var vehicles = vehicleRepository.findAllByPriceLessThan(price);
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @GetMapping("/{price}")
    public ResponseEntity<List<Vehicles>> maxPrice(@PathVariable Double price){
        var vehicles = vehicleRepository.findAllByPriceGreaterThan(price);
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @GetMapping("/{vehicleMake}")
    public ResponseEntity<List<Vehicles>> byVehicleMake(@PathVariable String vehicleMake) {
        var vehicles = vehicleRepository.findAllByVehicleMake(vehicleMake);
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @GetMapping("/{vehicleModel}")
    public ResponseEntity<List<Vehicles>> byVehicleModel(@PathVariable String vehicleModel) {
        var vehicles = vehicleRepository.findAllByVehicleModel(vehicleModel);
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Vehicles>> minYear(@PathVariable Integer year) {
        var vehicles = vehicleRepository.findAllByYearGreaterThanEqual(year);
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @GetMapping("/{year}")
    public ResponseEntity<List<Vehicles>> maxYear(@PathVariable Integer year) {
        var vehicles = vehicleRepository.findAllByYearLessThanEqual(year);
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @GetMapping("/{color}")
    public ResponseEntity<List<Vehicles>> byColor(@PathVariable String color) {
        var vehicles = vehicleRepository.findAllByColor(color);
        return new ResponseEntity<>(vehicles, HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<Vehicles>> minOdometer(@PathVariable Integer odometer) {
        var vehicles = vehicleRepository.findAllByOdometerGreaterThanEqual(odometer);
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @GetMapping("/{odometer}")
    public ResponseEntity<List<Vehicles>> maxOdometer(@PathVariable Integer odometer) {
        var vehicles = vehicleRepository.findAllByOdometerLessThanEqual(odometer);
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @GetMapping("/{vehicleType}")
    public ResponseEntity<List<Vehicles>> byVehicleType(@PathVariable String vehicleType) {
        var vehicles = vehicleRepository.findAllByVehicleType(vehicleType);
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Vehicles> addVehicle(@RequestBody Vehicles vehicle) {
        Vehicles savedVehicle = vehicleRepository.save(vehicle);
        return new ResponseEntity<>(savedVehicle, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicles> updateVehicle(@PathVariable Long id, @RequestBody Vehicles updatedVehicle) {
        Optional<Vehicles> existingVehicleOptional = vehicleRepository.findById(id);

        if (existingVehicleOptional.isPresent()) {
            Vehicles existingVehicle = existingVehicleOptional.get();
            existingVehicle.setVehicleMake(updatedVehicle.getVehicleMake());
            existingVehicle.setVehicleModel(updatedVehicle.getVehicleModel());
            existingVehicle.setYear(updatedVehicle.getYear());
            existingVehicle.setPrice(updatedVehicle.getPrice());
            existingVehicle.setColor(updatedVehicle.getColor());
            existingVehicle.setOdometer(updatedVehicle.getOdometer());
            existingVehicle.setVehicleType(updatedVehicle.getVehicleType());
            Vehicles savedVehicle = vehicleRepository.save(existingVehicle);
            return new ResponseEntity<>(savedVehicle, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        if (vehicleRepository.existsById(id)) {
            vehicleRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
}
