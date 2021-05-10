package com.mercadolibre.challenge.integrations;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.mercadolibre.challenge.domains.Point;
import com.mercadolibre.challenge.dto.TopSecretResponseDTO;
import com.mercadolibre.challenge.services.TopSecretService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class TopSecretSplitTests {
	
	private static final String USERNAME_HEADER = "test";

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TopSecretService service;
	
	@Test
	public void TopSecretSplitSaveOK() throws Exception {
		final String request = "{\"distance\":100,\"message\":[\"este\",\"\",\"\",\"mensaje\",\"\"]}";
		mockMvc.perform(post("/topsecret/topsecret_split/skywalker")
		  .contentType(MediaType.APPLICATION_JSON).content(request))
		  .andExpect(status().isCreated());
	}
	
	@Test
	public void TopSecretSplitInformatioOK() throws Exception {
		when(service.getTopSecretSplit(any())).thenReturn(getTopSecretResponseMock());
		mockMvc.perform(get("/topsecret/topsecret_split")
		  .contentType(MediaType.APPLICATION_JSON)
		  .header("username", USERNAME_HEADER))
		  .andExpect(status().isOk());
	}
	
	@Test
	public void TopSecretSplitInformationBadRequest() throws Exception {
		mockMvc.perform(post("/topsecret/topsecret_split/skywalker")
		  .contentType(MediaType.APPLICATION_JSON)
		  .header("username", USERNAME_HEADER))
		  .andExpect(status().isBadRequest());
	}
	
	
	private TopSecretResponseDTO getTopSecretResponseMock() {
		return TopSecretResponseDTO.builder()
				.message("Este es un mensaje secreto")
				.position(Point.builder().x(100.0).y(200.0).build())
				.build();
	}
}
