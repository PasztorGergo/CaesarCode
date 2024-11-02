import java.util.*;

public class Encoder {
    private int shift;

    public Encoder(){
        shift = 1;
    }

    public void setShift(char startChar){
        shift = Character.toUpperCase(startChar) - 'A';
    }

    public String encode(String baseText){
        ArrayList<Character> charList = new ArrayList<>();

        for(char c : baseText.toCharArray()){
            charList.add(Character.toUpperCase(c));
        }

        StringBuilder output = new StringBuilder();

        for(Character c : charList.stream().map(c -> ((c + shift) > 90 ? (char)(c - ('Z' - 'A' + 1) + shift ) : (char)(c + shift))).toList()){
            output.append(c);
        }

        return output.toString();
    }
}
