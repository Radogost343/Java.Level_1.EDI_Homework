package ru;

/*
Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
Конструктор класса должен заполнять эти поля при создании объекта.
Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
Создать массив из 5 сотрудников.
С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
 */

public class lesson_5_EDI {
    public static void main(String[] args) {
        EmployerListFields[] employer = new EmployerListFields[5];
        employer[0] = new EmployerListFields("Ivanov II", "CEO", "III@mail.ru",1001,180,55);
        employer[1] = new EmployerListFields("Asta AA", "SEO", "AAA@mail.ru",2002,100,39);
        employer[2] = new EmployerListFields("Blok BB", "CVO", "BBB@mail.ru",3003,140,29);
        employer[3] = new EmployerListFields("Cline CC", "COO", "CCC@mail.ru",4004,110,57);
        employer[4] = new EmployerListFields("Dream DD", "CIO", "DDD@mail.ru",5005,90,28);

        for (EmployerListFields employerListFields : employer) {
            if (employerListFields.getYears() < 40) {
                employerListFields.employerInfo();
            }
        }
    }
}

