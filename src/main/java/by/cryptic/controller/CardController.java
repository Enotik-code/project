package by.cryptic.controller;

import by.cryptic.service.CardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;

import static by.cryptic.utils.HttpConstant.CARD_LIST;

@Slf4j
@Controller
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping("/my")
    public ModelAndView getCardsPage() {
        ModelAndView modelAndView = new ModelAndView("/user/card/list");
        Long userId = 63187L;
        modelAndView.addObject(CARD_LIST, cardService.findCardByUserId(userId));
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView getAddCardPage() {
        return new ModelAndView("/user/card/add");
    }

    @GetMapping("/replenish")
    public ModelAndView getReplenishCardPage() {
        ModelAndView modelAndView = new ModelAndView("/user/card/replenish");
        Long userId = 63187L;
        modelAndView.addObject(CARD_LIST, cardService.findCardByUserId(userId));
        return modelAndView;
    }

    @PostMapping("/replenish")
    public ModelAndView replenishCard(@RequestParam(value = "card", required = false) String card,
                                      @RequestParam(value = "amount", required = false) BigDecimal amount) {
        cardService.replenishCard(card, amount);
        log.info("Card replenished");
        return new ModelAndView("success");
    }

    @GetMapping("/transfer")
    public ModelAndView getTransferCardPage() {
        ModelAndView modelAndView = new ModelAndView("/user/card/transfer");
        Long userId = 63187L;
        modelAndView.addObject(CARD_LIST, cardService.findCardByUserId(userId));
        return modelAndView;
    }

    @GetMapping("/withdraw")
    public ModelAndView getWithdrawCardPage() {
        ModelAndView modelAndView = new ModelAndView("/user/card/withdraw");
        Long userId = 63187L;
        modelAndView.addObject(CARD_LIST, cardService.findCardByUserId(userId));
        return modelAndView;
    }

    @PostMapping("/withdraw")
    public ModelAndView withdrawCard(@RequestParam(value = "card", required = false) String card,
                                     @RequestParam(value = "amount", required = false) BigDecimal amount) {
        cardService.withdrawMoney(card, amount);
        log.info("Card withdrawn");
        return new ModelAndView("success");
    }
}
