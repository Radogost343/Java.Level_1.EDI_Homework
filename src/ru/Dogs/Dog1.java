package ru.Dogs;

import ru.Animal;

public class Dog1 extends Dog {
    int maxRun = 1000;
    int maxSwim = 20;
    double maxJump = 1.0;
    int maxEat = 40;

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

    public Dog1 (String name, int eat, boolean hungry) {
        super(name, eat, hungry);
    }

    public Dog1 (String name, int run, int swim, double jump)
    {
        super(name, run, swim, jump);
    }

}
