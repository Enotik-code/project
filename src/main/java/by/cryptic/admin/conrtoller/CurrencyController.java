package by.cryptic.admin.conrtoller;

import by.cryptic.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("admin/currency")
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping(value = "/list")
    public ModelAndView listPage() {
        ModelAndView modelAndView = new ModelAndView("admin/currency/listCurrency");
        modelAndView.addObject("listCurrency", currencyService.getAllCurrencies());
        return modelAndView;
    }

}
