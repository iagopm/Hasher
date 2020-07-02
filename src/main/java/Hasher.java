import org.apache.commons.codec.digest.DigestUtils;

public class Hasher {
    private final static String salt = "";

    public static String hash(String input) {
        if (input.isEmpty() || input.length() > 256) {
            return null;
        }
        String inputToHash = "";
        inputToHash = ifStringIsOddReverseCharacters(input);
        inputToHash += concatNumberDependingOnStringProperties(input);
        return DigestUtils.sha512Hex(inputToHash + salt);
    }

    private static String concatNumberDependingOnStringProperties(String input) {
        String stringToAdd = "";
        double total = 0;
        boolean isPI = false;
        boolean isRAD = false;
        boolean isAureum = false;
        int lowerCaseCounter = 0;
        //If contains a number;
        if (input.matches(".*[0-9]")) {
            isPI = true;
        }
        //If contains a upper case char;
        if (!input.equals(input.toLowerCase())) {
            isAureum = true;
        }
        for (int iterator = 0; iterator < input.length(); iterator++) {
            //If contains more than three lower case char;
            if (Character.isLowerCase(input.charAt(iterator))) {
                lowerCaseCounter += 1;
                if (lowerCaseCounter >= 3) {
                    isRAD = true;
                }
            }
        }
        if (isAureum) {
            double inputMultiplied = (1 + Math.sqrt(5)) / 2 * input.length();
            stringToAdd += inputMultiplied + "";
            total += inputMultiplied;
        }
        if (isPI) {
            double inputMultiplied = Math.PI * input.length();
            stringToAdd += inputMultiplied + "";
            total += inputMultiplied;
        }
        if (isRAD) {
            double inputMultiplied = Math.toRadians(input.length()) * input.length();
            stringToAdd += inputMultiplied + "";
            total += inputMultiplied;
        }
        stringToAdd += total + "";
        return stringToAdd;
    }

    private static String ifStringIsOddReverseCharacters(String input) {
        if ((input.length() % 2) == 0) {
            return input;
        } else {
            return reverseString(input);
        }
    }

    private static String reverseString(String string) {
        String stringReversed = "";
        for (int iterator = string.length() - 1; iterator >= 0; iterator--) {
            stringReversed += string.charAt(iterator);
        }
        return stringReversed;
    }
}
