package dev.JonKramme.ipuniinfo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;

// Tests https://www.baeldung.com/spring-data-mongodb-connection
// 		 https://www.baeldung.com/spring-rest-docs
@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IpUniInfoApplicationTests {
    @Autowired
    TestRestTemplate restTemplate;
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp(WebApplicationContext webApplicationContext, RestDocumentationContextProvider restDocumentation) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .apply(documentationConfiguration(restDocumentation))
                .alwaysDo(document("{method-name}",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint())))
                .build();
    }

    // TODO:
    // handle MongoSocketOpenException
    // use H2 for Integration tests?
    void check_db_connection() {
    }
    @Test
    void request_from_invalid_binding_1() {
        ResponseEntity<String> entity = restTemplate.getForEntity("/", String.class);

        assertNotNull(entity);
        assertEquals(entity.getStatusCode(), HttpStatus.NOT_FOUND);
        assertEquals(MediaType.APPLICATION_JSON, entity.getHeaders().getContentType());
    }

    @Test
    void request_from_invalid_binding_2() {
        ResponseEntity<String> entity = restTemplate.getForEntity("/ipcheck/80.80.80.80/3425", String.class);

        assertNotNull(entity);
        assertEquals(entity.getStatusCode(), HttpStatus.NOT_FOUND);
        assertEquals(MediaType.APPLICATION_JSON, entity.getHeaders().getContentType());
    }

    @Test
    void request_from_invalid_binding_3() {
        ResponseEntity<String> entity = restTemplate.getForEntity("/unicheck/Latvia/extra", String.class);

        assertNotNull(entity);
        assertEquals(entity.getStatusCode(), HttpStatus.NOT_FOUND);
        assertEquals(MediaType.APPLICATION_JSON, entity.getHeaders().getContentType());
    }


}
