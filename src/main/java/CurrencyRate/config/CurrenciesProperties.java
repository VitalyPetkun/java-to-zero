package CurrencyRate.config;

import org.aeonbits.owner.Config;

@Config.Sources("file:./src/main/resources/currencies.properties")
public interface CurrenciesProperties extends Config{
    String BYN();
    String RUB();
    String EUR();
    String USD();
    String PLN();
    float bynRate();
    float rubRate();
    float usdRate();
    float eurRate();
    float plnRate();
}
