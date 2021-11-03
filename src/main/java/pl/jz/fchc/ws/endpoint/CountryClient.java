package pl.jz.fchc.ws.endpoint;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import pl.jz.fchc.service.wsdl.GetCountryRequest;
import pl.jz.fchc.service.wsdl.GetCountryResponse;

@Slf4j
public class CountryClient extends WebServiceGatewaySupport {


    public GetCountryResponse getCountry(String country) {

        GetCountryRequest request = new GetCountryRequest();
        request.setName(country);

        log.info("Wnioskowanie o lokalizacje dla " + country);

        GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:9091/ws/countries", request,
                        new SoapActionCallback(
                                "http://fchc.jz.pl/kraj/web-service/GetCountryRequest"));

        return response;
    }

}