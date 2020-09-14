package ru;

public class Dish {
    private int maxFood;
    private int foodInDish;

    protected Dish(int foodInDish, int maxFood) {
        this.foodInDish = foodInDish;
        this.maxFood = maxFood;
    }

    public int getFood() {
        return foodInDish;
    }

    public int getMaxFood() {
        return maxFood;
    }

    public void setFood(int animalEat) {
        foodInDish = animalEat;
    }

    public void setMaxFood(int maxFood) {
        this.maxFood = maxFood;
    }

    // пополнение миски едой
    protected void putToDish (int put) {
        if ((foodInDish + put) > maxFood) {
            foodInDish = maxFood;
        } else {
            foodInDish = getFood() + put;
        }
    }

    protected void dishInfo() {
        System.out.println("Остаток еды в миске: " + getFood());
    }

}

