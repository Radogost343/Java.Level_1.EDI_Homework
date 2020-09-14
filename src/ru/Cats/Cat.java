package ru.Cats;

import ru.Animal;

public class Cat extends Animal {
    private int maxRun = 200;
    private int maxSwim = 5;
    private double maxJump = 2.0;
    private int maxEat = 10;

    @Override
    public double getMaxJump() {
        return maxJump;
    }

    @Override
    public int getMaxEat() {
        return maxEat;
    }

    @Override
    public int getMaxRun() {
        return maxRun;
    }

    @Override
    public int getMaxSwim() {
        return maxSwim;
    }

    @Override
    protected boolean canSwim(int swim) {
        boolean res = false;
        System.out.print(this.name + " canSwim " + swim + " " + res + "; коты не плавают; ");
        return res;
    }

    public Cat (String name, int eat, boolean hungry) {
        super(name, eat, hungry);
    }

    public Cat (String name, int run, int swim, double jump)
    {
        super(name, run, swim, jump);
    }
}
