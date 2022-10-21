package dev.JonKramme.ipuniinfo.controller;

import com.sun.net.httpserver.HttpContext;
import dev.JonKramme.ipuniinfo.model.IpInfo;
import dev.JonKramme.ipuniinfo.repository.IpInfoRepository;
import dev.JonKramme.ipuniinfo.service.IpInfoService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@RestController
@ResponseBody
@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class IpInfoController {


    //Dependency Injection - Let Spring handle the creation of the Service for us.
    private final IpInfoService service;
    public IpInfoController(IpInfoService service) {
        this.service = service;
    }

    @RequestMapping("/ipcheck/{ipv4Address}")
    @ResponseBody
    public ResponseEntity<IpInfo> requestIpInfo(@PathVariable String ipv4Address) {
        IpInfo ipInfoEntity = null;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        try {
            ipInfoEntity = service.request(ipv4Address);
        } catch (IllegalArgumentException e){
            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            return new ResponseEntity<>(headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(ipInfoEntity, headers, HttpStatus.OK);
    }

}
