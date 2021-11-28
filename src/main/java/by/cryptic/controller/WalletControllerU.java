package by.cryptic.controller;


import by.cryptic.auth.service.UserService;
import by.cryptic.entities.Currency;
import by.cryptic.entities.User;
import by.cryptic.entities.Wallet;
import by.cryptic.service.CurrencyService;
import by.cryptic.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.Date;

import static by.cryptic.utils.ThymleafConstants.LIST_CURRENCY;
import static by.cryptic.utils.ThymleafConstants.WALLET_ADDRESS;

@Controller
@RequestMapping("/wallet/crypto")
public class WalletControllerU {

    @Autowired
    private WalletService walletService;

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private UserService userService;

    @GetMapping("/my")
    public ModelAndView myWallets(){
        ModelAndView modelAndView = new ModelAndView("/user/wallet/list");
        User user = userService.findUserById(63187L);
        modelAndView.addObject("listWallet", walletService.getWallets(user.getSalt()));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create(){
        ModelAndView modelAndView = new ModelAndView(WALLET_ADDRESS);
        modelAndView.addObject(LIST_CURRENCY, currencyService.getAllCurrencies());
        return modelAndView;
    }

    @PostMapping("/createWallet")
    public ModelAndView createWallet(@RequestParam(value = "currency", required = false) String currency,
                                     @RequestParam(value = "description", required = false) String description){
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.findUserById(63187L);
        Currency currencyCurrent = currencyService.getCurrencyByName(currency);

        String userLogin = user.getLogin();
        String userSalt = user.getSalt();

        Wallet wallet = Wallet.builder()
                .address(walletService.generateAddress(userLogin))
                .createDate(new Date())
                .balance(new BigDecimal("0.00"))
                .description(description)
                .updateDate(new Date())
                .sign(userSalt)
                .sealed(false)
                .currency(currencyCurrent)
                .build();

        walletService.createWallet(wallet);

        modelAndView.setViewName("success");
        return modelAndView;
    }

}
