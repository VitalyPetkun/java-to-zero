package PasswordGenerator;

import java.util.Scanner;

public class Main {
    private static final Scanner in = new Scanner(System.in);
    private static final int minPasswordLength = 8;
    private static final int maxPasswordLength = 12;
    private static int length = 0;
    private static String answer;

    public static void main(String[] args) {
        System.out.printf("This is 'Password generator'.\n");

        getNewPassword();

        askGetNewPassword();
    }

    private static void getNewPassword() {
        do {
            inputPasswordLength();
        } while (!(minPasswordLength <= length && length <= maxPasswordLength));

        System.out.println("\nPASSWORD: ".concat(PasswordGenerator.getPassword(length)));
    }

    private static void inputPasswordLength() {
        System.out.printf("\nPassword length should be from %d to %d characters."
                        .concat("\nPlease, input correct password length: ")
                , minPasswordLength
                , maxPasswordLength);
        length = in.nextInt();
        in.nextLine();
    }

    private static void askGetNewPassword() {
        System.out.println("\nDo you want generate new password? (y/n)");
        System.out.print("Answer: ");
        answer = in.nextLine();

        if(answer.equals("y")) {
            getNewPassword();
            askGetNewPassword();
        } else if (answer.equals("n")) {
            System.out.println("\nGood bye!");
        } else {
            askGetNewPassword();
        }
    }
}
