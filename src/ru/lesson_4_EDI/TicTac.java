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
            initMap();
            printMap();

            while (true){

                playerTurn();
                printMap();

                if (isCheckWin(playerSymbol))
                {
                    break;
                }

                if (isMapFull())
                {
                    System.out.println("Поле заполнено.");
                    break;
                }

                computerTurn();
                printMap();

                if (isCheckWin(computerSymbol))
                {
                    break;
                }

                if (isMapFull())
                {
                    System.out.println("Поле заполнено.");
                    break;
                }
            }
        }

    private static boolean isMapFull()
    {
        boolean res = true;
            for (int i = 0; i < map.length; i++)
            {
                for (int k = 0; k < map.length; k++)
                {
                    if (map[i][k] == emptySymbol)
                    {
                        res = false;
                        break;
                    }
                    if (res == false)
                    {
                        break;
                    }
                }
                if (res == false)
                {
                    break;
                }
            }
            return res;
    }

    private static void computerTurn()
    {
        int x = -1, y = -1;
        do
            {
                x = (int) (Math.random() * SIZE);
                y = (int) (Math.random() * SIZE);
            } while (!isCellValid(x, y));
        map[y][x] = computerSymbol;
        System.out.println("Компьютер пошел на клетку: " + (x + 1) + " "+ (y+1));
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
                        System.out.println("Победили " + symbol);
                    }
                    if (result== true)
                    {
                        break;
                    }
                }
                if (result== true)
                {
                    break;
                }
            }
            return result;
        }

        private static void printMap()
        {
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

        private static void playerTurn()
        {
            int x = -1, y = -1;
            System.out.println("Введите через пробел координаты X и Y");
            do {
                   if (scanner.hasNextInt())
                   {
                       x = scanner.nextInt() - 1;
                       y = scanner.nextInt() - 1;
                   } else
                       {
                           System.out.println("Повторите ввод");
                           scanner.next();
                       }
            } while (!isCellValid(x, y));
                map[y][x] = playerSymbol;
        }

        private static boolean isCellValid(int x, int y)
        {
            boolean res = true;
            if ((x < 0 || x >= map.length) && (y < 0 || y >= map.length ))
            {
                res = false;
            }
            if (!isCellExists(x, y) || map[y][x] != emptySymbol)
            {
                res = false;;
            }
            return res;
        }


    private static boolean isCellExists(int i, int k)
    {
        boolean res = true;
        if (i < 0 || k < 0 || i >= map.length || k >= map.length)
        {
            res = false;
        }
        return res;
    }

        private static void initMap()
        {
            for (int i = 0; i < map.length; i++)
            {
                for (int k = 0; k < map.length; k++)
                {
                    map[i][k] = emptySymbol;
                }
            }
        }
    }


