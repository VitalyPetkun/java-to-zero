package GallowsGame;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Getter
public enum Words {
    YELLOW("YELLOW"),
    JAVA("JAVA"),
    RESOURCES("RESOURCES"),
    RESPONSE("RESPONSE"),
    COOKIES("COOKIES");

    private String word;

    Words(String word) {
        this.word = word;
    }

    public static String getRandomWord() {
        List<Words> words = Arrays.asList(Words.values());
        return words
                .get(new Random().nextInt(words.size()))
                .getWord().toUpperCase();
    }
}
