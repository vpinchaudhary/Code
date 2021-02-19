/**
*Converts a given string to morsecode and vice versa by using method overloading
*/

import java.util.*;

class MorseCodeEncoderDecoder{
    final String[] morseCode = new String[]{
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
            ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-",
            ".--", "-..-", "-.--", "--..", ".----", "..---", "...--", "....-", ".....",
            "-....", "--...", "---..", "---..", "----.", "-----"
    };

    final String alphanum = "ABCDEFGHIJKLMNOPQRSTUVWXYZ01234567890";

    public String convert(String message){
        String code = "";

        if(Character.isAlphabetic(message.charAt(0)) || Character.isDigit(message.charAt(0))){
            for (int i = 0; i < message.length(); i++) {
                code += code(message.charAt(i));
            }
        }
        else{
            String morse[] = message.split(" ");
            for (int i = 0; i < morse.length; i++) {
                code += code(morse[i]);
            }
        }

        return code;
    }

    public String code(char character) {

        for (int i = 0; i < alphanum.length(); i++) {
            if(character == alphanum.charAt(i)){
                return morseCode[i]+" ";
            }
        }
        return "";
    }
    public String code(String string){

        for (int i = 0; i < alphanum.length(); i++) {
            if(string.equals(morseCode[i])){
                return ""+alphanum.charAt(i);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(new MorseCodeConvertor().convert(scan.nextLine()));
        //YOu can either pass MorseCode or String in the convert method
    }
}
