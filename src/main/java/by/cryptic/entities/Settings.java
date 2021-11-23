package by.cryptic.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Table(name = "H_SETTINGS")
public class Settings {

    @Id
    private Long id;

    @Column(name = "key")
    private String key;

    @Column(name = "value")
    private String value;

    public void setValue(String value) {
        if (this.value == null) {
            if (value == null) {
                return;
            }
        } else {
            if (this.value.equals(value)) {
                return;
            }
        }
        this.value = value;
        setModifyDate(new Date());
    }

    @Column(name = "MODIFY_DATE")
    private Date modifyDate;

    @Column(name = "ERROR_COUNT")
    private Integer errorCount;

    @Column(name = "ERROR_MSG", length = 1000)
    private String errorMessage;

    public void setErrorMessage(String error) {
        if (error == null) {
            errorMessage = null;
            return;
        }
        if (error.length() > 996) {
            error = error.substring(0, 996) + "...";
        }
        errorMessage = error;
    }

    public String getErrorMessage() {
        return errorMessage == null ? "" : errorMessage;
    }
}

