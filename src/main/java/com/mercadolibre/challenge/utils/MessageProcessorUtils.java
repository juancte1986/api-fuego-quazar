package com.mercadolibre.challenge.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.mercadolibre.challenge.exceptions.MessageNotDeterminedException;

public final class MessageProcessorUtils {
	
	
	/**
	 * @param messages
	 * @return String
	 */
	public static String processMessage(String[]... messages) {
		final int size = messages[0].length;
		if (messages[1].length != size || messages[2].length != size) {
			throw new MessageNotDeterminedException("El mensaje no se puede determinar");
		}
		String[] finalMessage = new String[size];
		for (String[] message : messages) {
			int index = 0;
			for (String word : message) {
				Optional<String> optional = Optional.ofNullable(word);
				if (optional.isPresent() && !optional.get().isEmpty() && !optional.get().isBlank()) {
					finalMessage[index] = optional.get();
				}
				index++;
			}
		} 
		
	    return String.join(" ", removeNullFromArray(finalMessage));
	}
	
	private static List<String >removeNullFromArray(String[] finalMessage) {
		return Arrays.asList(finalMessage)
				.stream()
				.filter(word -> Optional.ofNullable(word).isPresent())
				.collect(Collectors.toList());
	}
	
	private MessageProcessorUtils() { }
}