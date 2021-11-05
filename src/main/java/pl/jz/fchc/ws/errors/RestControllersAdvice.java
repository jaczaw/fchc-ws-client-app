package pl.jz.fchc.ws.errors;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.ws.client.WebServiceIOException;
import org.springframework.ws.soap.client.SoapFaultClientException;

@ControllerAdvice
class RestControllersAdvice {

    @ResponseBody
    @ExceptionHandler(SoapFaultClientException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    String internalServerErrorHandler(SoapFaultClientException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(WebServiceIOException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    String internalServerErrorHandler(WebServiceIOException ex) {
        return String.format("Usługa niedostepna: %s", ex.getMessage());
    }


}
