package dev.JonKramme.ipuniinfo.controller;

import dev.JonKramme.ipuniinfo.model.UniInfoDTO;
import dev.JonKramme.ipuniinfo.service.UniInfoService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/unicheck")
public class UniInfoController {

    //Dependency Injection - Let Spring handle the creation of the Service for us.
    private final UniInfoService service;

    public UniInfoController(UniInfoService service) {
        this.service = service;
    }

    @GetMapping("/{country}")
    public ResponseEntity<UniInfoDTO[]> requestIpInfo(@PathVariable String country) {
        UniInfoDTO[] uniInfoEntity;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        try {
            uniInfoEntity = service.request(country);
        } catch (Exception e) {
            return new ResponseEntity<>(headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(uniInfoEntity, headers, HttpStatus.OK);

    }
}
