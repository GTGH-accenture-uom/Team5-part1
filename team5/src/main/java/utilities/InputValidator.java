package utilities;


import java.util.regex.Pattern;

public class InputValidator {


    public static boolean checkAfm(String afm) {
        if (Pattern.matches("(?<!\\d)\\d{9}(?!\\d)", afm)) {
            return true;
        }
        return false;
    }

    public static boolean checkAmka(String amka){
        if (Pattern.matches("(?<!\\d)\\d{11}(?!\\d)",amka)) {
            return true;
        }
        return false;
    }


}
