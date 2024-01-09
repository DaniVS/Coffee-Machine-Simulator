package machine;

public enum MachineState {
    WAIT_ACTION_CHOICE("Write action (buy, fill, take, remaining, exit):"),
    WAIT_PRODUCT_CHOICE("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:"),

    FILLING(""),
    FILLING_WATER("Write how many ml of water you want to add:"),
    FILLING_MILK("Write how many ml of milk you want to add:"),
    FILLING_COFFEE_BEANS("Write how many grams of coffee beans you want to add:"),
    FILLING_CUPS("Write how many disposable cups you want to add:");

    String message;

    MachineState(String message) {
        this.message = message;
    }
}
