package dev.JonKramme.ipuniinfo.model;

// Record to possibly save the JSON Information given by the IP API at https://ipinfo.io/{ip}/geo



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Objects;
import java.time.LocalDateTime;
@Document("ipInfo")
public class IpInfo {
    String accessDate;
    String ip;
    String city;
    String region;
    String country;
    String loc;
    String org;
    String postal;
    String timezone;
    String readme;

    public IpInfo() {
        this.accessDate = LocalDateTime.now().toString();
    }

    public IpInfo( String ip, String city, String region, String country, String loc, String org, String postal, String timezone, String readme) {
        super();
        this.ip = ip;
        this.city = city;
        this.region = region;
        this.country = country;
        this.loc = loc;
        this.org = org;
        this.postal = postal;
        this.timezone = timezone;
        this.readme = readme;
    }

    public String getAccessDate() {
        return accessDate;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getReadme() {
        return readme;
    }

    public void setReadme(String readme) {
        this.readme = readme;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IpInfo ipInfo = (IpInfo) o;
        return accessDate.equals(ipInfo.accessDate) && ip.equals(ipInfo.ip) && city.equals(ipInfo.city) && region.equals(ipInfo.region) && country.equals(ipInfo.country) && loc.equals(ipInfo.loc) && org.equals(ipInfo.org) && postal.equals(ipInfo.postal) && timezone.equals(ipInfo.timezone) && readme.equals(ipInfo.readme);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessDate, ip, city, region, country, loc, org, postal, timezone, readme);
    }

    @Override
    public String toString() {
        return "IpInfo{" +
                "accessDate='" + accessDate + '\'' +
                ", ip='" + ip + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", country='" + country + '\'' +
                ", loc='" + loc + '\'' +
                ", org='" + org + '\'' +
                ", postal='" + postal + '\'' +
                ", timezone='" + timezone + '\'' +
                ", readme='" + readme + '\'' +
                '}';
    }
}
