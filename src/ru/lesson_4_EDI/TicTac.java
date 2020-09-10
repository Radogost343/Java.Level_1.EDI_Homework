package ru.lesson_4_EDI;
import java.util.Random;
import java.util.Scanner;

/*
    Домашнее задание
    Полностью разобраться с кодом, попробовать переписать с нуля;
    * Усовершенствовать метод проверки победы;
    * Расширить поле до 5х5 и в качестве условий победы установить серию равной 4.
    ** Проработать искусственный интеллект, чтобы он мог блокировать ходы игрока.
*/

public class TicTac {
        static int SIZE;
        static char [][] map;
        final static char emptySymbol = '*';
        static char playerSymbol;
        static char computerSymbol;
        final static Scanner scanner = new Scanner(System.in);
        static int winnerLine;

        public static void main(String[] args) {
           System.out.println("Добро пожаловать в игру X и O.");
            do {
               SIZE = selectMapSIZE();
               map = new char[SIZE][SIZE];
               winnerLine = selectNumberOfWinnerLine();
               selectYourChar();
               startGame();
           } while (isTryAgain());
        }

    private static int selectMapSIZE() {
            System.out.println("Установите размер игрового поля: ");
            return userInput(3,30);
    }

    private static int selectNumberOfWinnerLine() {
        System.out.println("Установите количество выигрышных символов: ");
        return userInput(3,5);
    }

    private static void selectYourChar() {
                System.out.println("Выберите символ для игры: x или o");
                switch (scanner.next()) {
                    case "o":
                    case "O":
                        playerSymbol = 'o';
                        computerSymbol = 'x';
                        break;
                    case "x":
                    case "X":
                        playerSymbol = 'x';
                        computerSymbol = 'o';
                        break;
                    default:
                        System.out.println("Некорректный ввод");
                        selectYourChar();
                }
    }

