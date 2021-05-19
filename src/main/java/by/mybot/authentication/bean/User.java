package by.mybot.authentication.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Entity
@Builder
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    private String gender;
    private String address;
    private String patronymic;

    private String activationCode;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "date_of_birthday")
    private Date dateOfBirthday;

    @Column(name = "date_of_created")
    private Date dateOfCreated;

    @Column(name = "date_of_modified")
    private Date dateOfModified;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public String getAllRoles() {
        return roles.stream()
                .map(role -> role.getRoleName().name())
                .collect(Collectors.joining(", ", "{", "}"));
    }
}

