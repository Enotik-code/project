package by.cryptic.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "server")
@Validated
public class AppProperties {
    @NotEmpty
    private String ethApi;

    @NotEmpty
    private String btcApi;
}
