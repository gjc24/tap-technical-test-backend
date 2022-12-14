package tapcoltd.techicaltest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tapcoltd.techicaltest.entity.CalculatedFare;
import tapcoltd.techicaltest.entity.Driver;
import tapcoltd.techicaltest.service.CalculatedFareService;
import tapcoltd.techicaltest.service.DriverService;

import java.util.List;
import java.util.NoSuchElementException;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("api/fare")
public class CalculatedFareController {

    @Autowired
    CalculatedFareService calculatedFareService;

    @GetMapping("/view-fares/{id}")
    public List<CalculatedFare> view(@PathVariable Integer id) {
        return calculatedFareService.viewCalculatedFares(id);
    }

    @GetMapping("/calculate-fare/{id}")
    public List<CalculatedFare> calculate(@PathVariable Integer id) {
        return calculatedFareService.scanAndCalculateFare(id);
    }
}
