package ru;
/*
Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
Конструктор класса должен заполнять эти поля при создании объекта.
Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
Создать массив из 5 сотрудников.
С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
 */

public class EmployerListFields {
String fio;
String position;
String email;
int telNumber;
int salary;
int years;

public EmployerListFields (
        String fio,
        String position,
        String email,
        int telNumber,
        int salary,
        int years)
{
    this.fio = fio;
    this.position = position;
    this.email = email;
    this.telNumber = telNumber;
    this.salary = salary;
    this.years = years;
}


public void employerInfo() {
    System.out.println("FIO: " + getFio() +
            ", position: " + getPosition() +
            ", email " + getEmail() +
            ", telNumber " + getTelNumber() +
            ", salary " + getSalary() +
            ", years: " + getYears());
}

    public String getPosition() {
        return position;
    }

    public int getSalary() {
        return salary;
    }

    public int getTelNumber() {
        return telNumber;
    }

    public int getYears() {
        return years;
    }

    public String getEmail() {
        return email;
    }

    public String getFio() {
        return fio;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setTelNumber(int telNumber) {
        this.telNumber = telNumber;
    }

    public void setYears(int years) {
        this.years = years;
    }
}
