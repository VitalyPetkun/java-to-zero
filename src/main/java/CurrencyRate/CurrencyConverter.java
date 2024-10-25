package CurrencyRate;

import java.util.Map;
import java.util.TreeMap;

public class CurrencyConverter {
    private final float sum;
    private final String currentCurrency;
    private final Map<String, Float> currenciesRate;
    private final Map<String, Float> outputSums;

    public CurrencyConverter(float sum, String currentCurrency, Map<String, Float> currenciesRate) {
        this.sum = sum;
        this.currentCurrency = currentCurrency;
        this.currenciesRate = currenciesRate;
        outputSums = new TreeMap<>();
    }

    private void converterSums() {
        for (String currencyName : currenciesRate.keySet()) {
            outputSums.put(
                    currencyName,
                    ((sum * currenciesRate.get(currencyName)) / currenciesRate.get(currentCurrency))
            );
        }
    }

    public void outputTableCurrenciesRate() {
        this.converterSums();

        System.out.println("\n-----------------------------------------------------------------------------");
        System.out.println("|\tCurrency name\t|\tCurrency Rate\t|\t\t\t\tSum\t\t\t\t\t|");
        System.out.println("-----------------------------------------------------------------------------");

        for (String currencyName : currenciesRate.keySet()) {
            System.out.printf("|\t\t%-10s\t|\t\t%-10.4f\t|\t\t\t%-20.2f\t|\n",
                    currencyName,
                    currenciesRate.get(currencyName),
                    outputSums.get(currencyName)
            );
            System.out.println("-----------------------------------------------------------------------------");
        }
    }
}
