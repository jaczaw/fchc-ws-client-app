package pl.jz.fchc.ws;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.jz.fchc.service.wsdl.GetCountryResponse;
import pl.jz.fchc.ws.endpoint.CountryClient;


@Slf4j
@SpringBootApplication
public class FchcWsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FchcWsAppApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(CountryClient quoteClient) {
		return args -> {
			String country = "Spain";

			if (args.length > 0) {
				country = args[0];
			}
			GetCountryResponse response = quoteClient.getCountry(country);
			log.info(response.getCountry().getCurrency());

			GetCountryResponse responsePL = quoteClient.getCountry("Poland");
			log.info("Nazwa kraju:  {}, Stolica kraju:  {}, Ludnosc:  {} "
					, responsePL.getCountry().getName()
					, responsePL.getCountry().getCapital()
					, responsePL.getCountry().getPopulation()
			);
		};
	}

}
