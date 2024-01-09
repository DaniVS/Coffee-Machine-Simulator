package machine;

public enum Action {
    BUY(5),
    FILL(6),
    TAKE(7),
    REMAINING(8),
    MAKE_ESPRESSO(1),
    MAKE_LATTE(2),
    MAKE_CAPPUCCINO(3),
    BACK(4),
    EXIT(0);

    int actionCode;

    Action(int actionCode){
        this.actionCode = actionCode;
    }
}
