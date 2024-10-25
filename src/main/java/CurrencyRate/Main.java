package CurrencyRate;

import CurrencyRate.config.CurrenciesData;

import java.util.*;

public class Main {
    private static final Scanner in = new Scanner(System.in);
    private static final Map<String, Float> defaultCurrencies = CurrenciesData.getDefaultCurrenciesRate();

    private static float sum = 0;
    private static String answer;
    private static CurrencyConverter currencyConverter;
    private static Map<String, Float> userCurrenciesRate = new TreeMap<>();

    public static void main(String[] args) {
        System.out.println("This is 'CurrencyRate'.");

        askSetUserCurrenciesRate();
        inputSum();
        inputSumCurrency();

        currencyConverter.outputTableCurrenciesRate();
        askContinue();
    }

    public static void setUserCurrenciesRate() {
        userCurrenciesRate = defaultCurrencies;
        System.out.printf("\nExists currencies rate: %s\n", defaultCurrencies.keySet());

        userCurrenciesRate.replaceAll((currencyName, currencyRate) -> getUserCurrencyRate(currencyName));
    }

    private static float getUserCurrencyRate(String currencyName) {
        String bufferCurrencyRate = "";
        float currencyRate = 0;

        do {
            System.out.printf("%s rate: ", currencyName);
            try {
                bufferCurrencyRate = in.nextLine();
                currencyRate = Float.parseFloat(bufferCurrencyRate.replace(",", "."));

                if (currencyRate <= 0) {
                    System.out.printf("Currency rate = '%f' format isn't correct!"
                            .concat("Currency rate should be format: xxx,xxxx\n"), currencyRate);
                    getUserCurrencyRate(currencyName);
                }

                return currencyRate;
            } catch (InputMismatchException | NumberFormatException exception) {
                System.out.printf("Currency rate = '%f' format isn't correct!"
                        .concat("Currency rate should be format: xxx,xxxx\n"), bufferCurrencyRate);
            }
        } while (currencyRate == 0);

        return currencyRate;
    }

    public static void inputSum() {
        do {
            String bufferSum = "";
            try {
                System.out.print("\nInput your sum: ");
                bufferSum = in.nextLine();
                sum = Float.parseFloat(bufferSum.replace(",", "."));

                if (sum <= 0) {
                    System.out.printf("Sum = '%f' format isn't correct! Sum should be format: xxx,xx\n", sum);
                    inputSum();
                }

            } catch (InputMismatchException | NumberFormatException exception) {
                System.out.printf("Sum = '%s' format isn't correct! Sum should be format: xxx,xx\n", bufferSum);
            }
        } while (sum == 0);
    }

    public static void inputSumCurrency() {
        if (userCurrenciesRate.isEmpty())
            userCurrenciesRate = defaultCurrencies;

        String currencyName = "";
        do {
            System.out.printf("\nInput sum currency %s: ", defaultCurrencies.keySet());
            currencyName = in.nextLine();

            if (!defaultCurrencies.containsKey(currencyName))
                inputSumCurrency();
        } while (currencyName.isEmpty());

        currencyConverter = new CurrencyConverter(sum, currencyName, userCurrenciesRate);
    }

    private static void askContinue() {
        answer = "";

        System.out.println("\nDo you want continue? (y/n)");
        System.out.print("Answer: ");
        answer = in.nextLine();

        if (answer.equals("y")) {
            inputSum();
            inputSumCurrency();
            currencyConverter.outputTableCurrenciesRate();

            askContinue();
        } else if (answer.equals("n")) {
            System.out.println("\nGood bye!");
        } else {
            askContinue();
        }
    }

    private static void askSetUserCurrenciesRate() {
        System.out.println("\nDo you want set your custom currency rate? (y/n)");
        System.out.print("Answer: ");
        answer = in.nextLine();

        if (answer.equals("y")) {
            setUserCurrenciesRate();
        } else if (!answer.equals("n")) {
            askSetUserCurrenciesRate();
        }
    }
}