    private static void startGame()
    {
        initMap();
        printMap();

        while (true) {

            iqAiTurn();
            //playerTurn();
            //randomComputerTurn();

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
            //randomComputerTurn();

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

    // не используется метод. Получение числа инт от пользователя.
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

    //метод повтора игры
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

    //получение числа инт от пользователя в пределах от ... до ...
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

    //проверка значений в пределах пользовательского ввода от ... и до ...
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

    // Ход Умного компьютера
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
            //ПО УМОЛЧАНИЯ ХОДИМ В СЕРЕДИНУ МАССИВА, если раскоментить этот код то будет Random первый ход.
            if (maxScoreCell > 0) {
                System.out.println("Компьютер пошел на клетку: " + (y + 1) + " " + (x + 1));
                map[x][y] = computerSymbol;
            }
            if (maxScoreCell == 0) {
                randomComputerTurn();
            }
            */

        // ЗАКОМЕНТЬ НИЖЕ ЕСЛИ ХОЧЕШЬ ПЕРВЫЙ ХОД РАНДОМ и РАСКОМЕНТЬ ВЫШЕ!!!
        System.out.println("Компьютер пошел на клетку: " + (y + 1) + " " + (x + 1)); // если раскоментил код выше не забудь закоментить этот код, иначе будет два хода компа.
        map[x][y] = computerSymbol; // если раскоментил код выше не забудь закоментить этот код, иначе будет два хода компа.
    }

    //генерация рандомного хода компьютера
    private static void randomComputerTurn() {
        int x = -1, y = -1;
        Random random = new Random();
        do
            {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
        } while (!isCellValid(y, x));
        System.out.println("Компьютер пошел на клетку: " + (x + 1) + " " + (y + 1));
        map[y][x] = computerSymbol;
    }

    //проверка заполненности поля
    private static boolean isMapFull() {
            boolean res = true;
            for (int i = 0; i < (map.length * map.length); i++)
            {
                int x = i / map.length;
                int y = i % map.length;
                    if (map[x][y] == emptySymbol) {
                        res = false;
                        break;
                    }
                    if (!res) break;
            }
            return res;
    }

    //проверка победы
    private static boolean isCheckWin(char symbol) {
            boolean result = false;


            for (int i = 0; i < map.length; i++)
            {
                int diagonal1 = 0, diagonal2 = 0, horizontal = 0, vertical = 0;
                for (int k = 0, z = i; k < map.length; k++, z++)
                {
                    if (isCellExists(k,z) && map[k][z] == symbol) {
                        diagonal1 += 1;
                    } else {
                        diagonal1 = 0;
                    }

                    if (isCellExists(k, map.length - 1 -z) && map[k][map.length - 1 - z] == symbol) {
                        diagonal2 += 1;
                    } else {
                        diagonal2 = 0;
                    }

                    if (diagonal1 == winnerLine || diagonal2 == winnerLine)
                    {
                        result = true;
                        System.out.println("Выиграли: " + symbol + " по диагонали!");
                        break;
                    }

                    for (int j = 0; j < map.length; j++) {
                        if (map[i][j] == symbol) {
                            horizontal += 1;
                        } else {
                            horizontal = 0;
                        }

                        if (horizontal == winnerLine) {
                            result = true;
                            System.out.println("Выиграли: " + symbol + " по горизонтали!");
                            break;
                        }

                        if (map[j][i] == symbol) {
                            vertical += 1;
                        } else {
                            vertical = 0;
                        }
                        if (vertical == winnerLine) {
                            result = true;
                            System.out.println("Выиграли: " + symbol + " по вертикали!");
                            break;
                        }
                    }
                }
            }
                        /*
                        if (

                                isCellExists(i + 3, k + 3) && (map[i][k] == symbol && map[i + 1][k + 1] == symbol && map[i + 2][k + 2] == symbol && map[i + 3][k + 3] == symbol) ||
                                        isCellExists(i, k + 3) && (map[i][k] == symbol && map[i][k + 1] == symbol && map[i][k + 2] == symbol && map[i][k + 3] == symbol) ||
                                        isCellExists(i + 3, k) && (map[i][k] == symbol && map[i + 1][k] == symbol && map[i + 2][k] == symbol && map[i + 3][k] == symbol) ||
                                        isCellExists(i + 3, k - 3) && (map[i][k] == symbol && map[i + 1][k - 1] == symbol && map[i + 2][k - 2] == symbol && map[i + 3][k - 3] == symbol)
                        ) {
                            result = true;
                            System.out.println("Выиграли: " + symbol);
                        }

                         */
                    return result;
                    }


        //вывод карты в консоль
        private static void printMap()
        {
            //печать шапки массива для пользователя
            System.out.print("0" + "|");
            for (int j = 0; j < map.length;j++)
            {
                System.out.print(j + 1 + "|");
            }
            System.out.println();

            //печать самого массива
            for (int i = 0; i < map.length; i++)
            {
                //печать левого поля для пользователя в первом цикле for
                System.out.print(i + 1 + "|");
                for (int k = 0; k < map.length; k++)
                {
                    System.out.print(map[i][k] + "|");
                }
                System.out.println();
            }
        }

        // ход человека
        private static void playerTurn()
        {
            int x = - 1, y = -1;
            System.out.println("Введите через пробел координаты X и Y");
            do {
                if (scanner.hasNextInt())
                {
                    x = userInput(0, map.length) - 1;
                    y = userInput(0, map.length) - 1;
                }
                else {
                    System.out.println("Повторите ввод");
                    scanner.nextLine();
                }
            } while (!isCellValid(x, y));
            map[y][x] = playerSymbol;
        }

    //проверка на выход за предел массива
    private static boolean isCellExists(int i, int k)
    {
        boolean res = true;
        if (i < 0 || k < 0 || i >= map.length || k >= map.length)
        {
            res = false;
        }
        return res;
    }

    //проверка доступности клетки для хода
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

            return res;
        }

        //подготовка карты для игры и ее заполнение пустыми символами
        private static void initMap()
        {
            for (int i = 0; i < (map.length * map.length); i++)
            {
                int x = i / map.length;//[0.0.0.0.0]; [1.1.1.1.1]; - только квадратные массивы
                int y = i % map.length;//[0.1.2.3.4]; [0.1.2.3.4]; - только квадратные массивы
                map[x][y] = emptySymbol;
            }
        }

        //подсчет очков для пустой клетки для iqAiTurn
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


