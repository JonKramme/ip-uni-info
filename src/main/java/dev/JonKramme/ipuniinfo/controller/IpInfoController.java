package dev.JonKramme.ipuniinfo.controller;

import dev.JonKramme.ipuniinfo.model.IpInfo;
import dev.JonKramme.ipuniinfo.repository.IpInfoRepository;
import dev.JonKramme.ipuniinfo.service.IpInfoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/ipcheck")
public class IpInfoController {

    //Dependency Injection - Let Spring handle this for us.
    private final IpInfoService service;
    public IpInfoController(IpInfoService service) {
        this.service = service;
    }

    @GetMapping("/{ipv4Address}")
    public IpInfo requestIpInfo(@PathVariable String ipv4Address) {
        return service.request(ipv4Address);
    }

}
