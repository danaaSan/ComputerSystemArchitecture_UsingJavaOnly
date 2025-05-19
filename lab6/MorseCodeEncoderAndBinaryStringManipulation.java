package lab6;

import java.util.HashMap;

public class MorseCodeEncoderAndBinaryStringManipulation {
    public static void main(String[] args) {
        // Create a HashMap to store Morse code mappings
        HashMap<Character, String> morseCodeMap = new HashMap<>();

        // Add Morse code mappings to the HashMap
        morseCodeMap.put('A', ".-");
        morseCodeMap.put('B', "-...");
        morseCodeMap.put('C', "-.-.");
        morseCodeMap.put('D', "-..");
        morseCodeMap.put('E', ".");
        morseCodeMap.put('F', "..-.");
        morseCodeMap.put('G', "--.");
        morseCodeMap.put('H', "....");
        morseCodeMap.put('I', "..");
        morseCodeMap.put('J', ".---");
        morseCodeMap.put('K', "-.-");
        morseCodeMap.put('L', ".-..");
        morseCodeMap.put('M', "--");
        morseCodeMap.put('N', "-.");
        morseCodeMap.put('O', "---");
        morseCodeMap.put('P', ".--.");
        morseCodeMap.put('Q', "--.-");
        morseCodeMap.put('R', ".-.");
        morseCodeMap.put('S', "...");
        morseCodeMap.put('T', "-");
        morseCodeMap.put('U', "..-");
        morseCodeMap.put('V', "...-");
        morseCodeMap.put('W', ".--");
        morseCodeMap.put('X', "-..-");
        morseCodeMap.put('Y', "-.--");
        morseCodeMap.put('Z', "--..");
        morseCodeMap.put('.', "1000"); // Morse code for '.'
        morseCodeMap.put('_', "3000"); // Morse code for '_'

        String name = "Dana";
        String name1 = name.toUpperCase();

        for (int i = 0; i < name1.length(); i++) {
            String morse = morseCodeMap.get(name1.charAt(i));
            System.out.println(morse);
            for (int j = 0; j < morse.length(); j++) {
                if (morse.charAt(j) == '.') {
                    int delay = 1000;
                } else {
                    int delay = 3000;
                }
            }

        }

        String a = "0101"; // Binary representation of 0101

        StringBuilder binaryStringBuilder = new StringBuilder();
        binaryStringBuilder.append(1);
        binaryStringBuilder.append(0);
        binaryStringBuilder.append(1);
        binaryStringBuilder.append(0);

        binaryStringBuilder.reverse();


        System.out.println(binaryStringBuilder);
        // Compare string representation of array with binary representation of a
        if (a.equalsIgnoreCase(String.valueOf(binaryStringBuilder))) {
            System.out.println("Correct");
        } else {
            System.out.println("Incorrect");
        }

    }
}
