package machine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        CoffeeMachine machine = new CoffeeMachine(400, 540, 120, 9, 550);
        Scanner scanner = new Scanner(System.in);

        while (machine.isOn()){
            machine.execute(scanner.nextLine());
        }
    }
}
