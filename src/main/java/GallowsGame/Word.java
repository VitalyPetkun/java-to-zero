package GallowsGame;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Word {
    private String word;
    private char[] trueLetters;
    private char[] guessedLetters;

    public Word() {
        this.word = Words.getRandomWord();
        this.trueLetters = word.toCharArray();
        this.guessedLetters = word.replaceAll("[A-ZА-Я]", "_").toCharArray();
    }

    public Word(String word) {
        this.word = word;
        this.trueLetters = word.toCharArray();
        this.guessedLetters = new char[trueLetters.length];
    }

    public boolean isLetterInWord(String letter) {
        return word.contains(letter);
    }

    public boolean isLetterInGuessedLetters(String letter) {
        return String.valueOf(this.getGuessedLetters()).contains(letter);
    }

    public void addLetterToGuessedLetters(char newLetter) {
        for (int i = 0; i < trueLetters.length; ++i) {
            if (trueLetters[i] == newLetter)
                guessedLetters[i] = newLetter;
        }
    }
}
