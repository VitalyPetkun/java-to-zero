package PasswordGenerator;

import java.util.Random;

public class PasswordGenerator {
    private static final int FIRST_PART_BOTTOM_VALUE = 65;
    private static final int FIRST_PART_TOP_VALUE = 90;
    private static final int SECOND_PART_BOTTOM_VALUE = 97;
    private static final int SECOND_PART_TOP_VALUE = 122;
    private static final int THIRD_PART_BOTTOM_VALUE = 33;
    private static final int THIRD_PART_TOP_VALUE = 47;
    private static final int FOURTH_PART_BOTTOM_VALUE = 48;
    private static final int FOURTH_PART_TOP_VALUE = 64;
    private static final int PART_COUNT = 4;

    private static String password = "";

    private PasswordGenerator() {
    }

    public static String getPassword(int length) {
        int partSize = length / PART_COUNT;
        int lastPartSize = length % PART_COUNT;

        password = password.concat(getRandomString(partSize, FIRST_PART_BOTTOM_VALUE, FIRST_PART_TOP_VALUE));
        password = password.concat(getRandomString(partSize, SECOND_PART_BOTTOM_VALUE, SECOND_PART_TOP_VALUE));
        password = password.concat(getRandomString(partSize, THIRD_PART_BOTTOM_VALUE, THIRD_PART_TOP_VALUE));
        password = password.concat(getRandomString(partSize, FOURTH_PART_BOTTOM_VALUE, FOURTH_PART_TOP_VALUE));
        if (lastPartSize > 0)
            password = password.concat(getRandomString(lastPartSize, FIRST_PART_BOTTOM_VALUE, FIRST_PART_TOP_VALUE));

        return shuffleArray(password.toCharArray());
    }

    private static String getRandomString(int stringLength, int bottomValue, int topValue) {
        String randomString = "";
        String newSymbol;
        for (int i = 0; i < stringLength; i++) {
            newSymbol = String.valueOf(Character.toChars(
                    (int) (Math.random() * (topValue - bottomValue)) + bottomValue));

            if (randomString.contains(newSymbol)) {
                --i;
            } else {
                randomString = randomString.concat(newSymbol);
            }
        }

        return randomString;
    }

    private static String shuffleArray(char[] arr) {
        Random random = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            char temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }

        return String.valueOf(arr);
    }
}
