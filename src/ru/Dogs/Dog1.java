package ru.Dogs;

import ru.Animal;

public class Dog1 extends Animal {
    final private int maxRun = 1000;
    final private int maxSwim = 20;
    final private double maxJump = 1.0;

    @Override
    public double getMaxJump() {
        return maxJump;
    }

    @Override
    public int getMaxRun() {
        return maxRun;
    }

    @Override
    public int getMaxSwim() {
        return maxSwim;
    }

    public Dog1 (String name, int eat, boolean hungry) {
        super(name, eat, hungry);
    }

    public Dog1 (String name, int run, int swim, double jump)
    {
        super(name, run, swim, jump);
    }

}
