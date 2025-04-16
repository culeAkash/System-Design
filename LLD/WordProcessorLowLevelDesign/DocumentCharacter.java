package LLD.WordProcessorLowLevelDesign;

public class DocumentCharacter implements ILetter {
    private char character;
    private int size;
    private String font;

    public DocumentCharacter(char character, int size, String font) {
        this.character = character;
        this.size = size;
        this.font = font;
    }

    public char getCharacter() {
        return character;
    }

    public int getSize() {
        return size;
    }

    public String getFont() {
        return font;
    }

    public void display(int row, int col) {
        System.out.println("Displaying character " + character + " at row " + row + " and column " + col);
    }
}
