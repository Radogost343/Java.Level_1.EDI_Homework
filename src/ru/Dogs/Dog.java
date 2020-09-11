package ru.Dogs;

import ru.Animal;

public class Dog extends Animal {

    int maxRun = 500;
    int maxSwim = 10;
    double maxJump = 0.5;
    int maxEat = 20;

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

    public Dog (String name, int eat, boolean hungry) {
        super(name, eat, hungry);
    }

    public Dog (String name, int run, int swim, double jump)
    {
        super(name, run, swim, jump);
    }

}
