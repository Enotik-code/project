package by.mybot.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.File;

@FeignClient(name = "LOGO-SERVICE", url = "http://pics.avs.io/200/200/UN.png.")
public interface LogoDataClient {

    @RequestMapping(value = "/{width}/{height}/{iata}", method = RequestMethod.GET)
    File getLogoFileByIataCode(@PathVariable String width, @PathVariable String height, @PathVariable String iata);
}
