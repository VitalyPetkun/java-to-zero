package CurrencyRate.config;

import org.aeonbits.owner.ConfigFactory;

import java.util.Map;
import java.util.TreeMap;

public class CurrenciesData {
    private CurrenciesData() {
    }

    public static CurrenciesProperties getValue() {
        return ConfigFactory.create(CurrenciesProperties.class);
    }

    public static Map<String, Float> getDefaultCurrenciesRate() {
        Map<String, Float> defaultCurrenciesRate = new TreeMap<>();
        defaultCurrenciesRate.put(getValue().BYN(), getValue().bynRate());
        defaultCurrenciesRate.put(getValue().RUB(), getValue().rubRate());
        defaultCurrenciesRate.put(getValue().USD(), getValue().usdRate());
        defaultCurrenciesRate.put(getValue().EUR(), getValue().eurRate());
        defaultCurrenciesRate.put(getValue().PLN(), getValue().plnRate());

        return defaultCurrenciesRate;
    }
}
