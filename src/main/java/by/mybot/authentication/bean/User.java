package by.mybot.authentication.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Builder
@Table(name = "user_account")
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "password", length = 60)
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "gender")
    private String gender;
    @Column(name = "address")
    private String address;
    @Column(name = "patronymic")
    private String patronymic;
    @Column(name = "activation_code")
    private String activationCode;
    @Column(name = "is_blocked")
    private boolean isBlocked;
    @Column(name = "count_of_wrong_attempts")
    private int countOfWrongAttempts = 0;
    @Column(name = "active")
    private Boolean active;
    @Column(name = "date_of_birthday")
    private Date dateOfBirthday;
    @Column(name = "date_of_created")
    private Date dateOfCreated;
    @Column(name = "date_of_modified")
    private Date dateOfModified;
    @Column(name = "account_balance")
    private BigDecimal accountBalance;
    @Column(name = "number_of_points")
    private BigDecimal numberOfPoints;

    private String roles;
}

