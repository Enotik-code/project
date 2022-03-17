package by.cryptic.controller;

import by.cryptic.api.btc.BtcService;
import by.cryptic.api.eth.EthService;
import by.cryptic.models.explorer.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static by.cryptic.utils.HttpConstant.ADDRESS;

@Controller
public class ExplorerController {

    @Autowired
    EthService ethService;

    @Autowired
    BtcService btcService;

    @GetMapping("/explorer")
    public String greetingForm() {
        return "explorer";
    }

    @PostMapping("/explorer")
    public String greetingSubmit(@ModelAttribute Address address, Model model) {
        model.addAttribute(ADDRESS, address);
        return "explorer";
    }

    @GetMapping(value = "/eth/address")
    public ModelAndView getEthTransactionsByAddress(@RequestParam String address) {
        ModelAndView modelAndView = new ModelAndView("/user/explorer/transactions");
        modelAndView.addObject("currency", "ETH");
        modelAndView.addObject(ADDRESS, address);
        modelAndView.addObject("transactions", ethService.getTransactionListByAddress(address));
        //test address - 0x2b19fde5d7377b48be50a5d0a78398a496e8b15c
        return modelAndView;
    }

    @GetMapping(value = "/btc/address")
    public ModelAndView getBtcTransactionsByAddress(@RequestParam String address) {
        ModelAndView modelAndView = new ModelAndView("/user/explorer/transactions");
        modelAndView.addObject("currency", "BTC");
        modelAndView.addObject(ADDRESS, address);
        modelAndView.addObject("transactions", btcService.getTransactionListByAddress(address));
        //test address - 3JMU6GuHB51JsQ6ujDRLixefaY8ygsnJBf
        return modelAndView;
    }
}
