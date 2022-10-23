package dev.JonKramme.ipuniinfo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
// Tests https://www.baeldung.com/spring-data-mongodb-connection
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IpUniInfoApplicationTests {

	@Autowired
	TestRestTemplate restTemplate;
	@Test
	public void DbConnectionTest() {
	//TODO: Write more Tests - Generate Documentation using Spring REST Docs- Containerize as Docker -
	}
	@Test
	void request_from_invalid_binding_1() {
		ResponseEntity<String> entity = restTemplate.getForEntity("/",String.class);

		assertNotNull(entity);
		assertEquals(entity.getStatusCode(), HttpStatus.NOT_FOUND);
		assertEquals(MediaType.APPLICATION_JSON,entity.getHeaders().getContentType());
	}
	@Test
	void request_from_invalid_binding_2() {
		ResponseEntity<String> entity = restTemplate.getForEntity("/ipcheck/80.80.80.80/3425",String.class);

		assertNotNull(entity);
		assertEquals(entity.getStatusCode(), HttpStatus.NOT_FOUND);
		assertEquals(MediaType.APPLICATION_JSON,entity.getHeaders().getContentType());
	}
	@Test
	void request_from_invalid_binding_3() {
		ResponseEntity<String> entity = restTemplate.getForEntity("/unicheck/Latvia/extra",String.class);

		assertNotNull(entity);
		assertEquals(entity.getStatusCode(), HttpStatus.NOT_FOUND);
		assertEquals(MediaType.APPLICATION_JSON,entity.getHeaders().getContentType());
	}


}
