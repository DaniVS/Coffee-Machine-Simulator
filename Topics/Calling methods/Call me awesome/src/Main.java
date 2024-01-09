import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        char ch = 'e';
        ch -= 'a';
        ch++;
        ch += 'b';
        System.out.println(ch);
        callMeAwesome();
    }

    // Do not change code below
    public static void callMeAwesome() {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println(name + ", you're awesome!");
    }
}
