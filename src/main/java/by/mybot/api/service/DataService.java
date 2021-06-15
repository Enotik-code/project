package by.mybot.api.service;

import by.mybot.api.bean.json.*;
import by.mybot.api.client.JsonDataClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {

    @Autowired
    private JsonDataClient jsonDataClient;

    public List<Country> getAllCountries() {
        return jsonDataClient.getAllCountry();
    }

    public Country getCountryByName(String name){
        return jsonDataClient.getAllCountry().stream()
                .filter(country -> country.getName().equals(name))
                .findAny()
                .orElse(null);
    }

    public List<Airlines> getAllAirlines() {
        return jsonDataClient.getAllAirlines();
    }

    public Airlines getAirlinesByName(String name){
        return jsonDataClient.getAllAirlines().stream()
                .filter(airlines -> airlines.getName().equals(name))
                .findAny()
                .orElse(null);
    }

    public List<Plane> getAllPlanes() {
        return jsonDataClient.getAllPlanes();
    }

    public List<City> getAllCities() {
        return jsonDataClient.getAllCities();
    }

    public List<Airport> getAllAirports(){
        return jsonDataClient.getAllAirports();
    }

    public Airport getAirportByCode(String code){
        return jsonDataClient.getAllAirports().stream()
                .filter(airport -> airport.getCode().equals(code))
                .findAny()
                .orElse(null);
    }

    public Airport getAirportByName(String name){
        return jsonDataClient.getAllAirports().stream()
                .filter(airport -> airport.getName().equals(name))
                .findAny()
                .orElse(null);
    }

}
