package by.cryptic.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        log.info("Index page");
        return "/user/basic/index";
    }

    @GetMapping("/trading/instruments")
    public String tradingInstruments() {
        return "/user/basic/tradingInstruments";
    }

    @GetMapping("/market/review")
    public String review() {
        return "/user/basic/trading/marketReview";
    }

    @GetMapping("/cross/rates")
    public String crossRates() {
        return "/user/basic/trading/crossRates";
    }

    @GetMapping("cryptocurrency/market")
    public String cryptocurrencyMarket() {
        return "/user/basic/trading/cryptocurrencyMarket";
    }

    @GetMapping("/skinner")
    public String skinner() {
        return "/user/basic/trading/skinner";
    }
}
