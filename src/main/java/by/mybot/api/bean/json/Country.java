package by.mybot.api.bean.json;

import by.mybot.api.bean.additional.NameTranslations;
import lombok.Data;

@Data
public class Country {
    private String code;
    private String name;
    private String currency;
    private NameTranslations nameTranslations;

}
