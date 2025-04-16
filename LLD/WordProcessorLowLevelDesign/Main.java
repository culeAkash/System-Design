package LLD.WordProcessorLowLevelDesign;

public class Main {
    public static void main(String[] args) {
        ILetter letterA = LetterFactory.createCharacter('a');
        letterA.display(2, 3);


        ILetter letterB = LetterFactory.createCharacter('b');
        letterB.display(2, 3);
    }
}
