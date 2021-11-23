package by.cryptic.entities.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public enum NotificationEngine implements Serializable {
    email("Электронная почта"),
    api("API нотификации"),
    sms("SMS рассылка"),
    telegram("отправка в Telegram чат"),
    google("Google Authenticator");

    private String description;

    @JsonValue
    public Object getJson() {
        Map<String, String> map = new HashMap<>();
        map.put(name(), description);
        return map;
    }

    NotificationEngine(String description) {
        this.description = description;
    }
}

