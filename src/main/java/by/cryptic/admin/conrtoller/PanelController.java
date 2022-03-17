package by.cryptic.admin.conrtoller;

import by.cryptic.service.CurrencyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("admin/panel")
public class PanelController {

    @Autowired
    CurrencyService currencyService;

    @GetMapping("")
    public String panel() {
        log.info("PanelController get request");
        return "admin/panel";
    }

    @GetMapping("/users")
    public String users() {
        log.info("UsersController get request");
        return "admin/users";
    }

    @GetMapping("/currencies")
    public String currencies() {
        log.info("CurrenciesController get request");
        return "redirect:/admin/currencies";
    }
}
