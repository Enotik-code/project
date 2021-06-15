package by.mybot.api.bean.json;

import by.mybot.api.bean.additional.Coordinates;
import by.mybot.api.bean.additional.NameTranslations;
import lombok.Data;

@Data
public class Airport {
    private String code;
    private String name;
    private String iata_type;
    private boolean flightable;
    private Coordinates coordinates;
    private String timeZone;
    private NameTranslations nameTranslations;
    private String countryCode;
    private String cityCode;
}
