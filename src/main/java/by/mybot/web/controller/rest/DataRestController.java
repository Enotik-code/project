package by.mybot.web.controller.rest;

import by.mybot.api.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataRestController {

    @Autowired
    private DataService dataService;

    @GetMapping("api/country/{name}")
    public ResponseEntity getCountryByName(@PathVariable String name){
        return ResponseEntity.ok(dataService.getCountryByName(name));
    }

    @GetMapping("api/countries")
    public ResponseEntity getAllCountries(){
        return ResponseEntity.ok(dataService.getAllCountries());
    }

    @GetMapping("api/airports")
    public ResponseEntity getAllAirports() {
        return ResponseEntity.ok(dataService.getAllAirports());
    }

    @GetMapping("api/airport/code={code}")
    public ResponseEntity getAirportByCode(@PathVariable String code){
        return ResponseEntity.ok(dataService.getAirportByCode(code));
    }

    @GetMapping("api/airport/name={name}")
    public ResponseEntity getAirportByName(@PathVariable String name){
        return ResponseEntity.ok(dataService.getAirportByName(name));
    }

    @GetMapping("api/airlines")
    public ResponseEntity getAllLines(){
        return ResponseEntity.ok(dataService.getAllAirlines());
    }

    @GetMapping("api/airlines/name={name}")
    public ResponseEntity getAirlinesByName(@PathVariable String name){
        return ResponseEntity.ok(dataService.getAirlinesByName(name));
    }

    @GetMapping("api/planes")
    public ResponseEntity getAllPlanes(){
        return ResponseEntity.ok(dataService.getAllPlanes());
    }

    @GetMapping("api/cities")
    public ResponseEntity getAllCities(){
        return ResponseEntity.ok(dataService.getAllCities());
    }
}
