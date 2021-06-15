package by.mybot.api.bean;

import lombok.Data;

@Data
public class GeoData {
    private String iataCode;
    private String name;
    private String countryName;
    private String coordinates;
}
