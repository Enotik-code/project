package by.cryptic.entities.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public enum UserStatus implements Serializable {

    active("активен"),
    temporarilyBlocked("временно заблокирован"),
    partlyBlocked("частично заблокирован"),
    blocked("заблокирован");

    private String description;

    @JsonValue
    public Object getJson() {
        Map<String, String> map = new HashMap<>();
        map.put(name(), description);
        return map;
    }

    UserStatus(String description) {
        this.description = description;
    }
}
