import java.util.Scanner;

public class Main {
    enum State {
        NORMAL, POWERED_UP, WEAKENED, INVISIBLE
    }

    static class Character {
        State characterState;

        Character() {
            characterState = State.NORMAL;
        }

        void selectState(int stateValue) {
            switch (stateValue){
                case 0:
                case 4:
                case 5:
                    characterState = State.NORMAL;
                    break;
                case 1:
                    characterState = State.POWERED_UP;
                    break;
                case 2:
                    characterState = State.WEAKENED;
                    break;
                case 3:
                    characterState = State.INVISIBLE;
                    break;
                default:
                    characterState = State.NORMAL;
            }
        }

        void printCharacterState() {
            System.out.println(characterState);
        }
    }

    public static void main(String[] args) {
        Character character = new Character();

        //You can use selectState method here to assign a state to your character instance.
        Scanner scanner = new Scanner(System.in);
        character.selectState(scanner.nextInt());
        character.printCharacterState();
    }
}
