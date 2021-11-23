package by.cryptic.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Setter
@Getter
@Entity
@Table(name = "H_CURRENCY_PAIR")
public class CurrencyPair implements Serializable {

    @Id
    private Integer id;

    @Column(length = 32)
    private String name;

    private Integer priority;

    @ManyToOne
    @JoinColumn(name = "CURRENCY_ID")
    private Currency currency;

    @ManyToOne
    @JoinColumn(name = "TARGET_CURRENCY_ID")
    private Currency targetCurrency;

    @Column(name = "FEE", precision=38, scale=23)
    private BigDecimal fee;

    @Column(name = "IS_ACTUAL")
    private boolean isActual;

    @Column(name = "IS_DEPOSIT_AVAILABLE")
    private boolean isDepositAvailable;

    @Column(name = "IS_WITHDRAWAL_AVAILABLE")
    private boolean isWithdrawalAvailable;

    @Column(name = "IS_ACTUAL_CHANGE")
    private boolean isActualChange;

    @Column(name = "is_new_core")
    private boolean isNewCore;

    @Column(name = "price_scale")
    private int priceScale;

}
