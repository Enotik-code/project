package by.mybot.controller.user;

import by.mybot.consts.Pages;
import by.mybot.consts.Paths;
import by.mybot.payment.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PaymentController {

    @Autowired
    private OperationService operationService;

    @GetMapping(value = Pages.PAYMENT_HOME)
    public ModelAndView getPaymentHomePage(){
        ModelAndView modelAndView = new ModelAndView(Paths.PAYMENT_HOME_HTML);
        modelAndView.addObject("operations", operationService.getAllOperations());
        return modelAndView;
    }
}
