package by.mybot.web.controller.user;

import by.mybot.api.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.sql.ResultSet;

@RestController
public class IndexController {

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
}
