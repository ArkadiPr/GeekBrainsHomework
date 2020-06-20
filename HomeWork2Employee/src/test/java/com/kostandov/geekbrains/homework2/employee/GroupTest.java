package com.kostandov.geekbrains.homework2.employee;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;


public class GroupTest extends TestCase {

    @Test
    public void testAddEmployee() {
        Group group=new Group();
        Employee employee1=new Employee("Ivanov","ivanov@mail.ru",25,"admin");
        Employee employee2=new Employee("Sidorov","sidorov@mail.ru",36,"designer");
        Employee employee3=new Employee("Fedorov","fedorov@mail.ru",40,"programmer");
        group.addEmployee(employee1);
        group.addEmployee(employee2);
        group.addEmployee(employee3);

        Employee[] employees=group.getEmployees();
        boolean result=true;
        for(int i=0;i<3;i++){
            switch (i){
                case 0:
                    result=employee1.equals(employees[0]);
                    break;
                case 1:
                    result=employee2.equals(employees[1]);
                    break;
                case 2:
                    result=employee3.equals(employees[2]);
                    break;

            }
            if(!result)
                break;
        }
        Assert.assertTrue(result);

    }

    @Test
    public void testDeleteEmployee() {
        Group group=new Group();
        Employee employee1=new Employee("Ivanov","ivanov@mail.ru",25,"admin");
        Employee employee2=new Employee("Sidorov","sidorov@mail.ru",36,"designer");
        Employee employee3=new Employee("Fedorov","fedorov@mail.ru",40,"programmer");
        group.addEmployee(employee1);
        group.addEmployee(employee2);
        group.addEmployee(employee3);

        group.deleteEmployee(1);

        Employee[] employees=group.getEmployees();
        boolean result=true;
        for(int i=0;i<3;i++){
            switch (i){
                case 0:
                    result=employee1.equals(employees[0]);
                    break;
                case 1:
                    result=employee3.equals(employees[1]);
                    break;
                case 2:
                    result=(employees[2]==null);
                    break;

            }
            if(!result)
                break;
        }
        Assert.assertTrue(result);



    }

    @Test
    public void testDeleteAllEmployees() {
        Group group=new Group();
        Employee employee1=new Employee("Ivanov","ivanov@mail.ru",25,"admin");
        Employee employee2=new Employee("Sidorov","sidorov@mail.ru",36,"designer");
        Employee employee3=new Employee("Fedorov","fedorov@mail.ru",40,"programmer");
        group.addEmployee(employee1);
        group.addEmployee(employee2);
        group.addEmployee(employee3);

        group.deleteAllEmployees();
        Employee[] employees=group.getEmployees();
        boolean result=true;
        for (Employee employee : employees) {
            result = (employee == null);
            if (!result) {
                break;
            }
        }
        Assert.assertTrue(result);
    }

    @Test
    public void testPrintInformationEmployees() {
        Group group=new Group();
        Employee employee1=new Employee("Ivanov","ivanov@mail.ru",25,"admin");
        Employee employee2=new Employee("Sidorov","sidorov@mail.ru",36,"designer");
        Employee employee3=new Employee("Fedorov","fedorov@mail.ru",40,"programmer");
        group.addEmployee(employee1);
        group.addEmployee(employee2);
        group.addEmployee(employee3);

        group.printInformationEmployees();

    }
}