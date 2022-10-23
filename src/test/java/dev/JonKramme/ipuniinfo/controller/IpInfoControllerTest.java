package dev.JonKramme.ipuniinfo.controller;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class IpInfoControllerTest {
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

    @Test
    @Order(1)
    void request_IpInfo_with_valid_ip() throws Exception {
        String ip = "80.233.249.21";
        this.mockMvc.perform(get("/ipcheck/{ip}", ip))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andDo(document("IpInfo-with-valid-ip",
                        pathParameters(
                                parameterWithName("ip").description("The IP to request information about.")
                        )));
        /*
        	// old Junit5 only tests -> now using MockMvc
			ResponseEntity<IpInfoDTO> entity = restTemplate.getForEntity("/ipcheck/"+IP,IpInfoDTO.class);
			assertEquals(entity.getStatusCode(), HttpStatus.OK);
			assertEquals(MediaType.APPLICATION_JSON,entity.getHeaders().getContentType());
         */
    }

    @Test
    @Order(2)
    void request_IpInfo_with_invalid_ip_1() throws Exception {
        String ip = "80.233a249.21";
        this.mockMvc.perform(get("/ipcheck/{ip}", ip))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andDo(document("IpInfo-with-invalid-ip",
                        pathParameters(
                                parameterWithName("ip").description("The IP to request information about.")
                        )));
    }

    @Test
    @Order(3)
    void request_IpInfo_with_invalid_ip_2() throws Exception {
        String ip = "080.233.249.021";
        this.mockMvc.perform(get("/ipcheck/{ip}", ip))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andDo(document("IpInfo-with-invalid-ip-leading-zeros",
                        pathParameters(
                                parameterWithName("ip").description("The IP to request information about.")
                        )));
    }
}