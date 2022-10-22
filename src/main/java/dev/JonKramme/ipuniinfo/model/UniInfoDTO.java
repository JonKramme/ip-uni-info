package dev.JonKramme.ipuniinfo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

// Record for saving JSON Data from the API
//"@JsonProperty" required for state-province due to the hyphen.
public record UniInfoDTO(@JsonProperty("domains") List<String> domains,
                         @JsonProperty("country") String country,
                         @JsonProperty("state-province") String stateProvince,
                         @JsonProperty("web_pages")List<String> web_pages,
                         @JsonProperty("name")String name,
                         @JsonProperty("alpha_two_code")String alpha_two_code) {


}
