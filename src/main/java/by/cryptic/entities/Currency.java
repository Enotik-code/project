package by.cryptic.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "H_CURRENCY")
public class Currency implements Serializable {

    @Id
    private Integer id;

    @Column(length = 32, unique = true)
    private String name;

    @Column(length = 16)
    private String code;

    @JsonIgnore
    @Column(length = 512)
    private String description;

    private Integer priority;

    @Column(name = "SCALE")
    private Integer scale;

    @Column(name = "IS_FIAT")
    private Boolean isFiat;

    @Column(name = "CONTRACT_ADDRESS")
    private String contractAddress;

    @Column(name = "IS_ACTUAL")
    private boolean isActual;

    @Column(name="BASE_ID")
    private Integer baseId;
}

