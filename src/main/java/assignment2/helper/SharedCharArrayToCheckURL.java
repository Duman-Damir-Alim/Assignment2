package assignment2.helper;

public class SharedCharArrayToCheckURL {
    private final char[] text;

    public SharedCharArrayToCheckURL(int length) {
        text = new char[length];
    }

    public char[] getText() {
        return text;
    }

    public void updateText(char letter, int index) {
        text[index] = letter;
    }
}
