package by.cryptic.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.*;

@Setter
@Getter
@Builder
@ToString(of = {"address", "balance", "sealed", "description", "error"})
@Table(name = "H_CRYPTO_WALLET")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Wallet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ADDRESS")
    private String address;

    @ManyToOne
    @JoinColumn(name = "CURRENCY_ID")
    private Currency currency;

    @Column(name = "BALANCE", precision=38, scale=23)
    private BigDecimal balance;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "UPDATE_DATE")
    private Date updateDate;

    @Column(name = "IS_SEALED")
    private boolean sealed;

    @Column(name = "SIGN")
    private String sign;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "ERROR")
    private String error;

}

