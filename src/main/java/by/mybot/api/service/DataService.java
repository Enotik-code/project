package by.mybot.api.service;

import by.mybot.api.bean.json.Airlines;
import by.mybot.api.bean.json.Airports;
import by.mybot.api.bean.json.Country;
import by.mybot.api.bean.json.Plane;
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

    public List<Airlines> getAllAirlines() {
        return jsonDataClient.getAllAirlines();
    }

    public List<Plane> getAllPlanes() {
        return jsonDataClient.getAllPlanes();
    }

    public List<Airports> getAllAirports(){
        return jsonDataClient.getAllAirports();
    }

    public Country getCountryByName(String name){
        return jsonDataClient.getAllCountry().stream()
                .filter(country -> country.getName().equals(name))
                .findAny()
                .orElse(null);
    }

}
