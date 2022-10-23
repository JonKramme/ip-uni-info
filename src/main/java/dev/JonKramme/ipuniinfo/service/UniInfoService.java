package dev.JonKramme.ipuniinfo.service;

import dev.JonKramme.ipuniinfo.model.UniInfoDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UniInfoService {

    public UniInfoDTO[] request(String country) throws Exception {
        String url = "http://universities.hipolabs.com/search?country=" + country;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, UniInfoDTO[].class);
    }
}
