package by.cryptic.controller;

import by.cryptic.entities.Country;
import by.cryptic.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Comparator;
import java.util.stream.Collectors;

import static by.cryptic.utils.ThymleafConstants.COUNTRY_LIST;

@Controller
public class AuthController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/user/create")
    public ModelAndView createUser() {
        ModelAndView modelAndView = new ModelAndView("/user/account/create");
        modelAndView.addObject(COUNTRY_LIST, countryService.getAllCountries()
                .stream()
                .sorted(Comparator.comparing(Country::getScCheckName))
                .collect(Collectors.toList()));
        return modelAndView;
    }
}
