package by.mybot.payment.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Builder
@Table(name = "paymnet")
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long paymentId;

    @Column(name = "operation_id")
    private Long operationId;

    @Column(name = "successfully")
    private boolean successfully;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "user_id")
    private Long userId;

}
