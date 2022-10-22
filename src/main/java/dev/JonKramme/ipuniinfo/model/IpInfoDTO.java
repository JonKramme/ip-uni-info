package dev.JonKramme.ipuniinfo.model;

// Class to save and return the JSON Information given by the IP API at https://ipinfo.io/{ip}/geo

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.time.LocalDateTime;
public record IpInfoDTO(@JsonProperty("ip")String ip,
                        @JsonProperty("city")String city,
                        @JsonProperty("region")String region,
                        @JsonProperty("country")String country,
                        @JsonProperty("loc")String loc,
                        @JsonProperty("org")String org,
                        @JsonProperty("postal")String postal,
                        @JsonProperty("timezone")String timezone,
                        @JsonProperty("readme")String readme) {
}
