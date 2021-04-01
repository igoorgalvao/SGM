package com.cidadao.api.core;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CidadaoExcepetionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private MessageSource messageSource;

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		String mensagemUsuario = messageSource.getMessage("mensagem.invalida", null, LocaleContextHolder.getLocale());
		String mensagemDesenvolvedor = ExceptionUtils.getRootCauseMessage(ex);

		return handleExceptionInternal(ex, new Erro(mensagemUsuario, mensagemDesenvolvedor), headers,
				HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler({ BusinessException.class })
	protected ResponseEntity<Object> handleBusinessException(BusinessException ex, WebRequest request) {
		String mensagemUsuario = null;
		try {
			mensagemUsuario = messageSource.getMessage(ex.getMessage(), null, LocaleContextHolder.getLocale());
		} catch (NoSuchMessageException e) {
			mensagemUsuario = ex.getMessage();
		}

		String mensagemDesenvolvedor = mensagemUsuario;

		return handleExceptionInternal(ex, new Erro(mensagemUsuario, mensagemDesenvolvedor), new HttpHeaders(),
				HttpStatus.BAD_REQUEST, request);
	}

}
