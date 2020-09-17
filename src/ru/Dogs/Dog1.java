package ru.Dogs;

import ru.Animal;

public class Dog1 extends Animal {
    final private double maxRun = 1000;
    final private double maxSwim = 20;
    final private double maxJump = 1.0;

    @Override
    public double getMaxJump() {
        return maxJump;
    }

    @Override
    public double getMaxRun() {
        return maxRun;
    }

    @Override
    public double getMaxSwim() {
        return maxSwim;
    }

    public Dog1 (String name, int eat, boolean hungry) {
        super(name, eat, hungry);
    }

    public Dog1 (String name, double run, double swim, double jump)
    {
        super(name, run, swim, jump);
    }

}
