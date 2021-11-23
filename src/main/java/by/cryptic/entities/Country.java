package by.cryptic.entities;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import java.io.Serializable;

/**
 * Entity represents countries.
 * Columns example:
 *   code_alpha_2 - US
 *   code_alpha_3 - USA
 *   code_numeric - 840
 *   sccheck_name - United State of America
 *   is_offshore  - false
 *   is_crypto    - false
 *   is_aml       - false
 *   enabled      - true
 */
@Data
@Entity
@Table(name = "H_COUNTRY")
public class Country implements Serializable {

    @Id
    @Column(name = "code_alpha_2", length = 2, unique = true)
    private String codeAlpha2;

    @Column(name = "code_alpha_3", length = 3, unique = true)
    private String codeAlpha3;

    @Column(name = "code_numeric", unique = true)
    private Short numericCode;

    @Column(name = "sccheck_name")
    private String scCheckName;

    @Column(name = "is_offshore")
    private Boolean isOffshore;

    @Column(name = "is_crypto")
    private Boolean isCrypto;

    @Column(name = "is_aml")
    private Boolean isAml;

    @Column(name = "enabled")
    private Boolean enabled;

    @Column(name = "is_eu", nullable = false)
    private boolean isEu;

    @Column(name = "is_constant", nullable = false)
    private boolean isConstant;

    @Column(name = "id_card", nullable = false)
    private Boolean idCard;

    @Column(name = "id_passport", nullable = false)
    private Boolean idPassport;
}

