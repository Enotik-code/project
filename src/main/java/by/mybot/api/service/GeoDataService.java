package by.mybot.api.service;

import by.mybot.api.bean.GeoData;
import by.mybot.api.bean.additional.Capital;
import by.mybot.api.bean.additional.CapitalResponse;
import by.mybot.api.client.GeoDataClient;
import by.mybot.api.exceptions.GeoDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.GeneralSecurityException;
import java.util.List;

@Service
public class GeoDataService {

    @Autowired
    private GeoDataClient geoDataClient;

    public GeoData whereAmI(String ipAddress){
        return geoDataClient.getDataByIp(ipAddress);
    }

    public CapitalResponse infoAboutCountry(String countryName){

        return geoDataClient.getDataByCountry(countryName);
    }

}
