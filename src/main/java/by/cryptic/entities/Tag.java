package by.cryptic.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@Entity
@Table(name = "H_TAGS")
@SequenceGenerator(name = "H_TAGS_SEQ",
        sequenceName = "H_TAGS_SEQ",
        allocationSize = 1)
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "H_TAGS_SEQ")
    private Long id;

    @Column(name = "CODE")
    private String code;

    @Column(name = "NAME")
    @NotNull
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "ROLE_ID")
    private Long roleId;

    @Column(name = "TYPE")
    private Integer type;
}
