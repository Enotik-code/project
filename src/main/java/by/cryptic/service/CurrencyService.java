package by.cryptic.service;

import by.cryptic.entities.Currency;
import by.cryptic.entities.CurrencyPair;
import by.cryptic.repository.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class CurrencyService {

    private final CurrencyRepository currencyRepository;

    public Collection<Currency> getAllCurrencies() {
        log.info("Getting all currencies");
        return currencyRepository.findAll();
    }

    public Currency getCurrencyByName(String name) {
        log.info("Getting currency by name: {}", name);
        return currencyRepository.findByName(name);
    }

    public Currency getCurrencyByCode(String code) {
        log.info("Getting currency by code: {}", code);
        return currencyRepository.findByCode(code);
    }

    public void save(Currency currency) {
        log.info("Saving currency: {}", currency);
        currencyRepository.save(currency);
    }

    public void delete(Currency currency) {
        log.info("Deleting currency: {}", currency);
        currencyRepository.delete(currency);
    }


}
