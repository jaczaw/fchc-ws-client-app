package pl.jz.fchc.ws.endpoint.rest;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.jz.fchc.service.wsdl.Output;
import pl.jz.fchc.ws.wsclient.CalculatorClient;

import static java.lang.Integer.parseInt;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/api/calculator")
public class CalculatorController {

    private final CalculatorClient calculatorClient;

    @GetMapping("/add/{n1}/{n2}")
    public ResponseEntity<String> getAdd(@PathVariable String n1,
                                         @PathVariable String n2) {
        Output response = calculatorClient.dodaj(parseInt(n1), parseInt(n2));
        log.info("Call GetCountryResponse: {}", response.getResult());
        return ResponseEntity.ok("Wynik dodawania: " + response.getResult());
    }

    @GetMapping("/div/{n1}/{n2}")
    public ResponseEntity<String> getDzielenie(@PathVariable String n1,
                                               @PathVariable String n2) {
        Output response = calculatorClient.dzielenie(parseInt(n1), parseInt(n2));
        log.info("Call Output: {}", response.getResult());
        return ResponseEntity.ok("Wynik dzielenia: " + response.getResult());
    }

}
