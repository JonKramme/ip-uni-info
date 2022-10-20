package dev.JonKramme.ipuniinfo.controller;

import dev.JonKramme.ipuniinfo.model.IpInfo;
import dev.JonKramme.ipuniinfo.repository.IpInfoRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ipcheck")
public class IpInfoController {

    @GetMapping("/{Ipv4Address}")
    public String requestIpInfo(@PathVariable String Ipv4Address,IpInfoRepository repo){
        return Ipv4Address;
    }
}
