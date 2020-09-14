package ru;

import ru.Cats.Cat;
import ru.Cats.Cat1;
import ru.Dogs.Dog;
import ru.Dogs.Dog1;

public class Lesson_6_EDI {

    public static void main(String[] args) {
        animalArrInfo();
        Dish dish = new Dish(20, 50);
        dish.dishInfo();
        animalEatFromDish(dish);
    }

    public static Animal[] animalArr() {
        Animal [] animalsArray = new Animal[4];
        animalsArray[0] = new Cat("Клеопатра_Cat", 150,1,2.0);
        animalsArray[1] = new Dog("Серко_Dog",200,3,3.0);
        animalsArray[2]= new Cat1("Кокос_Cat1", 300,2,5.0);
        animalsArray[3]= new Dog1("Хатико_Dog1", 600,10,1.0);
        return animalsArray;
    }

    public static void animalArrInfo() {
        for (Animal animal : animalArr()) {
            animal.animalInfo();
            animal.canRun(animal.run);
            System.out.print("maxRun = " + animal.getMaxRun() + ";");
            System.out.println();
            animal.canSwim(animal.swim);
            System.out.print("maxSwim = " + animal.getMaxSwim() + ";");
            System.out.println();
            animal.canJump(animal.jump);
            System.out.print("maxJump = " + animal.getMaxJump() + ";");
            System.out.println();
            System.out.println();
        }
    }

    public static Animal[] animalEatArr() {
        Animal [] animalsEat = new Animal[5];
        animalsEat[0] = new Cat("cat", 5, true);
        animalsEat[1] = new Dog("dog", 10, true);
        animalsEat[2] = new Cat1("cat1", 15, true);
        animalsEat[3] = new Dog1("dog1", 20, true);
        animalsEat[4] = new Cat("Kokos", 25, true);
        return animalsEat;
    }

    public static void animalEatFromDish(Dish dish) {
        for (Animal animal : animalEatArr()) {
            animal.eatFromDish(dish);
        }

        for (Animal animal : animalEatArr()) {
            if (animal.hungry) {
                System.out.println("Кормим животных оставшихся голодными: ");
                animal.eatFromDish(dish);
            }

            if (!animal.hungry) {
                System.out.println(animal.name + " голодный");
            }
        }
    }

}

