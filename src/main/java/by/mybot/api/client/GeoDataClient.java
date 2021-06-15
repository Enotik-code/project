package by.mybot.api.client;

import by.mybot.api.bean.GeoData;
import by.mybot.api.bean.IataParams;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "GEO-SERVICE", url = "http://www.travelpayouts.com")
public interface GeoDataClient {

    @RequestMapping(value = "/whereami?locale=ru&callback=useriata&ip={ip}", method = RequestMethod.GET)
    GeoData getDataByIp(@PathVariable String ip);

    @RequestMapping(value = "/widgets_suggest_params?q=Из%20{cityOf}%20в%20{cityIn}", method = RequestMethod.GET)
    IataParams getDataByTwoValues(@PathVariable String cityOf, @PathVariable String cityIn);


}
