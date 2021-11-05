package pl.jz.fchc.ws.wsclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import pl.jz.fchc.service.wsdl.Country;
import pl.jz.fchc.service.wsdl.GetCountryRequest;
import pl.jz.fchc.service.wsdl.GetCountryResponse;
import pl.jz.fchc.service.wsdl.SetCountryRequest;
import pl.jz.fchc.service.wsdl.SetCountryResponse;

@Slf4j
public class CountryClient extends WebServiceGatewaySupport {


    public GetCountryResponse getCountry(String countryName) {
        GetCountryRequest request = new GetCountryRequest();
        request.setName(countryName);
        log.info("Wnioskowanie o lokalizacje dla " + countryName);
        return (GetCountryResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:9091/ws/countries", request,
                        new SoapActionCallback(
                                "http://fchc.jz.pl/kraj/web-service/GetCountryRequest"));
    }


    public SetCountryResponse setCountry(Country country) {
        SetCountryRequest request = new SetCountryRequest();
        request.setCountry(country);
        log.info("Wnioskowanie o dodanie lokalizacji " + country.getName());
        return (SetCountryResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:9091/ws/countries", request,
                        new SoapActionCallback(
                                "http://fchc.jz.pl/kraj/web-service/SetCountryRequest"));
    }
}