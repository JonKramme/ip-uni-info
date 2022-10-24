package dev.JonKramme.ipuniinfo.controller;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
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
class UniInfoControllerTest {
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
    void request_UniInfo_with_valid_country() throws Exception {
        String country = "Latvia";
        this.mockMvc.perform(get("/unicheck/{country}", country))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andDo(document("UniInfo-with-valid-country",
                        pathParameters(
                                parameterWithName("country").description("The name of a country to request a list of universities from.")
                        )));
    }

    @Test
    @Order(2)
    void request_UniInfo_with_valid_country_with_spacing() throws Exception {
        String country = "United States";
        this.mockMvc.perform(get("/unicheck/{country}", country))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andDo(document("UniInfo-with-valid-country-spacing",
                        pathParameters(
                                parameterWithName("country").description("The name of a country to request a list of universities from.")
                        )));
    }

    @Test
    @Order(3)
    void request_UniInfo_with_invalid_country() throws Exception {
        String country = "@@@4536M&$%$§&MfDE";
        this.mockMvc.perform(get("/unicheck/{country}", country))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json("[]"))
                .andDo(document("UniInfo-with-invalid-country",
                        pathParameters(
                                parameterWithName("country").description("The name of a country to request a list of universities from.")
                        )));
    }
}