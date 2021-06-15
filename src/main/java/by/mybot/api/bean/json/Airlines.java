package by.mybot.api.bean.json;

import by.mybot.api.bean.additional.NameTranslations;
import lombok.Data;

@Data
public class Airlines {
    private String name;
    private String code;
    private NameTranslations nameTranslations;
}
