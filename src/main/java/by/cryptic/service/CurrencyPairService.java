package by.cryptic.service;

import by.cryptic.entities.Currency;
import by.cryptic.entities.CurrencyPair;
import by.cryptic.repository.CurrencyPairRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CurrencyPairService {

    private final CurrencyPairRepository currencyPairRepository;

    public void save(CurrencyPair currencyPair) {
        log.info("Saving currency pair: {}", currencyPair);
        currencyPairRepository.save(currencyPair);
    }

    public CurrencyPair getByName(String name) {
        log.info("Getting currency pair by name: {}", name);
        return currencyPairRepository.findByName(name);
    }

    public void update(Currency currency, Currency targetCurrency, Long id ) {
        log.info("Updating currency pair: {}", currency);
        currencyPairRepository.updateCurrencyPair(currency, targetCurrency, id);
    }

   /* public void insertCurrencyPair(String name,  Currency currency, Currency targetCurrency) {
        log.info("Inserting currency pair: {}", currency);
        currencyPairRepository.insertCurrencyPair(name, currency, targetCurrency);
    }*/

    public void delete(CurrencyPair currencyPair) {
        log.info("Deleting currency pair: {}", currencyPair);
        currencyPairRepository.delete(currencyPair);
    }


}
