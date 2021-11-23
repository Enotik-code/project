package by.cryptic.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "H_USER_ROLE")
public class UserRole implements Serializable {

    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="h_user_role_seq")
    @SequenceGenerator(
            name="h_user_role_seq",
            sequenceName="h_user_role_seq",
            allocationSize = 10,
            initialValue = 1000000
    )
    @Id
    private Long id;

    @Column(name = "USER_ID")
    private Long userId;

    private String role;
}

