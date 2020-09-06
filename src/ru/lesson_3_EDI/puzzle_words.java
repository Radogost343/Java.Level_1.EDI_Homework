package ru.lesson_3_EDI;
import java.util.*;
/*
* Создать массив из слов
String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"}.
При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя, сравнивает его с загаданным словом и сообщает, правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы, которые стоят на своих местах.
apple – загаданное
apricot - ответ игрока
ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
Для сравнения двух слов посимвольно можно пользоваться:
String str = "apple";
char a = str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
Играем до тех пор, пока игрок не отгадает слово.
Используем только маленькие буквы.
 */

public class puzzle_words {

    public static void main(String[] args) {
        String computerAnswer = computerAnswer();
        do {
            System.out.println("\nВведите загаданное компьютером слово: ");
        } while (!CheckUserAndComputerAnswer(computerAnswer).equals(computerAnswer));
    }

    private static String CheckUserAndComputerAnswer(String computerAnswer)
    {
    Scanner scanner = new Scanner(System.in);
    String userAnswer = scanner.nextLine();
    StringBuilder s = new StringBuilder();
            for (int i = 0; i < computerAnswer.length(); i++)
            {
                if (i < userAnswer.length())
                {
                    char str1 = computerAnswer.charAt(i);
                    char str2 = userAnswer.charAt(i);
                    if (Objects.equals(str1, str2))
                    {
                        s.append(str1);
                    }
                    else
                    {
                        s.append("#");
                    }
                }
            }
    s.append("##########################");
    s.setLength(15);
    System.out.print(s);
            if (userAnswer.equals(computerAnswer))
            {
                System.out.println("\nПоздравляем, вы угадали слово! " + computerAnswer);
            }
    return userAnswer;
    }

    private static String computerAnswer()
    {
        String[] words = {"apple", "orange", "lemon", "banana",
                "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak",
                "kiwi", "mango", "mushroom", "nut", "olive",
                "pea", "peanut", "pear", "pepper",
                "pineapple", "pumpkin", "potato"};
        String answer = words[(int) (Math.random() * words.length)];
        return answer;
    }
}
