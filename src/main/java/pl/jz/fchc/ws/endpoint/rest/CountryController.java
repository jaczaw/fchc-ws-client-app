package pl.jz.fchc.ws.endpoint.rest;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.jz.fchc.service.wsdl.Country;
import pl.jz.fchc.service.wsdl.GetCountryResponse;
import pl.jz.fchc.service.wsdl.SetCountryResponse;
import pl.jz.fchc.ws.wsclient.CountryClient;


@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/api/country")
public class CountryController {

    private final CountryClient countryClient;

    @GetMapping("/{nazwa}")
    public ResponseEntity<Country> getCountryName(@PathVariable String nazwa) {
        GetCountryResponse response = countryClient.getCountry(nazwa);
        log.info("Call GetCountryResponse: {}", response.getCountry().getName());
        return ResponseEntity.ok(response.getCountry());
    }

    @PostMapping()
    public ResponseEntity<String> addCountry(@RequestBody Country country) {
        SetCountryResponse response = countryClient.setCountry(country);
        log.info("Call SetCountryResponse: {}", response.getName());
        return ResponseEntity.ok(response.getName());
    }
}
