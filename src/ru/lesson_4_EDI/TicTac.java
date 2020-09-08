package ru.lesson_4_EDI;

import java.util.Scanner;

/*
    Домашнее задание
    Полностью разобраться с кодом, попробовать переписать с нуля;
    * Усовершенствовать метод проверки победы;
    * Расширить поле до 5х5 и в качестве условий победы установить серию равной 4.
    ** Проработать искусственный интеллект, чтобы он мог блокировать ходы игрока.
*/

public class TicTac {
        final static int SIZE = 5;
        final static char [][] map = new char[SIZE][SIZE];
        final static char emptySymbol = '*';
        final static char playerSymbol = 'Х';
        final static char computerSymbol = 'O';
        static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
           do {
               startGame();
           } while (isTryAgain());
        }

    private static void startGame()
    {
        initMap();
        printMap();

        while (true) {
            iqAiTurn();
            //playerTurn();
            printMap();

            if (isMapFull())
            {
                System.out.println("Поле заполненно.");
                break;
            }

            if (isCheckWin(computerSymbol))
            {
                break;
            }

            playerTurn();
            //iqAiTurn();
            printMap();

            if (isMapFull())
            {
                System.out.println("Поле заполненно.");
                break;
            }

            if (isCheckWin(playerSymbol))
            {
                break;
            }
        }
    }

    private static int getNumberFromConsole() {
        do
        {
            if (scanner.hasNextInt())
            {
                return scanner.nextInt();
            }
            System.out.println("Некорректный ввод");
            scanner.nextLine();
        } while (true);
    }

    private static boolean isTryAgain() {
        boolean res;
        System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
        switch (userInput(0,1))
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
                scanner.nextLine();
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

    private static void iqAiTurn()
    {
            int x = map.length/2;
            int y = map.length/2;
            int maxScoreCell  = 0;
            for (int i = 0; i < map.length; i++)
            {
                for (int k = 0; k < map.length; k++)
                {
                    if (map[i][k] == emptySymbol)
                    {
                        int temp = checkCellsAround(i, k);
                        if (temp > maxScoreCell)
                        {
                            maxScoreCell = temp;
                            x = i;
                            y = k;
                        }
                    }
                }
            }
            /*
            if (maxScoreCell > 0) {
                System.out.println("Компьютер пошел на клетку: " + (y + 1) + " " + (x + 1));
                map[x][y] = computerSymbol;
            }
            if (maxScoreCell == 0) {
                randomComputerTurn();
            }
             */
        System.out.println("Компьютер пошел на клетку: " + (y + 1) + " " + (x + 1));
        map[x][y] = computerSymbol;
    }


    private static void randomComputerTurn() {
        int x = -1, y = -1;
        do
            {
                x = (int) (Math.random() * SIZE);
                y = (int) (Math.random() * SIZE);
        } while (isCellValid(y, x));
        System.out.println("Компьютер пошел на клетку: " + (x + 1) + " " + (y + 1));
        map[y][x] = computerSymbol;
    }


    private static boolean isMapFull() {
            boolean res = false;
            for (int i = 0; i < (map.length * map.length); i++)
            {
                int x = i / map.length;
                int y = i % map.length;
                    if (map[x][y] == emptySymbol) {
                        res = true;
                        break;
                    }
                if (res)
                {
                    break;
                }
            }
            return !res;
    }

    private static boolean isCheckWin(char symbol) {
            boolean result = false;
            for (int i = 0; i < map.length; i++)
            {
                for (int k = 0; k < map.length; k++)
                {
                    if (
                            isCellExists(i + 3, k + 3) && (map [i][k] == symbol && map [i+1][k+1] == symbol && map [i+2][k+2] == symbol && map[i+3][k+3] == symbol) ||
                                    isCellExists(i, k + 3) && (map [i][k] == symbol && map [i][k+1] == symbol && map [i][k+2] == symbol && map[i][k+3] == symbol) ||
                                    isCellExists(i + 3, k) && (map [i][k] == symbol && map [i+1][k] == symbol && map [i+2][k] == symbol && map[i+3][k] == symbol) ||
                                    isCellExists(i + 3, k - 3) && (map [i][k] == symbol && map [i+1][k-1] == symbol && map [i+2][k-2] == symbol && map[i+3][k-3] == symbol)
                    )
                    {
                        result = true;
                        System.out.println("Выиграли: " + symbol);
                    }
                    if (result)
                    {
                        break;
                    }
                }
                if (result)
                {
                    break;
                }
            }
            return result;
        }


        private static void printMap() {
            System.out.print("0" + "|");
            for (int j = 0; j < map.length;j++)
            {
                System.out.print(j + 1 + "|");
            }
            System.out.println();
            for (int i = 0; i < map.length; i++)
            {
                System.out.print(i + 1 + "|");
                for (int k = 0; k < map.length; k++)
                {
                    System.out.print(map[i][k] + "|");
                }
                System.out.println();
            }
        }


        private static void playerTurn() {
            int x = - 1, y = -1;
            System.out.println("Введите через пробел координаты X и Y");
            do {
                if (scanner.hasNextInt()) {
                    x = userInput(0, map.length) - 1;
                    y = userInput(0, map.length) - 1;
                }
                else {
                    System.out.println("Повторите ввод");
                    scanner.nextLine();
                }

            } while (isCellValid(x, y));

            map[y][x] = playerSymbol;

        }

    private static boolean isCellExists(int i, int k) {
        boolean result = true;
        if (i < 0 || k < 0 || i >= map.length || k >= map.length)
        {
            result = false;
        }
        return result;
    }

        private static boolean isCellValid(int x, int y)
        {
            boolean res = false;
            if (isCellExists(y, x) && map[y][x] == emptySymbol)
            {
                res = true;
            }

            if (isCellExists(y, x) && map[y][x] != emptySymbol)
            {
                res = false;
                System.out.println("Клетка " + map[y][x] + " занята");
            }

            if (!isCellExists(y, x))
            {
                res = false;
                System.out.println("Вы вышли за пределы поля");
            }

            return !res;
        }

        private static void initMap() {
            for (int i = 0; i < (map.length * map.length); i++)
            {
                int x = i / map.length;
                int y = i % map.length;
                map[x][y] = emptySymbol;
            }
        }

    private static int checkCellsAround(int i, int k)
    {
        int scoreCell = 0;

        if (isCellExists(i,k - 1) && map [i][k - 1] == playerSymbol)
        {
            scoreCell++;
            scoreCell++;
        }

        if (isCellExists(i,k + 1) && map [i][k + 1] == playerSymbol)
        {
            scoreCell++;
            scoreCell++;
        }
        if (isCellExists(i - 1,k) && map [i - 1][k] == playerSymbol)
        {
            scoreCell++;
            scoreCell++;
        }
        if (isCellExists(i + 1,k) && map [i + 1][k] == playerSymbol)
        {
            scoreCell++;
            scoreCell++;
        }
        if (isCellExists(i - 1,k - 1) && map [i - 1][k - 1] == playerSymbol)
        {
            scoreCell++;
            scoreCell++;
        }
        if (isCellExists(i - 1,k + 1) && map [i - 1][k + 1] == playerSymbol)
        {
            scoreCell++;
            scoreCell++;
        }
        if (isCellExists(i + 1,k - 1) && map [i + 1][k - 1] == playerSymbol)
        {
            scoreCell++;
            scoreCell++;
        }
        if (isCellExists(i + 1,k + 1) && map [i + 1][k + 1] == playerSymbol)
        {
            scoreCell++;
            scoreCell++;
        }
        if (isCellExists(i,k - 1) && map [i][k - 1] == computerSymbol)
        {
            scoreCell++;
        }
        if (isCellExists(i,k + 1) && map [i][k + 1] == computerSymbol)
        {
            scoreCell++;
        }
        if (isCellExists(i - 1,k) && map [i - 1][k] == computerSymbol)
        {
            scoreCell++;
        }
        if (isCellExists(i + 1,k) && map [i + 1][k] == computerSymbol)
        {
            scoreCell++;
        }
        if (isCellExists(i - 1,k - 1) && map [i - 1][k - 1] == computerSymbol)
        {
            scoreCell++;
        }
        if (isCellExists(i - 1,k + 1) && map [i - 1][k + 1] == computerSymbol)
        {
            scoreCell++;
        }
        if (isCellExists(i + 1,k - 1) && map [i + 1][k - 1] == computerSymbol)
        {
            scoreCell++;
        }
        if (isCellExists(i + 1,k + 1) && map [i + 1][k + 1] == computerSymbol)
        {
            scoreCell++;
        }

        if (isCellExists(i + 2, k + 2) && (map [i+1][k+1] == playerSymbol && map [i+2][k+2] == playerSymbol))
        {
            scoreCell += 50;
        }

        if (isCellExists(i,k+2) && (map [i][k+1] == playerSymbol && map [i][k+2] == playerSymbol))
        {
            scoreCell += 50;
        }

        if (isCellExists(i+2,k) && (map [i+1][k] == playerSymbol && map [i+2][k] == playerSymbol))
        {
            scoreCell += 50;
        }

        if (isCellExists(i + 2,k - 2) && (map [i + 1][k - 1] == playerSymbol && map [i + 2][k - 2] == playerSymbol))
        {
            scoreCell += 50;
        }

        if (isCellExists(i - 2,k + 2) && (map [i - 1][k + 1] == playerSymbol && map [i - 2][k + 2] == playerSymbol))
        {
            scoreCell += 50;
        }

        if (isCellExists(i,k - 2) && (map [i][k - 1] == playerSymbol && map [i][k - 2] == playerSymbol))
        {
            scoreCell += 50;
        }

        if (isCellExists(i - 2,k) && (map [i - 1][k] == playerSymbol && map [i - 2][k] == playerSymbol))
        {
            scoreCell += 50;
        }

        if (isCellExists(i - 2,k - 2) && (map [i - 1][k - 1] == playerSymbol && map [i - 2][k - 2] == playerSymbol))
        {
            scoreCell += 50;
        }

        if (isCellExists(i,k - 1) && isCellExists(i,k + 1) && (map [i][k - 1] == playerSymbol && map [i][k + 1] == playerSymbol))
        {
            scoreCell += 80;
        }

        if (isCellExists(i + 1,k) && isCellExists(i - 1,k) && (map [i + 1][k] == playerSymbol && map [i - 1][k] == playerSymbol))
        {
            scoreCell += 80;
        }

        if (isCellExists(i + 1,k - 1) && isCellExists(i - 1,k + 1) && (map [i + 1][k - 1] == playerSymbol && map [i - 1][k + 1] == playerSymbol))
        {
            scoreCell += 80;
        }

        if (isCellExists(i - 1,k - 1) && isCellExists(i + 1,k + 1) && (map [i - 1][k - 1] == playerSymbol && map [i + 1][k + 1] == playerSymbol))
        {
            scoreCell += 80;
        }

        if (isCellExists(i + 3, k + 3) && (map [i+1][k+1] == playerSymbol && map [i+2][k+2] == playerSymbol && map[i+3][k+3] == playerSymbol))
        {
            scoreCell += 100;
        }

        if (isCellExists(i,k+3) && (map [i][k+1] == playerSymbol && map [i][k+2] == playerSymbol && map[i][k+3] == playerSymbol))
        {
            scoreCell += 100;
        }

        if (isCellExists(i+3,k) && (map [i+1][k] == playerSymbol && map [i+2][k] == playerSymbol && map[i+3][k] == playerSymbol))
        {
            scoreCell += 100;
        }

        if (isCellExists(i-3,k+3) && (map [i-1][k+1] == playerSymbol && map [i-2][k+2] == playerSymbol && map[i-3][k+3] == playerSymbol))
        {
            scoreCell += 100;
        }

        if (isCellExists(i + 3,k - 3) && (map [i + 1][k - 1] == playerSymbol && map [i + 2][k - 2] == playerSymbol && map[i + 3][k - 3] == playerSymbol))
        {
            scoreCell += 100;
        }

        if (isCellExists(i - 3,k) && (map [i - 1][k] == playerSymbol && map [i - 2][k] == playerSymbol && map[i - 3][k] == playerSymbol))
        {
            scoreCell += 100;
        }

        if (isCellExists(i,k - 3) && (map [i][k - 1] == playerSymbol && map [i][k - 2] == playerSymbol && map[i][k - 3] == playerSymbol))
        {
            scoreCell += 100;
        }

        if (isCellExists(i + 2, k + 2) && (map [i+1][k+1] == computerSymbol && map [i+2][k+2] == computerSymbol))
        {
            scoreCell += 75;
        }


        if (isCellExists(i,k+2) && (map [i][k+1] == computerSymbol && map [i][k+2] == computerSymbol))
        {
            scoreCell += 75;
        }

        if (isCellExists(i+2,k) && (map [i+1][k] == computerSymbol && map [i+2][k] == computerSymbol))
        {
            scoreCell += 75;
        }

        if (isCellExists(i + 2,k - 2) && (map [i + 1][k - 1] == computerSymbol && map [i + 2][k - 2] == computerSymbol))
        {
            scoreCell += 75;
        }

        if (isCellExists(i + 3, k + 3) && (map [i+1][k+1] == computerSymbol && map [i+2][k+2] == computerSymbol && map[i+3][k+3] == computerSymbol))
        {
            scoreCell += 200;
        }

        if (isCellExists(i - 3, k + 3) && (map [i-1][k+1] == computerSymbol && map [i-2][k+2] == computerSymbol && map[i-3][k+3] == computerSymbol))
        {
            scoreCell += 200;
        }

        if (isCellExists(i - 3, k - 3) && (map [i-1][k-1] == computerSymbol && map [i-2][k-2] == computerSymbol && map[i-3][k-3] == computerSymbol))
        {
            scoreCell += 200;
        }

        if (isCellExists(i,k+3) && (map [i][k+1] == computerSymbol && map [i][k+2] == computerSymbol && map[i][k+3] == computerSymbol))
        {
            scoreCell += 200;
        }

        if (isCellExists(i+3,k) && (map [i+1][k] == computerSymbol && map [i+2][k] == computerSymbol && map[i+3][k] == computerSymbol))
        {
            scoreCell += 200;
        }

        if (isCellExists(i-3,k) && (map [i-1][k] == computerSymbol && map [i-2][k] == computerSymbol && map[i-3][k] == computerSymbol))
        {
            scoreCell += 200;
        }

        if (isCellExists(i,k-3) && (map [i][k-1] == computerSymbol && map [i][k-2] == computerSymbol && map[i][k-3] == computerSymbol))
        {
            scoreCell += 200;
        }

        if (isCellExists(i + 3,k - 3) && (map [i + 1][k - 1] == computerSymbol && map [i + 2][k - 2] == computerSymbol && map[i + 3][k - 3] == computerSymbol))
        {
            scoreCell += 200;
        }

        if (isCellExists(i,k - 1) && isCellExists(i,k + 1) && (map [i][k - 1] == computerSymbol && map [i][k + 1] == computerSymbol))
        {
            scoreCell += 71;
        }

        if (isCellExists(i + 1,k) && isCellExists(i - 1,k) && (map [i + 1][k] == computerSymbol && map [i - 1][k] == computerSymbol))
        {
            scoreCell += 71;
        }

        if (isCellExists(i + 1,k - 1) && isCellExists(i - 1,k + 1) && (map [i + 1][k - 1] == computerSymbol && map [i - 1][k + 1] == computerSymbol))
        {
            scoreCell += 71;
        }

        if (isCellExists(i - 1,k - 1) && isCellExists(i + 1,k + 1) && (map [i - 1][k - 1] == computerSymbol && map [i + 1][k + 1] == computerSymbol))
        {
            scoreCell += 71;
        }

        return scoreCell;
    }
    }


