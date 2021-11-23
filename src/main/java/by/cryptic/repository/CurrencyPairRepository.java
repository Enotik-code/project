package by.cryptic.repository;

import by.cryptic.entities.Currency;
import by.cryptic.entities.CurrencyPair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CurrencyPairRepository extends JpaRepository<CurrencyPair, Long> {
    CurrencyPair findByName(String name);
    List<CurrencyPair> findCurrencyPairByTargetCurrency(Currency targetCurrency);

    @Query("select cp from CurrencyPair cp where cp.currency = ?1 and cp.targetCurrency = ?2")
    CurrencyPair findBySourceAndTarget(Currency sourceCurrency, Currency targetCurrency);

    @Query("UPDATE CurrencyPair cp SET cp.sourceCurrency = ?1, cp.targetCurrency = ?2 WHERE cp.id = ?3")
    void updateCurrencyPair(Currency sourceCurrency, Currency targetCurrency, Long id);

    @Query("DELETE FROM CurrencyPair cp WHERE cp.id = ?1")
    void deleteCurrencyPair(Long id);

    @Query("insert into CurrencyPair (name, currency, targetCurrency) values (?1, ?2, ?3)")
    void insertCurrencyPair(String name, Currency sourceCurrency, Currency targetCurrency);

}
