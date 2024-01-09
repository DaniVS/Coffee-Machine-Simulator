import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char[] numbers = {'0','1','2','3','4','5','6','7','8','9'};

        int upperCase = scanner.nextInt();
        int lowerCase = scanner.nextInt();
        int digits = scanner.nextInt();
        int theLength = scanner.nextInt();

        int filler = theLength - (upperCase + lowerCase + digits);

        String password = "";

        int letterIndex = 0;
        while (upperCase > 0){
            password += String.valueOf(alphabet[letterIndex]).toUpperCase();
            upperCase--;
            letterIndex = preventOutOfBoundIndex(letterIndex, alphabet.length);
        }

        while (lowerCase > 0){
            password += String.valueOf(alphabet[letterIndex]);
            lowerCase--;
            letterIndex = preventOutOfBoundIndex(letterIndex, alphabet.length);
        }

        int numberIndex = 0;
        while (digits > 0){
            password += String.valueOf(numbers[numberIndex]);
            digits--;
            numberIndex = preventOutOfBoundIndex(numberIndex, numbers.length);
        }

        while (filler > 0){
            password += String.valueOf(alphabet[letterIndex]);
            filler--;
            letterIndex = preventOutOfBoundIndex(letterIndex, alphabet.length);
        }

        System.out.println(password);
    }

    private static int preventOutOfBoundIndex(int lastUsedIndex, int length) {
        if (lastUsedIndex >= (length - 1)) {
            return 0;
        }

        return ++lastUsedIndex;
    }
}
