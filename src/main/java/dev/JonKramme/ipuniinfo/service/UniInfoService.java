package dev.JonKramme.ipuniinfo.service;

import com.google.common.net.InetAddresses;
import dev.JonKramme.ipuniinfo.model.IpInfo;
import dev.JonKramme.ipuniinfo.model.UniInfo;
import dev.JonKramme.ipuniinfo.repository.IpInfoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UniInfoService {

    public UniInfo[] request(String country) {
        String url = "http://universities.hipolabs.com/search?country=" + country;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, UniInfo[].class);
    }
}
