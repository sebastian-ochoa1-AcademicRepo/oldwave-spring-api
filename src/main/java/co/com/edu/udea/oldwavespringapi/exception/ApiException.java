package co.com.edu.udea.oldwavespringapi.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Data
public class ApiException {
    private final ZonedDateTime timestamp;
    private final int code;
    private final HttpStatus error;
    private final String message;

}
