package by.mybot.api.bean.json;

import by.mybot.api.bean.additional.Coordinates;
import by.mybot.api.bean.additional.NameTranslations;
import lombok.Data;

@Data
public class City {
    private String code;
    private String name;
    private Coordinates coordinates;
    private NameTranslations nameTranslations;
    private String countryCode;
}
