package by.mybot.service.locations;

import by.mybot.api.bean.GeoData;
import by.mybot.api.service.GeoDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class LocationService {

    @Autowired
    private GeoDataService geoDataService;

    public GeoData getLocationFromIp(HttpServletRequest request){
       return geoDataService.whereAmI(getIpFromRequest(request));
    }

    private String getIpFromRequest(HttpServletRequest request) {
        String remoteAddr = "";
        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }
        return remoteAddr;
    }
}
