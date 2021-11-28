package by.cryptic.admin.conrtoller;

import by.cryptic.entities.Currency;
import by.cryptic.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Comparator;
import java.util.stream.Collectors;

import static by.cryptic.utils.ThymleafConstants.*;

@Controller
@RequiredArgsConstructor
@RequestMapping(ADMIN + "/" + CURRENCY)
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping(value = LIST)
    public ModelAndView listPage() {
        ModelAndView modelAndView = new ModelAndView(CURRENCY_ADMIN_ADDRESS);
        modelAndView.addObject(LIST_CURRENCY, currencyService
                .getAllCurrencies()
                .stream()
                .sorted(Comparator.comparing(Currency::getId))
                .collect(Collectors.toList()));
        return modelAndView;
    }

    @GetMapping(value =  SEARCH_BY_NAME)
    public ModelAndView searchCompanyByName(@ModelAttribute(name = "name") String name) {
        ModelAndView modelAndView = new ModelAndView(CURRENCY_ADMIN_ADDRESS);
        modelAndView.addObject(LIST_CURRENCY, currencyService.getCurrencyByName(name));
        return modelAndView;
    }

    @GetMapping(value =  SEARCH_BY_CODE)
    public ModelAndView searchCompanyByCode(@ModelAttribute(name = "code") String code) {
        ModelAndView modelAndView = new ModelAndView(CURRENCY_ADMIN_ADDRESS);
        modelAndView.addObject(LIST_CURRENCY, currencyService.getCurrencyByCode(code));
        return modelAndView;
    }

   /* @GetMapping(value = "/create")
    public String showCreateForm(Model model) {
        model.addAttribute(LIST_CURRENCY, currencyService.getAllCurrencies());
        CurrencyDto currencyForm = new CurrencyDto();
        for (int i = 1; i <= 3; i++) {
            currencyForm.addCurrency(new Currency());
        }
        model.addAttribute("form", currencyForm);
        return "createBooksForm";
    }*/
}
