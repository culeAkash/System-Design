package LLD.WordProcessorLowLevelDesign;

import java.util.HashMap;
import java.util.Map;

public class LetterFactory {
    public static Map<Character,ILetter> letterMap = new HashMap<>();


    public static ILetter createCharacter(char character) {
        if (letterMap.containsKey(character)) {
            return letterMap.get(character);
        }
        else{
            ILetter letter = new DocumentCharacter(character, 10, "Arial");
            letterMap.put(character, letter);
            return letter;
        }
    }
}
