package by.cryptic.entities.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public enum UserType implements Serializable {

    regular("Стандартный пользователь в системе, присваивается автоматически пользователю при регистрации в системе как физическое лицо"),
    regularVip("Пользователь физическое лицо VIP клиент, физическое лицо из regular в regularVip переводит вручную администратор системы"),
    entity("Стандартный пользователь в системе, присваивается автоматически пользователю при регистрации в системе как юридическое лицо"),
    entityVip("Пользователь юридическое лицо VIP клиент, юридическое лицо из entity в entityVip переводит вручную администратор системы"),
    trader("Пользователь сотрудник биржи (физическое лицо), который совершает финансовые операции от имени биржи" +
            " (создание ордеров, ввод и вывод средств), из regular в trader пользователя переводит вручную администратор системы"),
    broker("Пользователь сотрудник биржи (физическое лицо), который совершает финансовые операции от имени биржи" +
            " (аналогично trader, только без права ввода/вывода средств"),
    hermes("Система"),
    cold("Холодный кошелёк");

    private String description;

    @JsonValue
    public Object getJson() {
        Map<String, String> map = new HashMap<>();
        map.put(name(), description);
        return map;
    }

    UserType(String description) {
        this.description = description;
    }
}

