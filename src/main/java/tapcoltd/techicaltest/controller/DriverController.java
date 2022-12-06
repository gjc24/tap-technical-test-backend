package tapcoltd.techicaltest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tapcoltd.techicaltest.entity.Driver;
import tapcoltd.techicaltest.service.DriverService;

import java.util.List;
import java.util.NoSuchElementException;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("api/driver-profile")
public class DriverController {

    @Autowired
    DriverService driverService;

    @GetMapping("")
    public List<Driver> list() {
        return driverService.getAllDrivers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Driver> get(@PathVariable Integer id) {
        try{
            Driver driver = driverService.getDriverById(id);
            return new ResponseEntity<Driver>(driver, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Driver>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public void add(@RequestBody Driver driver) {
        driverService.addDriver(driver);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Driver driver, @PathVariable Integer id) {
        try{
            driver.setDriverId(id);
            driverService.addDriver(driver);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { driverService.deleteDriver(id);}


}
