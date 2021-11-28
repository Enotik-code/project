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
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(of = {"cardNumber", "balance", "description", "error"})
@Table(name = "H_CARD")
@Entity
public class Card implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CARD_NUMBER")
    private String cardNumber;

    @Column(name = "USER_ID")
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "CURRENCY_ID")
    private Currency currency;

    @Column(name = "BALANCE", precision=38, scale=23)
    private BigDecimal balance;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "UPDATE_DATE")
    private Date updateDate;

    @Column(name = "CVVCODE")
    private Integer cvvCode;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "CARD_DATE")
    private Date cardDate;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "ERROR")
    private String error;
}

