package arquitectura.software.currency.exception;

public class ServiceError extends RuntimeException{
        public ServiceError(String message) {
            super("Error de solicitud al servicio");
        }
}
