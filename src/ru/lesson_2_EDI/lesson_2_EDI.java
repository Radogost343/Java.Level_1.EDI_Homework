package ru.lesson_2_EDI;
import java.util.*;

/*
        1. Задать целочисленный массив, состоящий из элементов 0 и 1.
        Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        С помощью цикла и условия заменить 0 на 1, 1 на 0;

        2. Задать пустой целочисленный массив размером 8.
        С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;

        3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
         и числа меньшие 6 умножить на 2;

        4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
         и с помощью цикла(-ов) заполнить его диагональные элементы единицами;

        5. ** Задать одномерный массив и найти в нем минимальный
        и максимальный элементы (без помощи интернета);

        6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
        метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой
        части массива равны.
        Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
        checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||,
        эти символы в массив не входят.

        7. **** Написать метод, которому на вход подается одномерный массив и число n
         (может быть положительным, или отрицательным),
         при этом метод должен сместить все элементымассива на n позиций.
         Для усложнения задачи нельзя пользоваться вспомогательными массивами.
*/


public class lesson_2_EDI {

    public static void main(String[] args)
    {
    arrChange0and1(generateRandomArr(20,2));
    arrSize8step3(8,3);
    arrDataLess6multiply2(generateRandomArr(15,9));
    arrFillDiagonal(5);
    arrMinAndMaxData(generateRandomArr(10,10));
    System.out.println(isArrRightSumEqualLeftSum(generateRandomArr(7,4)));
    System.out.println(isArrRightSumEqualLeftSum(generateRandomArr(3,2)));
    System.out.println(isArrRightSumEqualLeftSum(generateRandomArr(6,3)));
    arrShift(generateRandomArr(7,5), -10);
    arrShift(generateRandomArr(9,7), 3);
    }

    private static void arrShift(int[] arr, int shift)
    {
        int shiftAnswer = shift;
        if ((shift > arr.length || shift * (-1) > arr.length))
        {
            shift = shift % arr.length;
        }

    while (shift < 0)
        {
            shift++;
            int tempData = arr[0];

            for (int i = 0; i < arr.length - 1; i++)
            {
                arr[i] = arr[i + 1];
            }

            arr[arr.length - 1] = tempData;
        }

        while (shift > 0)
        {
            shift--;
            int tempData = arr[arr.length - 1];

            for (int i = 0; i < arr.length - 1; i++)
            {
                arr[arr.length - 1 - i] = arr[arr.length -2 - i];
            }

            arr[0] = tempData;
        }

        if (shift == 0)
        {
            printArr(arr);
            System.out.print("Смещение выполненно на : " + shiftAnswer + " элементов." );
        }

    }

    private static void arrMinAndMaxData(int arr[])
    {
        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < arr.length; i++)
        {
            if (max < arr[i])
            {
                max = arr[i];
            }
            else if (min > arr[i])
            {
                min = arr[i];
            }
        }
        System.out.println("Max = " + max + ", Min = " + min);
    }

    private static void arrFillDiagonal(int arrSize)
    {
        int [][] arr = new int[arrSize][arrSize];
        for (int i = 0; i < arr.length; i++)
        {
            arr[i][i] = 1;
            arr[arr.length - 1 - i] [i] = 1;
        }
        printArr(arr);
    }

    private static void arrDataLess6multiply2(int [] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] < 6 )
            {
            arr[i] *= 2;
            }
        }
        System.out.print ("Changed ");
        printArr(arr);
    }

    private static void arrSize8step3(int arrSize, int step)
    {
        int [] arr = new int[arrSize];
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = i*3;
        }
        printArr(arr);
    }

    private static void arrChange0and1(int arr[])
    {
        for (int i = 0; i < arr.length; i++)
        {
        arr[i] = 1 - arr[i];
        /*
        switch (arr[i])
        {
            case 0:
                arr[i] = 0;
                arr[i] = 1;
                break;
            default:
                arr[i] = 1;
                arr[i] = 0;
        }
         */
        }
        System.out.print ("Changed ");
    printArr(arr);
    }

    private static void printArr(int arr[])
    {
        System.out.println("arr: ");
        System.out.println(Arrays.toString(arr));
    }

    private static void printArr(int arr[], int data)
    {
        System.out.println("arr: ");
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");

            if (i == data)
            {
                System.out.print("|| ");
            }
        }
        System.out.println("");
    }

    private static void printArr(int arr[][])
    {
        System.out.println("arr: ");
        for (int i = 0; i < arr.length; i++)
        {
            for (int k = 0; k < arr.length; k++)
            {
                System.out.print(arr[i][k] + "|");
            }
            System.out.println("");
        }
        System.out.println("");
    }


    private static int [] generateRandomArr(int arrSize, int maxData)
    {
        int arr [] = new int[arrSize];
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = (int) (Math.random() * maxData);
        }
        printArr(arr);
        return arr;
    }

    private static boolean isArrRightSumEqualLeftSum(int arr[])
    {
        int rightSum = 0;
        int leftSum = 0;
        int centrArr = arr.length / 2;
        boolean res = false;

        for (int i = 0; i < centrArr; i++)
        {
            leftSum += arr[i];
            rightSum += arr[arr.length - i - 1];
            if (i == (centrArr - 1) && arr.length % 2 !=0)
            {
                rightSum += arr[arr.length - 2 - i];
            }
        }

        if (leftSum > rightSum)
        {
            for (int i = centrArr; i < arr.length; i++)
            {
                rightSum -= arr[i];
                leftSum += arr[i];
                if (rightSum == leftSum)
                {
                    printArr(arr, i);
                    res = true;
                    break;
                }
            }
        } else if (rightSum > leftSum)
        {
            for (int i = centrArr; i < arr.length; i++)
            {
                rightSum -= arr[i];
                leftSum += arr[i];
                if (rightSum == leftSum)
                {
                    printArr(arr, i);
                    res = true;
                    break;
                }
            }
        } else if (rightSum == leftSum)
        {
            printArr(arr, centrArr - 1);
            res = true;
        }
        return res;
    }
}
