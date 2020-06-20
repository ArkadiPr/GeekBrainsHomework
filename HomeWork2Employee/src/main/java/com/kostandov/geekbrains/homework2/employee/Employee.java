package com.kostandov.geekbrains.homework2.employee;

import java.util.Objects;

public class Employee {
    private String name;
    private String mail;
    private int age;
    private String position;

    public void printInformation(){
        System.out.println(this);
    }

    public Employee(String name, String mail, int age, String position) {
        this.name = name;
        this.mail = mail;
        this.age = age;
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age &&
                Objects.equals(name, employee.name) &&
                Objects.equals(mail, employee.mail) &&
                Objects.equals(position, employee.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mail, age, position);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", age=" + age +
                ", position='" + position + '\'' +
                '}';
    }
}
