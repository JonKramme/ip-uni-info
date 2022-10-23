package dev.JonKramme.ipuniinfo.controller;

import dev.JonKramme.ipuniinfo.model.IpInfoDTO;
import dev.JonKramme.ipuniinfo.model.UniInfoDTO;
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
import org.springframework.web.client.RestClientException;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UniInfoControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    @Order(1)
    void request_UniInfo_with_valid_country() {
        String country = "Latvia";
        ResponseEntity<UniInfoDTO[]> entity = restTemplate.getForEntity("/unicheck/"+country,UniInfoDTO[].class);

        assertEquals(entity.getStatusCode(), HttpStatus.OK);
        assertEquals(MediaType.APPLICATION_JSON,entity.getHeaders().getContentType());
    }

    @Test
    @Order(2)
    void request_UniInfo_with_valid_country_with_spacing() {
        String country = "United States";
        ResponseEntity<UniInfoDTO[]> entity = restTemplate.getForEntity("/unicheck/"+country,UniInfoDTO[].class);

        assertEquals(entity.getStatusCode(), HttpStatus.OK);
        assertEquals(MediaType.APPLICATION_JSON,entity.getHeaders().getContentType());
    }

    @Test
    @Order(3)
    void request_UniInfo_with_invalid_country() {
        String country = "@@@4536M&$%$§&MfDE";
        ResponseEntity<UniInfoDTO[]> entity = restTemplate.getForEntity("/unicheck/"+country,UniInfoDTO[].class);

        assertNotNull(entity);
        assertEquals(entity.getStatusCode(), HttpStatus.OK);
        assertEquals(MediaType.APPLICATION_JSON,entity.getHeaders().getContentType());
        assertEquals(0, Objects.requireNonNull(entity.getBody()).length);
    }
}