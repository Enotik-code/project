package by.cryptic.admin.conrtoller;

import by.cryptic.service.WalletService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WalletController {

    @Autowired
    private WalletService walletService;

    @GetMapping
    public ModelAndView getWallets() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("wallets", walletService.getAllWallets());
        return modelAndView;
    }

}
