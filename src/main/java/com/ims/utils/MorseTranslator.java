package com.ims.utils;

import com.ims.main.Main;
import org.mockito.internal.stubbing.answers.ThrowsException;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MorseTranslator {

    private final Map<String, String> MORSE_MAP;
    private final Map<String, String> REVERSE_MAP;
    Pattern morsePattern;
    Matcher matcher;

    public MorseTranslator() {
        this.MORSE_MAP = new HashMap<>();

        this.MORSE_MAP.put(".-", "a");
        this.MORSE_MAP.put("-...", "b");
        this.MORSE_MAP.put("-.-.", "c");
        this.MORSE_MAP.put("-..", "d");
        this.MORSE_MAP.put(".", "e");
        this.MORSE_MAP.put("..-.", "f");
        this.MORSE_MAP.put("--.", "g");
        this.MORSE_MAP.put("....", "h");
        this.MORSE_MAP.put("..", "i");
        this.MORSE_MAP.put(".---", "j");
        this.MORSE_MAP.put("-.-", "k");
        this.MORSE_MAP.put(".-..", "l");
        this.MORSE_MAP.put("-- ", "m");
        this.MORSE_MAP.put("-.", "n");
        this.MORSE_MAP.put("---", "o");
        this.MORSE_MAP.put(".--.", "p");
        this.MORSE_MAP.put("--.-", "p");
        this.MORSE_MAP.put("--.- ", "q");
        this.MORSE_MAP.put(".-.", "r");
        this.MORSE_MAP.put("...", "s");
        this.MORSE_MAP.put("-", "t");
        this.MORSE_MAP.put("..-", "u");
        this.MORSE_MAP.put("...-", "v");
        this.MORSE_MAP.put(".--", "w");
        this.MORSE_MAP.put("-..-", "x");
        this.MORSE_MAP.put("", "y");
        this.MORSE_MAP.put("--..", "z");
        this.MORSE_MAP.put("/", " ");

        this.REVERSE_MAP = new HashMap<>();
        for (String key : this.MORSE_MAP.keySet()) {
            this.REVERSE_MAP.put(this.MORSE_MAP.get(key), key);
        }

        morsePattern = Pattern.compile(IMSRegex.MORSE_REGEX);
    }


    public String translate(String input) {
        matcher = morsePattern.matcher(input);

        if (matcher.matches()) {
            return Stream.of(input.split(""))
                    .map(REVERSE_MAP::get)
                    .collect(Collectors.joining(" "));
        } else {
            return Stream.of(input.split(" "))
                    .map(MORSE_MAP::get)
                    .collect(Collectors.joining());
        }
    }

    @Deprecated

    String reverseHashInnefficient(Map<String, String> hashmap, String inpChar) throws Exception {



        for (Map.Entry<String, String> entry : hashmap.entrySet()) {
            System.out.println(entry.getKey() + "/" + entry.getValue());
            if(entry.getValue().equals(inpChar)){
                return entry.getKey() + " ";
            }
        }
        throw new Exception("invalid character");
    }


    @Deprecated
    public String translateBackwardsInnefficient(String input) throws Exception {
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            String morse = reverseHashInnefficient(MORSE_MAP, String.valueOf(c));
            result = result.concat(morse);
        }

        return result;


    }


    public String noStreamTranslate(String input) {
        StringBuilder output = new StringBuilder();

        for (String word: input.split(" ")) {
            output.append(MORSE_MAP.get(word));
        }
        return output.toString();
    }

    @Deprecated
    public String jankyTranslate(String code){


        String result = "";

        String buffer = "";
        for (int i = 0; i < code.length(); i++) {
            System.out.println(buffer);

            char c = code.charAt(i);

            if(c != ' ' )buffer = buffer.concat(String.valueOf(c));
            else {


                if (MORSE_MAP.containsKey(buffer)) {
                    result = result.concat(MORSE_MAP.get(buffer));
                    System.out.println(buffer);
                    buffer = "";
                }
            }


            // final end case
            if(i == code.length()-1){
                if (MORSE_MAP.containsKey(buffer)) {
                    result = result.concat(MORSE_MAP.get(buffer));
                    System.out.println(buffer);
                    buffer = "";
                }
            }

        }
        return result;


    }

}
