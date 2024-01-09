import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = getNumbersFromInput(scanner.nextLine().toCharArray());

        int sumOfFirstThree = numbers[0] + numbers[1] + numbers[2];
        int sumOfLastThree = numbers[5] + numbers[4] + numbers[3];

        if (sumOfFirstThree == sumOfLastThree){
            System.out.println("Lucky");
        } else {
            System.out.println("Regular");
        }
    }

    private static int[] getNumbersFromInput(char[] charArray) {
        int[] numbers = new int[charArray.length];

        for (int i=0; i<charArray.length; i++){
            numbers[i] = Character.getNumericValue(charArray[i]);
        }

        return numbers;
    }
}
