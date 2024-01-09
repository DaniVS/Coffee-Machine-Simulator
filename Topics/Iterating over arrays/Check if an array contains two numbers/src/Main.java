import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String theLength = scanner.nextLine();
        int lengthOfArray = new Scanner(theLength).nextInt();

        int[] numbers = initNumbers(lengthOfArray, scanner.nextLine());
        int[] checks = initNumbers(2, scanner.nextLine());

        int first = checks[0];
        int second = checks[1];

        for (int i = 0; i < numbers.length - 1; i++) {
            int actualCheck = numbers[i];
            int nextNumber = numbers[i + 1];

            if (consecutiveNumbers(actualCheck, first, nextNumber, second)) {
                System.out.println(true);
                return;
            }
        }

        System.out.println(false);
    }

    private static boolean consecutiveNumbers(int actualCheck, int first, int nextNumber, int second) {
        if (
                (isFirst(actualCheck, first) && isSecond(nextNumber, second)) ||
                        (isFirst(nextNumber, first) && isSecond(actualCheck, second))) {
            return true;
        }

        return false;
    }

    private static boolean isFirst(int actualCheck, int first) {
        return actualCheck == first;
    }

    private static boolean isSecond(int nextNumber, int second) {
        return nextNumber == second;
    }

    private static int[] initNumbers(int lengthOfArray, String inputs) {
        Scanner inputScanner = new Scanner(inputs);
        int[] result = new int[lengthOfArray];

        int idx = 0;
        while (inputScanner.hasNextInt()) {
            result[idx] = inputScanner.nextInt();
            idx++;
        }

        return result;
    }
}
