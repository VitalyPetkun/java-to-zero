package GallowsGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private final Scanner in = new Scanner(System.in);
    private final Word WORD = new Word();

    private Player player;
    private String inputLetter;
    private List<String> inputtedLetters;

    public void gameStart(Player newPlayer) {
        inputLetter = "";
        inputtedLetters = new ArrayList<>();
        player = newPlayer;

         do {
            if (!String.valueOf(WORD.getGuessedLetters()).contains("_"))
                break;

            System.out.println("\nGUEST WORD: ".concat(String.valueOf(WORD.getGuessedLetters())));

            this.getUsedLetter();
            this.inputLetter();

            if (this.checkLetter()) {
                WORD.addLetterToGuessedLetters(inputLetter.toCharArray()[0]);
            }
        } while (player.getLifeNumber() != 0);

        if (player.getLifeNumber() == 0) {
            System.out.printf("\n%s, GAME OVER!\n", player.getName());
            return;
        }

        System.out.println("\nGUEST WORD: ".concat(String.valueOf(WORD.getGuessedLetters())));
        System.out.printf("\n!!!Congratulations!!!\n%s, you are a winner and saved your life!\n", player.getName());
    }



    private void inputLetter() {
        System.out.printf("\nYou have %d life. \nInput letter: ", player.getLifeNumber());
        inputLetter = in.nextLine().toUpperCase();
    }

    private boolean checkLetter() {
        if (inputLetter.toCharArray().length == 1) {
            if (inputtedLetters.contains(inputLetter)) {
                System.out.printf("\n%s, you inputted letter '%s' earlier!\n"
                                .concat("I won't take your life, try again.\n"),
                        player.getName(),
                        inputLetter.toUpperCase());
                return false;
            } else {
                if (WORD.isLetterInWord(inputLetter)) {
                    return true;
                } else {
                    player.setLifeNumber(player.getLifeNumber() - 1);
                    return false;
                }
            }
        } else {
            System.out.printf("\n%s, you need input ONE letter!\nI won't take your life, try again.\n", player.getName());
            return false;
        }
    }

    private void getUsedLetter() {
        if (!inputtedLetters.contains(inputLetter.toUpperCase()))
            inputtedLetters.add(inputLetter.toUpperCase());

        System.out.print("Earlier, you used letters: ");
        inputtedLetters.forEach(x -> System.out.print(x.concat(" ")));
    }
}
