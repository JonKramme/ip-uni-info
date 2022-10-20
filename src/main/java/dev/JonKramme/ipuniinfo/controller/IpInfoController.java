package dev.JonKramme.ipuniinfo.controller;

import dev.JonKramme.ipuniinfo.model.IpInfo;
import dev.JonKramme.ipuniinfo.repository.IpInfoRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/ipcheck")
public class IpInfoController {

    @GetMapping("/{Ipv4Address}")
    public String requestIpInfo(@PathVariable String Ipv4Address,IpInfoRepository repo){
        //Testing API Call (assuming ip is valid)
        String url = "https://ipinfo.io/"+Ipv4Address+"/geo";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url,String.class);

        return result;
    }
}
