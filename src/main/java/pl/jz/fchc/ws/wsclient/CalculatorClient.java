package pl.jz.fchc.ws.wsclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import pl.jz.fchc.service.wsdl.AdditionInput;
import pl.jz.fchc.service.wsdl.DivisionInput;
import pl.jz.fchc.service.wsdl.Output;


@Slf4j
public class CalculatorClient extends WebServiceGatewaySupport {

    public Output dodaj(int n1, int n2) {
        AdditionInput request = new AdditionInput();
        request.setNumber1(n1);
        request.setNumber2(n2);

        log.info("Wywolanie dodawania ");
        return (Output) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:9091/ws/calculatorDemo", request,
                        new SoapActionCallback(
                                "http://jaczaw.pl/types/calculator/AdditionInput"));
    }

    public Output dzielenie(int n1, int n2) {
        DivisionInput request = new DivisionInput();
        request.setNumber1(n1);
        request.setNumber2(n2);

        log.info("Wywolanie dzielenia ");
        return (Output) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:9091/ws/calculatorDemo", request,
                        new SoapActionCallback(
                                "http://jaczaw.pl/types/calculator/DivisionInput"));
    }
}
