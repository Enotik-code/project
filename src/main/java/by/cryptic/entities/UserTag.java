package by.cryptic.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "H_USER_TAGS")
@SequenceGenerator(name = "H_USER_TAGS_SEQ",
        sequenceName = "H_USER_TAGS_SEQ",
        allocationSize = 1)
public class UserTag {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "H_USER_TAGS_SEQ")
    private Long id;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "TAG_ID")
    private Long tagId;

    @Column(name = "VALUE")
    private String value;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "CREATE_USER_ID")
    private Long creatUserId;

    @Column(name = "IS_ACTUAL")
    private Boolean isActual;

    @Column(name = "CREATE_USER_ROLE_ID")
    private Long role;

}

