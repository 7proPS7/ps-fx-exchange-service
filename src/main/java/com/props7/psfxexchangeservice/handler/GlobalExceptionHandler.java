package com.props7.psfxexchangeservice.handler;

import com.props7.psfxexchangeservice.model.ErrorDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

/*http://zetcode.com/springboot/controlleradvice/*/
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleException(RuntimeException ex, WebRequest request) {
        String errorMessage = joinMessages(ex.getMessage(), request.getSessionId());
        LOG.error(errorMessage);
        final ErrorDto errorDetails = new ErrorDto(LocalDateTime.now(), ex.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private String joinMessages(String... message) {
        return String.join("|", message);
    }
}
