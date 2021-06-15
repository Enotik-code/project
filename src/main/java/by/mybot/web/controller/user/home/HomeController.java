package by.mybot.web.controller.user.home;

import by.mybot.service.locations.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @Autowired
    private LocationService locationService;

    @GetMapping(value = "/air")
    public ResponseEntity getHomePage(HttpServletRequest httpServletRequest){
        return ResponseEntity.ok(locationService.getLocationFromIp(httpServletRequest).toString());
    }

    /*@RequestMapping(value = "/processing", method = RequestMethod.GET)
    public void processData (HttpServletRequest request) {
        System.out.println(request.getRemoteAddr());

    }*/
}
