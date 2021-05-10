package com.mercadolibre.challenge.units;

import org.springframework.boot.test.context.SpringBootTest;

import com.mercadolibre.challenge.exceptions.MessageNotDeterminedException;
import com.mercadolibre.challenge.utils.MessageProcessorUtils;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

@SpringBootTest
public class MessageProcessorUtilsTests {
	
	private static final String MESSAGE_OK = "este es un mensaje secreto";
	
	@Test
	public void processMessageOk() throws Exception {
		String[][] messages = { { "este", "", "", "mensaje", "" }, { "", "es", "", "", "secreto" }, { "este", "", "un", "", "" } };
		String message = MessageProcessorUtils.processMessage(messages);
		assertThat(message).isEqualTo(MESSAGE_OK);
		
	}
	
	@Test(expected = MessageNotDeterminedException.class)
	public void processMessageError() throws Exception {
		String[][] messages = { { "este", "", "", "mensaje", ""}, { "", "es", "", "", "secreto" }, { "este", "", "un", "", "", "" } };
		String message = MessageProcessorUtils.processMessage(messages);
		assertThat(message).isEqualTo(MESSAGE_OK);;
	}
}
