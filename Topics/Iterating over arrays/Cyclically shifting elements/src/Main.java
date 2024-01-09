import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalElements = scanner.nextInt();

        int[] result = new int[totalElements];

        for (int i = 0; i < totalElements; i++) {
            result[i] = scanner.nextInt();
        }

        int[] shifted = new int[totalElements];
        shifted[0] = result[result.length - 1];
        System.out.print(shifted[0] + " ");

        for (int i = 1; i < totalElements; i++) {
            shifted[i] = result[i-1];
            System.out.print(shifted[i] + " ");
        }
    }
}
