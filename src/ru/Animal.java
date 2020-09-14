package ru;

public abstract class Animal {

    protected String name;
    protected int run;
    protected int swim;
    protected double jump;
    protected int eat;
    protected boolean hungry = true;

    private int maxRun;
    private int maxSwim;
    private double maxJump;
    private int maxEat;

    protected Animal (String name, int run, int swim, double jump)
    {
        this.name = name;
        this.run = run;
        this.swim = swim;
        this.jump = jump;
    }

    protected Animal (String name, int eat, boolean hungry)
    {
        this.name = name;
        this.eat = eat;
        this.hungry = hungry;
    }

    protected boolean canRun(int run) {
        boolean res = true;
        if (run > getMaxRun()) {
            res = false;
        }
        System.out.println(this.name + " canRun " + run + " " + res + "; ");
        return res;
    }

    protected boolean canSwim(int swim) {
        boolean res = true;
        if (swim > getMaxSwim()) {
            res = false;
        }
        System.out.println(this.name + " canSwim " + swim + " " + res + "; ");
        return res;
    }

    protected boolean canJump(double jump) {
        boolean res = true;
        if (jump > getMaxJump()) {
            res = false;
        }
        System.out.println(this.name + " canJump " + jump + " " + res + "; ");
        return res;
    }

    protected boolean canEat(int eat) {
        boolean res = true;
        if (eat > getMaxEat()) {
            res = false;
        }
        System.out.println(this.name + " canEat " + eat + " " + res + "; ");
        return res;
    }

    protected void eatFromDish (Dish dish) {
        int catEat = dish.getFood() - this.eat;
        if (catEat >= 0){
            this.hungry = false;
            dish.setFood(catEat);
            System.out.println(this.name + " Покушал " + this.eat + " еды." + " Еды в миске: " + dish.getFood());
        } else {
            System.out.println(this.name + " пытается покушать " + this.eat + " еды. Недостаточно еды в миске: " + dish.getFood());
        }
    }

    protected void animalInfo() {
        System.out.println("Name: " + this.name + "; Run " + this.run + "; Swim "+ this.swim + "; Jump " + this.jump);
    }

    public int getMaxRun() {
        return maxRun;
    }

    public void setMaxRun(int maxRun) {
        this.maxRun = maxRun;
    }


    public int getMaxSwim() {
        return maxSwim;
    }

    public void setMaxSwim(int maxSwim) {
        this.maxSwim = maxSwim;
    }

    public double getMaxJump() {
        return maxJump;
    }

    public void setMaxJump(double maxJump) {
        this.maxJump = maxJump;
    }

    public int getMaxEat() {
        return maxEat;
    }

    public void setMaxEat(int maxEat) {
        this.maxEat = maxEat;
    }
}

