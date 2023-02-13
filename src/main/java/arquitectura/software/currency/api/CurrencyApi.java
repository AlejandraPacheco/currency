package arquitectura.software.currency.api;

import arquitectura.software.currency.bl.CurrencyBl;
import arquitectura.software.currency.dto.ResponseDto;
import arquitectura.software.currency.dto.ResponseServiceDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.math.BigDecimal;
@RestController
@RequestMapping("api/v1/currency")
public class CurrencyApi {
    //Para tener logs
    private static Logger logger = LoggerFactory.getLogger(CurrencyApi.class);
    private CurrencyBl currencyBl;
    public CurrencyApi(CurrencyBl currencyBl) {
        this.currencyBl = currencyBl;
    }

    @GetMapping("/exchange")
    public ResponseDto<ResponseServiceDto> getCurrency(
            @RequestParam BigDecimal amount,
            @RequestParam String from,
            @RequestParam String to){
            logger.info("Convertir " +  amount + " de " + from + " a" + to);
            logger.info("Se empieza con la logica de negocio");
            ResponseServiceDto responseServiceDto = currencyBl.convertCurrency(amount, from, to);
            ResponseDto<ResponseServiceDto> responseDto = new ResponseDto<ResponseServiceDto>(responseServiceDto, true, null);
            return responseDto;
    }
}

