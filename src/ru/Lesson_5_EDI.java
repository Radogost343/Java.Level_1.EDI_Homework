package ru;

/*
Создать массив из 5 сотрудников.
С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
 */

public class Lesson_5_EDI {
    public static void main(String[] args) {

        EmployerListFields[] employer = new EmployerListFields[5];
        employer[0] = new EmployerListFields("Ivanov II", "CEO", "III@mail.ru",7916,180,55);
        employer[1] = new EmployerListFields("Asta AA", "SEO", "AAA@mail.ru",7915,100,39);
        employer[2] = new EmployerListFields("Blok BB", "CVO", "BBB@mail.ru",7903,140,29);
        employer[3] = new EmployerListFields("Cline CC", "COO", "CCC@mail.ru",7985,110,57);
        employer[4] = new EmployerListFields("Dream DD", "CIO", "DDD@mail.ru",7999,90,28);

        for (EmployerListFields employerListFields : employer) {
            if (employerListFields.getYears() < 40) {
                employerListFields.employerInfo();
            }
        }

        EmployerListFields[] employer1 = new EmployerListFields[5];
        employer1[0] = new EmployerListFields("Ivanov II",55);
        employer1[1] = new EmployerListFields("Asta AA", 39);
        employer1[2] = new EmployerListFields("Blok BB", 29);
        employer1[3] = new EmployerListFields("Cline CC", 57);
        employer1[4] = new EmployerListFields("Dream DD", 28);

        for (EmployerListFields employerListFields : employer1) {
            if (employerListFields.getYears() < 40) {
                System.out.println(employerListFields.getFio() + ", год рождения сотрудника: " + employerListFields.getYearsOfBirth());
            }
        }

    }
}

