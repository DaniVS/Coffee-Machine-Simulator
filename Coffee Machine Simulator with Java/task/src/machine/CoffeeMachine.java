package machine;

public class CoffeeMachine {
    private int water;
    private int milk;
    private int coffeeBeans;
    private int availableCups;
    private int money;
    private boolean isOn;

    private MachineState machineState;

    public CoffeeMachine(int water, int milk, int coffeeBeans, int availableCups, int money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.availableCups = availableCups;
        this.money = money;
        turnOn();
        this.machineState = MachineState.WAIT_ACTION_CHOICE;
        System.out.println(this.machineState.message);
    }

    private void turnOn() {
        this.isOn = true;
    }

    private void turnOff() {
        this.isOn = false;
    }

    private void withdrawAll() {
        System.out.println("I gave you $" + getCurrentBalance());
        System.out.println();
        this.money = 0;
    }

    private int getCurrentBalance() {
        return this.money;
    }

    private void setMachineState(MachineState currentState) {
        this.machineState = currentState;
        System.out.println(this.machineState.message);
    }

    private static int commonDenominator(int waterRate, int milkRate, int beansRate) {
        int result = beansRate;

        if (waterRate <= beansRate && waterRate <= milkRate) {
            result = waterRate;
        } else if (milkRate <= waterRate && milkRate <= beansRate) {
            result = milkRate;
        } else if (beansRate <= waterRate && beansRate <= milkRate) {
            result = beansRate;
        }

        return result;
    }

    private void printMachineState() {
        System.out.println("The coffee machine has:");
        System.out.println(this.water + " ml of water");
        System.out.println(this.milk + " ml of milk");
        System.out.println(this.coffeeBeans + " g of coffee beans");
        System.out.println(this.availableCups + " disposable cups");
        System.out.println("$" + this.money + " of money");
        System.out.println();
    }

    public boolean isOn() {
        return isOn;
    }

    public void execute(String userInput) {
        switch (this.machineState) {
            case WAIT_ACTION_CHOICE:
                executeAction(userInput);
                break;
            case WAIT_PRODUCT_CHOICE:
                if (userInput.toUpperCase().equals(Action.BACK.name())){
                    goBack();
                } else {
                    prepareProduct(userInput);
                }

                break;

            case FILLING:
            case FILLING_WATER:
            case FILLING_MILK:
            case FILLING_COFFEE_BEANS:
            case FILLING_CUPS:
                fill(Integer.parseInt(userInput));
                break;
        }

        System.out.println();

    }

    private void prepareProduct(String userInput) {
        Product product = getChoosenProduct(userInput);


        if (product != null){
            int availableProducts = calculateProductAvailability(product);

            if (availableProducts > 0) {
                buy(product);
            } else {
                showWhatIsMissing(product);
            }

            setMachineState(MachineState.WAIT_ACTION_CHOICE);
        }
    }

    private void goBack() {
        setMachineState(MachineState.WAIT_ACTION_CHOICE);
    }

    private void executeAction(String userInput) {
        Action action = Action.valueOf(userInput.toUpperCase());
        switch (action) {
            case BUY:
                setMachineState(MachineState.WAIT_PRODUCT_CHOICE);
                break;
            case FILL:
                setMachineState(MachineState.FILLING_WATER);
                break;
            case TAKE:
                withdrawAll();
                setMachineState(MachineState.WAIT_ACTION_CHOICE);
                break;
            case REMAINING:
                printMachineState();
                setMachineState(MachineState.WAIT_ACTION_CHOICE);
                break;
            case EXIT:
                turnOff();
                break;
        }
    }

    private int calculateProductAvailability(Product requestedProduct) {
        int waterRate = this.water / requestedProduct.getWater();
        int milkRate = requestedProduct.equals(Product.ESPRESSO) ?
                Integer.MAX_VALUE :
                this.milk / requestedProduct.getMilk();
        int beansRate = this.coffeeBeans / requestedProduct.getBeans();

        return commonDenominator(waterRate, milkRate, beansRate);
    }

    private void buy(Product requestedProduct) {
        System.out.println("I have enough resources, making you a coffee!");
        System.out.println();

        this.water -= requestedProduct.getWater();
        this.milk -= requestedProduct.getMilk();
        this.coffeeBeans -= requestedProduct.getBeans();
        this.money += requestedProduct.getCost();
        this.availableCups--;
    }

    private void showWhatIsMissing(Product requestedProduct) {
        String missingIngredient = "";

        if (this.water / requestedProduct.getWater() == 0) {
            missingIngredient = "water";
        }

        if (this.milk / requestedProduct.getMilk() == 0) {
            missingIngredient = "milk";
        }

        if (this.coffeeBeans / requestedProduct.getBeans() == 0) {
            missingIngredient = "coffee";
        }

        if (this.availableCups == 0){
            missingIngredient = "cups";
        }

        System.out.println("Sorry, not enough " + missingIngredient + "!");
        System.out.println();
    }

    private Product getChoosenProduct(String userInput) {
        for (Product p : Product.values()) {
            if (p.getProductCode() == Integer.parseInt(userInput)) {
                return p;
            }
        }

        return null;
    }

    private void fill(int value) {
        switch (this.machineState){
            case FILLING_WATER:
                this.water += value;
                setMachineState(MachineState.FILLING_MILK);
                break;
            case FILLING_MILK:
                this.milk += value;
                setMachineState(MachineState.FILLING_COFFEE_BEANS);
                break;
            case FILLING_COFFEE_BEANS:
                this.coffeeBeans += value;
                setMachineState(MachineState.FILLING_CUPS);
                break;
            case FILLING_CUPS:
                this.availableCups += value;
                setMachineState(MachineState.WAIT_ACTION_CHOICE);
                break;
        }
    }
}
