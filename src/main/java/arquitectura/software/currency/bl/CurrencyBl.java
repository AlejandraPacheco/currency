package arquitectura.software.currency.bl;

import arquitectura.software.currency.dto.ResponseServiceDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
@Service
public class CurrencyBl {
    //Para tener logs
    Logger logger = LoggerFactory.getLogger(CurrencyBl.class);
    public ResponseServiceDto convertCurrency(BigDecimal amount, String from, String to) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El numero ingresado debe ser mayor a cero");
        }
//        OkHttpClient client = new OkHttpClient();
//        ResponseDto ResponseDto = new ResponseDto();

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.apilayer.com/exchangerates_data/convert?" +
                        "&from=" + from + "&to=" + to + "&amount=" + amount)
                .addHeader("apikey", "v4uy0dBrehQBvz7fDuf7bpw44AUxkfHU")
                .build();
        logger.info("Se realiza la solicitud al servicio");
        try {
            Response response = client.newCall(request).execute();
            logger.info("Se obtiene la respuesta del servicio mediante un request");
            if (!response.isSuccessful()) {
                throw new RuntimeException("Error en la solicitud realizada al servicio");
            }
            String body = response.body().string();
            ObjectMapper mapper = new ObjectMapper();
            ResponseServiceDto responseServiceDto = mapper.readValue(body, ResponseServiceDto.class);
            logger.info(responseServiceDto.toString());
            return responseServiceDto;
        } catch (Exception e) {
            logger.error("Error de solicitud al servicio", e);
            e.printStackTrace();
        }
        return null;
    }
}

