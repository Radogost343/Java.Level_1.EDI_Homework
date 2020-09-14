package ru;

import ru.Cats.Cat;
import ru.Cats.Cat1;
import ru.Dogs.Dog;
import ru.Dogs.Dog1;

//        1. Создать классы Собака и Кот с наследованием от класса Животное.
//        2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
//        В качестве параметра каждому методу передается величина, означающая или длину препятствия (для бега и плавания), или высоту (для прыжков).
//        3. У каждого животного есть ограничения на действия
//        (бег: кот 200 м., собака 500 м.; прыжок: кот 2 м., собака 0.5 м.; плавание: кот не умеет плавать, собака 10 м.).
//        4. При попытке животного выполнить одно из этих действий,
//        оно должно сообщить результат в консоль. (Например, dog1.run(150); -> результат: run: true)
//        5. * Добавить животным разброс в ограничениях.
//        То есть у одной собаки ограничение на бег может быть 400 м., у другой 600 м.

public class Lesson_6_EDI {

    public static void main(String[] args) {
        animalArrInfo(animalArr());
        animalEatFromDish(addDish(20,50));
    }

    public static Animal[] animalArr() {
        Animal [] animalsArray = new Animal[4];
        animalsArray[0] = new Cat("Кот Леопольд", 150,1,2.0);
        animalsArray[1] = new Dog("Хатико",200,3,3.0);
        animalsArray[2]= new Cat1("Кокос the Cat", 300,2,5.0);
        animalsArray[3]= new Dog1("белый Бим черное ухо", 600,10,1.0);
        return animalsArray;
    }

    public static void animalArrInfo(Animal [] animalArr) {
        for (Animal animal : animalArr) {
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
        animalsEat[0] = new Cat("Кот Леопольд", 5, true);
        animalsEat[1] = new Dog("Хатико", 10, true);
        animalsEat[2] = new Cat1("Кот в сапогах", 15, true);
        animalsEat[3] = new Dog1("белый Бим черное ухо", 20, true);
        animalsEat[4] = new Cat("Кокос the Cat", 25, true);
        return animalsEat;
    }

    public static void animalEatFromDish(Dish dish) {
        for (Animal animal : animalEatArr()) {
            animal.eatFromDish(dish);
            if (animal.hungry) {
                dish.putToDish(animal.eat * 2);
                animal.eatFromDish(dish);
            }
            if (!animal.hungry) {
                System.out.println(animal.name + " сыт!");
            }
        }
    }

    public static Dish addDish(int food, int maxFood) {
        Dish dish = new Dish(food,maxFood);
        dish.dishInfo();
        return dish;
    }

}

