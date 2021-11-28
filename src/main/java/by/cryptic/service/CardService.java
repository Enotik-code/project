package by.cryptic.service;

import by.cryptic.auth.service.UserService;
import by.cryptic.entities.Card;
import by.cryptic.entities.User;
import by.cryptic.repository.CardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.function.BiFunction;

@Slf4j
@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private CurrencyService currencyService;

    public Card saveCard(User user, String cardNumber, Date expirationDate, Integer cvv, String cardHolderName) {
        Card card = Card.builder()
                .cardDate(expirationDate)
                .cardNumber(cardNumber)
                .balance(new BigDecimal("0.00"))
                .userId(user.getId())
                .description(cardHolderName)
                .currency(currencyService.getCurrencyByCode("BYN"))
                .updateDate(new Date())
                .cvvCode(cvv)
                .build();
        log.info("Card {} was created", card);
        return cardRepository.save(card);
    }

    public Card replenishCard(Card card, BigDecimal amount) {
        card.setBalance(card.getBalance().add(amount));
        card.setUpdateDate(new Date());
        log.info("Card {} was replenished", card);
        return cardRepository.save(card);
    }

    public Card withdrawMoney(Card card, BigDecimal amount) {
        card.setBalance(card.getBalance().subtract(amount));
        card.setUpdateDate(new Date());
        log.info("Card {} was withdrawed", card);
        return cardRepository.save(card);
    }

    public Card getCardByNumber(String cardNumber) {
        return cardRepository.findByCardNumber(cardNumber);
    }


}
