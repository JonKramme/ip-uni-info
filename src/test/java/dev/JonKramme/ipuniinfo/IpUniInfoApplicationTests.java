package dev.JonKramme.ipuniinfo;

import org.bson.Document;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

import static org.junit.jupiter.api.Assertions.*;
// Tests https://www.baeldung.com/spring-data-mongodb-connection
@SpringBootTest
class IpUniInfoApplicationTests {
	/*@Test


	public void givenConnectionUri_whenAlsoIncludingIndividualParameters_thenInvalidConfig() {
		System.setProperty(
				"spring.data.mongodb.uri",
				"mongodb://" + USER + ":" + PASS + "@" + HOST + ":" + PORT + "/" + DB
		);

		SpringApplicationBuilder app = new SpringApplicationBuilder(IpUniInfoApplication.class)
				.properties(
						"spring.data.mongodb.host=" + HOST,
						"spring.data.mongodb.port=" + PORT,
						"spring.data.mongodb.username=" + USER,
						"spring.data.mongodb.password=" + PASS
				);

		BeanCreationException e = assertThrows(BeanCreationException.class, () -> {
			app.run();
		});
	}

	 */
}
