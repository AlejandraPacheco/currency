package arquitectura.software.currency.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/currency")
@RestController
public class CurrencyApi {
    @RequestMapping("hello")
    public String hello() {
        return "Hello World";
    }

}

