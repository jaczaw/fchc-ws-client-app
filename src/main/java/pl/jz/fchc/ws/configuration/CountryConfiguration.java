package pl.jz.fchc.ws.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import pl.jz.fchc.ws.wsclient.CalculatorClient;
import pl.jz.fchc.ws.wsclient.CountryClient;

@Configuration
public class CountryConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // ten pakiet musi być zgodny z pakietem w <generatePackage> określonym w
        // pom.xml
        marshaller.setContextPath("pl.jz.fchc.service.wsdl");
        return marshaller;
    }

    @Bean
    public CountryClient countryClient(Jaxb2Marshaller marshaller) {
        CountryClient client = new CountryClient();
        client.setDefaultUri("http://localhost:9091/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

    @Bean
    public CalculatorClient calculatorClient(Jaxb2Marshaller marshaller) {
        CalculatorClient client = new CalculatorClient();
        client.setDefaultUri("http://localhost:9091/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}
