import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lenght = Integer.parseInt(scanner.nextLine());
        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = scanner.nextInt();

        System.out.println(countOccurrencies(n, numbers));
    }

    private static int countOccurrencies(int n, int[] numbers) {
        int count = 0;
        for (int i = 0; i < numbers.length; i++){
            if (numbers[i] == n){
                count++;
            }
        }

        return count;
    }
}
