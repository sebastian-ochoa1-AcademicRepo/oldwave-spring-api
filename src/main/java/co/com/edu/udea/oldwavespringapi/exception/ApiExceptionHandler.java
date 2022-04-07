package co.com.edu.udea.oldwavespringapi.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler extends  ResponseEntityExceptionHandler{

    @ExceptionHandler(value={ApiNotFoundException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiNotFoundException e) {

        HttpStatus notFound = HttpStatus.NOT_FOUND;
        ApiException apiException = new ApiException(
                ZonedDateTime.now(ZoneId.of("Z")),
                404,
                notFound,
                e.getMessage()
        );

        return new ResponseEntity<>(apiException, notFound);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(
            MissingServletRequestParameterException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {

        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ApiException apiException = new ApiException(
                ZonedDateTime.now(ZoneId.of("Z")),
                400,
                badRequest,
                "Por favor verifica la URL o los parametros enviados"
        );

        return new ResponseEntity<>(apiException, badRequest);
    }





}
