package ru.Dogs;

import ru.Animal;

public class Dog extends Animal {

    final private double maxRun = 500;
    final private double maxSwim = 10;
    final private double maxJump = 0.5;

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

    public Dog (String name, int eat, boolean hungry) {
        super(name, eat, hungry);
    }

    public Dog (String name, double run, double swim, double jump)
    {
        super(name, run, swim, jump);
    }

}
