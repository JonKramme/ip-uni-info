package dev.JonKramme.ipuniinfo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

// Record for saving JSON Data from the API
//"@JsonProperty" required for state-province due to the hyphen.
//First two Parameters are only marked "@JsonProperty" to conserve original data order.
public record UniInfo ( @JsonProperty("domains") List<String> domains,  @JsonProperty("country") String country, @JsonProperty("state-province")String stateProvince, List<String> web_pages, String name, String alpha_two_code) {
}
