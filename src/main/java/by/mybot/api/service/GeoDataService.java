package by.mybot.api.service;

import by.mybot.api.bean.GeoData;
import by.mybot.api.client.GeoDataClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeoDataService {

    @Autowired
    private GeoDataClient geoDataClient;

    public GeoData whereAmI(String ipAddress){
        return geoDataClient.getDataByIp(ipAddress);
    }

}
