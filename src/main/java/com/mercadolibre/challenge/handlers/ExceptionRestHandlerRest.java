package com.mercadolibre.challenge.handlers;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.ResponseEntity.status;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mercadolibre.challenge.dto.ApiErrorDTO;
import com.mercadolibre.challenge.exceptions.InformationErrorException;
import com.mercadolibre.challenge.exceptions.MessageNotDeterminedException;
import com.mercadolibre.challenge.exceptions.PositionNotDeterminedExceptipon;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ExceptionRestHandlerRest {
	
	@ExceptionHandler(MessageNotDeterminedException.class)
	public ResponseEntity<ApiErrorDTO> handleMessageNotDeterminedException(final MessageNotDeterminedException ex,
															final HttpServletRequest request) {
		ApiErrorDTO error = ApiErrorDTO.builder()
				.error(BAD_REQUEST.getReasonPhrase())
				.message(ex.getMessage())
				.status(BAD_REQUEST.value())
				.path(request.getRequestURI())
				.timestamp(ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT))
				.exception("MessageNotDeterminedException")
				.build();
	    
		log.error("handleMessageNotDeterminedException", error, ex);
		return status(BAD_REQUEST).body(error);	
	}
	
	@ExceptionHandler(InformationErrorException.class)
	public ResponseEntity<ApiErrorDTO> handleInformationErrorException(final InformationErrorException ex,
															final HttpServletRequest request) {
		ApiErrorDTO error = ApiErrorDTO.builder()
				.error(BAD_REQUEST.getReasonPhrase())
				.message(ex.getMessage())
				.status(BAD_REQUEST.value())
				.path(request.getRequestURI())
				.timestamp(ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT))
				.exception("InformationErrorException")
				.build();
	    
		log.error("handleInformationErrorException", error, ex);
		return status(BAD_REQUEST).body(error);	
	}
	
	
	@ExceptionHandler(PositionNotDeterminedExceptipon.class)
	public ResponseEntity<ApiErrorDTO> handlePositionNotDeterminedExceptipon(final PositionNotDeterminedExceptipon ex,
															final HttpServletRequest request) {
		ApiErrorDTO error = ApiErrorDTO.builder()
				.error(BAD_REQUEST.getReasonPhrase())
				.message(ex.getMessage())
				.status(BAD_REQUEST.value())
				.path(request.getRequestURI())
				.timestamp(ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT))
				.exception("PositionNotDeterminedExceptipon")
				.build();
	    
		log.error("handlePositionNotDeterminedExceptipon", error, ex);
		return status(BAD_REQUEST).body(error);	
	}

}
