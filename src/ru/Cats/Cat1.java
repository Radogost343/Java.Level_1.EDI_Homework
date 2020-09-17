package ru.Cats;

import ru.Animal;

public class Cat1 extends Animal {
    final private double maxRun = 400;
    final private double maxSwim = 0;
    final private double maxJump = 4.0;


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

    public Cat1 (String name, int eat, boolean hungry) {
        super(name, eat, hungry);
    }

    public Cat1 (String name, double run, double swim, double jump)
    {
        super(name, run, swim, jump);
    }

}
