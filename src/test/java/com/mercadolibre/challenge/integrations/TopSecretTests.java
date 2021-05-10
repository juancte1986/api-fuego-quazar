package com.mercadolibre.challenge.integrations;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class TopSecretTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void TopSecretOk() throws Exception {
		final String request = "{\"satellites\":[{\"name\":\"kenobi\",\"distance\":100,\"message\":[\"este\",\"\",\"\",\"mensaje\",\"\"]},"
				+ "{\"name\":\"skywalker\",\"distance\":115.5,\"message\":[\"\",\"es\",\"\",\"\",\"secreto\"]},"
				+ "{\"name\":\"sato\",\"distance\":142.7,\"message\":[\"este\",\"\",\"un\",\"\",\"\"]}]}";
		mockMvc.perform(post("/topsecret")
		  .contentType(MediaType.APPLICATION_JSON).content(request))
		  .andExpect(status().isOk());
	}
	
	@Test
	public void TopSecretBadRequest() throws Exception {
		final String request = "{\"satellites\":[{\"name\":\"kenobi\",\"distance\":100,\"message\":[\"este\",\"\",\"\",\"mensaje\",\"\"]},"
				+ "{\"name\":\"skywalker\",\"distance\":115.5,\"message\":[\"\",\"es\",\"\",\"\",\"secreto\"]},"
				+ "{\"name\":\"sato\",\"distance\":142.7,\"message\":[\"este\",\"\",\"un\",\"\",\"\",\"\"]}]}";
		mockMvc.perform(post("/topsecret")
		  .contentType(MediaType.APPLICATION_JSON).content(request))
		  .andExpect(status().isBadRequest());
	}
}
