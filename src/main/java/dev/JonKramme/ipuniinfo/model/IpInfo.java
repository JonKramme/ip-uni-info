package dev.JonKramme.ipuniinfo.model;

// Record to possibly save the JSON Information given by the IP API at https://ipinfo.io/{ip}/geo
public record IpInfo(String ip, String city, String region, String country, String loc, String org, String postal, String timezone, String readme) {
}
