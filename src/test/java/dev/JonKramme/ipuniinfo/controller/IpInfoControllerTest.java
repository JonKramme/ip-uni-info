package dev.JonKramme.ipuniinfo.controller;

import dev.JonKramme.ipuniinfo.model.IpInfoDTO;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class IpInfoControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    @Order(1)
    void request_IpInfo_with_valid_ip() {
        String IP = "80.233.249.21";
        ResponseEntity<IpInfoDTO> entity = restTemplate.getForEntity("/ipcheck/"+IP,IpInfoDTO.class);

        assertEquals(entity.getStatusCode(), HttpStatus.OK);
        assertEquals(MediaType.APPLICATION_JSON,entity.getHeaders().getContentType());
    }

    @Test
    @Order(2)
    void request_IpInfo_with_invalid_ip_1() {
        String IP = "80.233a249.21";
        ResponseEntity<IpInfoDTO> entity = restTemplate.getForEntity("/ipcheck/"+IP,IpInfoDTO.class);
        assertEquals(entity.getStatusCode(), HttpStatus.BAD_REQUEST);
        assertEquals(MediaType.APPLICATION_JSON,entity.getHeaders().getContentType());
    }

    @Test
    @Order(3)
    void request_IpInfo_with_invalid_ip_2() {
        String IP = "080.233.249.021";
        ResponseEntity<IpInfoDTO> entity = restTemplate.getForEntity("/ipcheck/"+IP,IpInfoDTO.class);
        assertEquals(entity.getStatusCode(), HttpStatus.BAD_REQUEST);
        assertEquals(MediaType.APPLICATION_JSON,entity.getHeaders().getContentType());
    }
}