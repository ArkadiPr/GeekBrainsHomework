package com.kostandov.geekbrains.homework2.employee;

public class Group {
    private int counter=0;
    private String groupName;
    private Employee[] employees=new Employee[10];

    public void addEmployee(Employee employee){
        if(counter<10) {
            employees[counter] = employee;
            counter++;
        }
    }
    public void deleteEmployee(int index){
        if(index<counter){
            employees[index]=null;
        }
        for (int k = index; k < employees.length-1; k++) //сдвиг последующих элементов
            employees[k] = employees[k + 1];
        counter--;
    }
    public void deleteAllEmployees(){
        for(int i=0;i<counter;i++){
            employees[i]=null;
        }
        counter=0;
    }
    public void printInformationEmployees(){
        for(int i=0;i<counter;i++){
            System.out.println(employees[i]);
        }
    }

    public Employee[] getEmployees() {
        return employees;
    }
}
