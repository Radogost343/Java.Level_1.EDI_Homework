package ru.Cats;

import ru.Animal;

public class Cat1 extends Cat {
    final private int maxRun = 400;
    final private int maxSwim = 0;
    final private double maxJump = 4.0;
    final private int maxEat = 20;

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
        return super.canSwim(swim);
    }

    public Cat1 (String name, int eat, boolean hungry) {
        super(name, eat, hungry);
    }

    public Cat1 (String name, int run, int swim, double jump)
    {
        super(name, run, swim, jump);
    }

}
