package machine;

public enum Product {
    ESPRESSO(1,250, 0, 16, 4),
    LATTE(2,350, 75, 20, 7),
    CAPPUCCINO(3,200, 100, 12, 6);

    Product(int productCode, int water, int milk, int beans, int cost){
        this.productCode = productCode;
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cost = cost;
    }

    private int productCode;
    private int water;
    private int milk;
    private int beans;
    private int cost;


    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getBeans() {
        return beans;
    }

    public int getCost() {
        return cost;
    }

    public int getProductCode() {
        return productCode;
    }
}
