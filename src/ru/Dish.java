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

    protected void decreaseFoodinDish (int AnimalEat) {
        foodInDish -= AnimalEat;
    }

    public void setMaxFood(int maxFood) {
        this.maxFood = maxFood;
    }

    public void setFoodInDish(int foodInDish) {
        this.foodInDish = foodInDish;
    }

    // пополнение миски едой
    protected void putToDish (int put) {
        if ((foodInDish + put) > maxFood) {
            foodInDish = maxFood;
        } else {
            foodInDish = getFood() + put;
        }
        System.out.println("Пополнение миски едой " + put);
    }

    protected void dishInfo() {
        System.out.println("Остаток еды в миске: " + getFood());
    }

}

