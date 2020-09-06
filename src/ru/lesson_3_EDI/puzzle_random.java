package ru.lesson_3_EDI;
import java.util.*;

/*
Домашнее задание
        Написать программу, которая загадывает случайное число от 0 до 9
        и пользователю дается 3 попытки угадать это число.
        При каждой попытке компьютер должен сообщить,
        больше ли указанное пользователем число, чем загаданное, или меньше.
        После победы или проигрыша выводится запрос – «Повторить игру еще раз?
        1 – да / 0 – нет»
        (1 – повторить, 0 – нет).
*/


public class puzzle_random {
    private static Scanner scanner = new Scanner(System.in);
    final static int startData = 0;
    final static int stopData = 9;
    final static int startNumberOfTry = 3;

    public static void main(String[] args)
    {
        do
        {
            isStartGame(guessNumber());
        } while (isTryAgain());
    }

    //Старт игры
    private static boolean isStartGame(int answer) {
        boolean res = false;
        for (int i = 0; i < startNumberOfTry; i++) {
            if (isCheckUserInput(answer, userInput(startData, stopData))) {
                System.out.println("Вы победили!!! загаданное число: " + answer);
                i = startNumberOfTry;
                res = true;
            }
        }
        return res;
    }

    //повтор игры
    private static boolean isTryAgain() {
        boolean res;
        System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
        switch (userInput(startData,1))
        {
            case 0:
            {
                System.out.println("Пока!");
                res = false;
                break;
            }
            default:
            {
                System.out.println("Начнем!");
                res = true;
                break;
            }
        }
        return res;
    }

    //проверка ответа пользователя
    private static boolean isCheckUserInput(int answer, int userAnswer)
    {
        boolean res;
            if (userAnswer == answer)
            {
                res = true;
            }
            else if (answer > userAnswer)
            {
                res = false;
                System.out.println("Загаданное число > " + userAnswer);
            }
            else
            {
                res = false;
                System.out.println("Загаданное число < " + userAnswer);
            }
            return res;
    }

    //компьютер загадывает число от 0 до 9 включительно
    private static int guessNumber()
    {
        int number = (int) (Math.random() * 10);
        return number;
    }

    //ввод данных типа int пользователем
    private static int userInput(int startData, int stopData)
    {
        int num = -1;
        do
        {
        System.out.println("Введите число от " + startData + " до " + stopData + " :");
        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
        } else {
            System.out.println("Повторите ввод");
            scanner.next();
        }
        } while (!isValid(num,startData,stopData));
        return num;
    }

    //проверка значений в пределах пользовательского ввода
    private static boolean isValid(int num, int startData, int stopData)
    {
        boolean res = false;
        if ((num >= startData) && (num <= stopData))
        {
            res = true;
        }
        else {System.out.println("Введено некорректное значение"); }
        return res;
    }
}
