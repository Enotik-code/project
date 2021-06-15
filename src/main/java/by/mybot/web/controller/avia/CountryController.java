package by.mybot.web.controller.avia;

import by.mybot.api.bean.GeoData;
import by.mybot.api.bean.additional.Capital;
import by.mybot.api.bean.additional.CapitalResponse;
import by.mybot.api.client.GeoDataClient;
import by.mybot.api.client.LogoDataClient;
import by.mybot.api.service.GeoDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.List;

@Controller
public class CountryController {

    public static final String WIDTH = "400";
    public static final String HEIGHT = "400";
    @Autowired
    private LogoDataClient logoDataClient;

    @Autowired
    private GeoDataService geoDataService;


    @GetMapping("/country/{countryName}")
    public ModelAndView getCountryInfoByName(@PathVariable String countryName){
        ModelAndView modelAndView = new ModelAndView("/avia/country");
        //modelAndView.addObject("flag", new File("./resources/avia/flags/" + ));

        CapitalResponse geoData = geoDataService.infoAboutCountry(countryName);
        //modelAndView.addObject("geoDatas", geoData.get(0));
        //  modelAndView.addObject("logo", logoDataClient.getLogoFileByIataCode(WIDTH, HEIGHT, geoData.getIataCode()));
        return modelAndView;
    }
}
