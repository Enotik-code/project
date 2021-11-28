package by.cryptic.admin.conrtoller;

import by.cryptic.entities.Currency;
import by.cryptic.entities.CurrencyPair;
import by.cryptic.service.CurrencyPairService;
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
@RequestMapping(ADMIN + "/" + CURRENCY_PAIR)
public class CurrencyPairController {

    private final CurrencyPairService currencyPairService;

    @GetMapping(value = LIST)
    public ModelAndView getAll(){
        ModelAndView modelAndView = new ModelAndView(CURRENCY_PAIR_ADMIN_ADDRESS);
        modelAndView.addObject(LIST_CURRENCY_PAIR, currencyPairService.getAll()
                .stream()
                .sorted(Comparator.comparing(CurrencyPair::getId))
                .collect(Collectors.toList()));
        return modelAndView;
    }

    @GetMapping(value = SEARCH_BY_NAME)
    public ModelAndView searchCompanyByName(@ModelAttribute(name = "name") String name) {
        ModelAndView modelAndView = new ModelAndView(CURRENCY_PAIR_ADMIN_ADDRESS);
        modelAndView.addObject(LIST_CURRENCY_PAIR, currencyPairService.getCurrencyPairByName(name));
        return modelAndView;
    }

    @GetMapping(value = SEARCH_BY_ID)
    public ModelAndView searchCompanyByCode(@ModelAttribute(name = "id") Integer id) {
        ModelAndView modelAndView = new ModelAndView(CURRENCY_PAIR_ADMIN_ADDRESS);
        modelAndView.addObject(LIST_CURRENCY_PAIR, currencyPairService.getCurrencyPairById(id));
        return modelAndView;
    }


}
