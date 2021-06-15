package by.mybot.api.client;

import by.mybot.api.bean.json.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "JSON-GEO-SERVICE", url = "http://api.travelpayouts.com/data/ru/")
public interface JsonDataClient {

    @RequestMapping(value = "countries.json", method = RequestMethod.GET)
    List<Country> getAllCountry();

    @RequestMapping(value = "planes.json", method = RequestMethod.GET)
    List<Plane> getAllPlanes();

    @RequestMapping(value = "airlines.json", method = RequestMethod.GET)
    List<Airlines> getAllAirlines();

    @RequestMapping(value = "airports.json", method = RequestMethod.GET)
    List<Airport> getAllAirports();

    @RequestMapping(value = "cities.json", method = RequestMethod.GET)
    List<City> getAllCities();

}
