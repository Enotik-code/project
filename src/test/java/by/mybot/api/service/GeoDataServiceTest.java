package by.mybot.api.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeoDataServiceTest {

    private GeoDataService geoDataService = new GeoDataService();

    @Test
    void whereAmI() {
        String ip = "123.23.45.77";
        System.out.println(geoDataService.whereAmI(ip));
    }
}