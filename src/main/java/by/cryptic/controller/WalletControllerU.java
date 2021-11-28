package by.cryptic.controller;


import by.cryptic.entities.Wallet;
import by.cryptic.service.CurrencyService;
import by.cryptic.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.Date;

import static by.cryptic.utils.ThymleafConstants.LIST_CURRENCY;
import static by.cryptic.utils.ThymleafConstants.WALLET_ADDRESS;

@Controller
@RequestMapping("/wallet")
public class WalletControllerU {

    @Autowired
    private WalletService walletService;

    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/create")
    public ModelAndView create(){
        ModelAndView modelAndView = new ModelAndView(WALLET_ADDRESS);
        modelAndView.addObject(LIST_CURRENCY, currencyService.getAllCurrencies());
        return modelAndView;
    }

    @GetMapping("/createWallet")
    public ModelAndView createWallet() {
        ModelAndView modelAndView = new ModelAndView();

        String userLogin = "user";
        String userSalt = "salt";
        String description = "description";

        Wallet wallet = Wallet.builder()
                .address(walletService.generateAddress(userLogin))
                .createDate(new Date())
                .balance(new BigDecimal("0.00"))
                .description(description)
                .updateDate(new Date())
                .sign(userSalt)
                .sealed(false)
                .currency(currencyService.getCurrencyByName("BTC"))
                .build();

        walletService.createWallet(wallet);

        modelAndView.setViewName("success");
        return modelAndView;
    }

}
