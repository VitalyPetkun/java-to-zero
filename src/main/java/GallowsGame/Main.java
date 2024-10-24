package GallowsGame;

import java.util.Scanner;

public class Main {
    private static final Scanner in = new Scanner(System.in);
    public static final int lifeNumber = 5;

    public static Player player;
    public static String answer;

    public static void main(String[] args) {
        System.out.print("Hello!\n"
                .concat("You are in 'The Gallows Game'.\n")
                .concat("How are your name?\n")
                .concat("My Name: "));
        player = new Player(in.next(), lifeNumber);
        in.nextLine();

        System.out.printf("\nNice to meet you, %s!\n", player.getName());

        new Game().gameStart(player);

        askNewGame();
    }

    private static void askNewGame() {
        System.out.println("\nDo you want generate new password? (y/n)");
        System.out.print("Answer: ");
        answer = in.nextLine();

        if(answer.equals("y")) {
            player.setLifeNumber(lifeNumber);
            new Game().gameStart(player);
            askNewGame();
        } else if (answer.equals("n")) {
            System.out.printf("\nGood bye, %s!", player.getName());
        } else {
            askNewGame();
        }
    }
}