package arquitectura.software.currency.config;

import arquitectura.software.currency.dto.ResponseDto;
import arquitectura.software.currency.exception.ServiceError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ServiceConfigurationError;

@ControllerAdvice
public class Controller {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ResponseDto<Void>> handleIllegalArgumentException(IllegalArgumentException e) {
        ResponseDto<Void> response = new ResponseDto<>();
        response.setSuccessful(false);
        response.setMessage(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ServiceError.class)
    public ResponseEntity<ResponseDto<Void>> handleServiceException(ServiceError e) {
            ResponseDto<Void> response = new ResponseDto<>();
            response.setSuccessful(false);
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.SERVICE_UNAVAILABLE);
    }
}
