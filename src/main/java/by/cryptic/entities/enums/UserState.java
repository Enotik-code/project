package by.cryptic.entities.enums;


import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public enum UserState implements Serializable {

    notVerified("Не верифицирован"),
    verified("Успешно верифицирован"),
    inProgress("В процессе верификации - рассматривается оператором KYC"),
    pending("Ожидание дополнительной информации от пользователя для завершения верификации"),
    testing("Обязательное тестирование для граждан Республики Беларусь"),
    failed("Верификация провалена");

    private String description;

    @JsonValue
    public Object getJson() {
        Map<String, String> map = new HashMap<>();
        map.put(name(), description);
        return map;
    }

    UserState(String description) {
        this.description = description;
    }
}

