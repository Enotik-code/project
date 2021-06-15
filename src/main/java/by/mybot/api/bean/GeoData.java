package by.mybot.api.bean;

import lombok.Data;

@Data
public class GeoData {
    private String IataCode;
    private String name;
    private String countryName;
    private String coordinates;
}
