package ru.Cats;

import ru.Animal;

public class Cat extends Animal {
    final private double maxRun = 200;
    final private double maxSwim = 5;
    final private double maxJump = 2.0;

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

    @Override
    protected void canSwim(double swim, double maxSwim) {
        System.out.print("Коты не плавают; ");
    }

    public Cat (String name, int eat, boolean hungry) {
        super(name, eat, hungry);
    }

    public Cat (String name, double run, double swim, double jump)
    {
        super(name, run, swim, jump);
    }
}
