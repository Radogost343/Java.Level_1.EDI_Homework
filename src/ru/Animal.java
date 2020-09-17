package ru;

public abstract class Animal {

    protected String name;
    protected double run;
    protected double swim;
    protected double jump;
    protected int eat;
    protected boolean hungry = true;

    private double maxRun;
    private double maxSwim;
    private double maxJump;

    protected Animal (String name, double run, double swim, double jump)
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

    public boolean isAvailableAction (double action, double maxAction) {
    return action <= maxAction;
    }

    protected void canRun(double run, double maxRun) {
        System.out.println(this.name + " canRun " + this.run + " " + isAvailableAction(this.run,getMaxRun()) + "; ");
    }

    protected void canSwim(double swim, double maxSwim) {
        System.out.println(this.name + " canSwim " + swim + " " + isAvailableAction(this.swim,getMaxSwim()) + "; ");

    }

    protected void canJump(double jump, double maxJump) {
        System.out.println(this.name + " canJump " + jump + " " + isAvailableAction(this.jump, getMaxJump()) + "; ");
    }

    protected void eatFromDish (Dish dish) {
        int eat = dish.getFood() - this.eat;
        if (eat >= 0){
            this.hungry = false;
            dish.decreaseFoodinDish(this.eat);
            System.out.println(this.name + " Покушал " + this.eat + " еды." + " Еды в миске: " + dish.getFood());
        } else {
            System.out.println(this.name + " пытается покушать " + this.eat + " еды. Недостаточно еды в миске: " + dish.getFood());
        }
    }

    protected void animalInfo() {
        System.out.println("Name: " + this.name + "; Run " + this.run + "; Swim "+ this.swim + "; Jump " + this.jump);
    }

    public double getMaxRun() {
        return maxRun;
    }

    public void setMaxRun(int maxRun) {
        this.maxRun = maxRun;
    }


    public double getMaxSwim() {
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

    public void setMaxEat(int maxEat) {
        this.eat = maxEat;
    }
}

