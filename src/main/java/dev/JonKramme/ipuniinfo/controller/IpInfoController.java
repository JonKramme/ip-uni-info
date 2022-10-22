package dev.JonKramme.ipuniinfo.controller;

import dev.JonKramme.ipuniinfo.model.IpInfoDTO;
import dev.JonKramme.ipuniinfo.service.IpInfoService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ipcheck")
public class IpInfoController {


    //Dependency Injection - Let Spring handle the creation of the Service for us.
    private final IpInfoService service;
    public IpInfoController(IpInfoService service) {
        this.service = service;
    }

    @GetMapping("/{ipv4Address}")
    public ResponseEntity<IpInfoDTO> requestIpInfo(@PathVariable String ipv4Address) {
        IpInfoDTO ipInfoEntity;
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
