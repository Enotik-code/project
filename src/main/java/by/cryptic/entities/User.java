package by.cryptic.entities;

import by.cryptic.entities.enums.NotificationEngine;
import by.cryptic.entities.enums.UserState;
import by.cryptic.entities.enums.UserStatus;
import by.cryptic.entities.enums.UserType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@ToString(of = "id")
@Entity
@Table(name = "H_USER")
@Cacheable
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "h_user_id_seq")
    @SequenceGenerator(
            name = "h_user_id_seq",
            sequenceName = "h_user_id_seq",
            allocationSize = 10,
            initialValue = 1000000
    )
    @Id
    private Long id;

    @Column(length = 64)
    private String login;

    @Column(length = 64)
    private String name;

    @Column(length = 64)
    private String salt;

    @Column(name = "IS_ACTUAL")
    private Boolean isActual;

    @Column(name = "IS_TESTED")
    private Boolean isTested;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "PHONE_NUMBER", length = 32)
    private String phoneNumber;

    @Column(name = "IS_PHONE_NUMBER_VERIFIED")
    private Boolean isPhoneNumberVerified;

    @Column(length = 128)
    private String email;

    @Column(name = "IS_EMAIL_VERIFIED")
    private Boolean isEmailVerified;

    @Column(name = "IS_DFA")
    private Boolean isDoubleFactorAuthentication;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private UserType userType;

    @Enumerated(EnumType.STRING)
    private UserState state;

    @ManyToOne
    @JoinColumn(name = "referer_id")
    private User referer;

    @Column(name = "PREFERABLE_NOTIFICATION")
    @Enumerated(EnumType.STRING)
    private NotificationEngine preferableNotification;

    @Transient
    private List<String> roles;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private UserStatus userStatus;

    @Column(name = "SOURCE")
    private String source;
}

