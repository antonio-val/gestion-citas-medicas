package com.mycompany.common.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	private final MessageSource msgSource;

	public GlobalExceptionHandler(MessageSource msgSource) {
		super();
		this.msgSource = msgSource;
	}

	@ExceptionHandler(MyCompanyException.class)
	public ResponseEntity<Map<String, Object>> handleMyCompanyException(MyCompanyException e) {
		String msg = msgSource.getMessage(e.getMessageKey(), e.getArgs(), LocaleContextHolder.getLocale());

		Map<String, Object> body = new HashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("status", e.getStatus().value());
		body.put("error", e.getStatus().getReasonPhrase());
		body.put("message", msg);

		return ResponseEntity.status(e.getStatus()).body(body);
	}
}
