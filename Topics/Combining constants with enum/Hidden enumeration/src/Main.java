public class Main {

    public static void main(String[] args) {
        int counter = 0;

        // write your code here
        for (Secret value : Secret.values()){
            if (value.name().matches("STAR(.*)")){
                counter++;
            }
        }

        System.out.println(counter);
    }
}

/* sample enum for inspiration
enum Secret {
    STAR, CRASH, START, // ...
}
*/
