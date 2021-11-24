package by.cryptic.dto;

import by.cryptic.entities.Currency;
import lombok.Data;

import java.util.List;

@Data
public class CurrencyDto {
    private List<Currency> currencyList;

    public void addCurrency(Currency currency){
        this.currencyList.add(currency);
    }
}
