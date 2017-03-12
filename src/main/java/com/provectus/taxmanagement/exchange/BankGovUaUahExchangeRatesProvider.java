package com.provectus.taxmanagement.exchange;

import com.provectus.taxmanagement.entity.ExchangeRateUah;
import com.provectus.taxmanagement.exchange.entity.BankGovUaJsonModelItem;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by alexey on 12.03.17.
 */
public class BankGovUaUahExchangeRatesProvider extends ExchangeRatesProviderFactory {
    public static final String BASE_URL = "http://bank.gov.ua/NBUStatService/v1/statdirectory/exchange";
    public static final String BANK_GOV_UA_DATE_FORMAT = "dd.MM.yyyy";
    public static final String RESPONSE_TYPE = "json";
    public static final String DUMMY = "dummy";
    public static final String VALCODE_PARAMETER_NAME = "valcode";
    public static final String DATE_PARAMETER_NAME = "date";

    @Override
    public List<ExchangeRate> getAllRatesJson() {
        return null;
    }

    @Override
    public List<ExchangeRate> getAllRatesJson(String date) {
        return null;
    }

    @Override
    public ExchangeRate getRatesJson(String currencyCode, String date) throws URISyntaxException, MalformedURLException, ParseException {
        RestTemplate restTemplate = new RestTemplate();
        URIBuilder uriBuilder;
        uriBuilder = new URIBuilder(BASE_URL);
        uriBuilder.addParameter(RESPONSE_TYPE, DUMMY);
        uriBuilder.addParameter(VALCODE_PARAMETER_NAME, currencyCode);
        uriBuilder.addParameter(DATE_PARAMETER_NAME, date);

        URL url = uriBuilder.build().toURL();

        ResponseEntity<List<BankGovUaJsonModelItem>> rateResponse = restTemplate.exchange(url.toString(),
                HttpMethod.GET, null, new ParameterizedTypeReference<List<BankGovUaJsonModelItem>>() {
                });
        List<BankGovUaJsonModelItem> rates = rateResponse.getBody();
        BankGovUaJsonModelItem model = rates.get(0);

        ExchangeRate exchangeRate = new ExchangeRateUah();
        exchangeRate.setCurrencyType(model.getCc());
        Date parsedDate;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(BANK_GOV_UA_DATE_FORMAT);
        simpleDateFormat.setLenient(false);
        parsedDate = simpleDateFormat.parse(model.getExchangedate());
        exchangeRate.setExchangeRateDate(parsedDate);
        exchangeRate.setRate(model.getRate());
        exchangeRate.setRateProviderResource(BASE_URL);
        return exchangeRate;
    }
}
