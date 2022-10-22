package dev.JonKramme.ipuniinfo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;
import java.util.Objects;
@Document("IpInfoLog")
public class IpInfoDatabaseDTO {
    @MongoId
    private String id;
    private String accessDate;
    private String ip;
    private String city;
    private String region;
    private String country;
    private String loc;
    private String org;
    private String postal;
    private String timezone;
    private String readme;

    public IpInfoDatabaseDTO() {
        this.accessDate = LocalDateTime.now().toString();
    }

    public IpInfoDatabaseDTO(IpInfoDTO IpInfoEntity) {
        super();
        this.ip = IpInfoEntity.ip();
        this.city = IpInfoEntity.city();
        this.region = IpInfoEntity.region();
        this.country = IpInfoEntity.country();
        this.loc = IpInfoEntity.loc();
        this.org = IpInfoEntity.org();
        this.postal = IpInfoEntity.postal();
        this.timezone = IpInfoEntity.timezone();
        this.readme = IpInfoEntity.readme();
    }

    public String getId() {
        return id;
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
        IpInfoDatabaseDTO that = (IpInfoDatabaseDTO) o;
        return id.equals(that.id) && accessDate.equals(that.accessDate) && ip.equals(that.ip) && city.equals(that.city) && region.equals(that.region) && country.equals(that.country) && loc.equals(that.loc) && org.equals(that.org) && postal.equals(that.postal) && timezone.equals(that.timezone) && readme.equals(that.readme);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accessDate, ip, city, region, country, loc, org, postal, timezone, readme);
    }

    @Override
    public String toString() {
        return "IpInfoDatabaseDTO{" +
                "id='" + id + '\'' +
                ", accessDate='" + accessDate + '\'' +
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
