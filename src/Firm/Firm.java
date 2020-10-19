package Firm;

import Firm.Employee.Employee;

import java.util.Arrays;

public class Firm {
    private Employee[] employees = new Employee[0];
    private String tableHeader;

    public Firm(String tableHeader) {
        this.tableHeader = tableHeader;
    }

    public void addEmployee(Employee employees){
        this.employees = Arrays.copyOf(this.employees, this.employees.length + 1);
        this.employees[this.employees.length - 1] = employees;
    }

    public void addDay(int index, int number){
        employees[index].addDay(number);
    }

    public void addHours(int index, int number){
        employees[index].addHours(number);
    }

    public void addFinishedWorks(int index, int number, int numHour){
        employees[index].addFinishedWorks(number, numHour);
    }

    public void print(){
        for (int i = 0; i < tableHeader.length() / 20; i++) {
            System.out.print("+--------------------");
        }
        System.out.println("+");
        System.out.println(tableHeader);
        for (int i = 0; i < tableHeader.length() / 20; i++) {
            System.out.print("+--------------------");
        }
        System.out.println("+");
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].toString());
            for (int j = 0; j < tableHeader.length() / 20; j++) {
                System.out.print("+--------------------");
            }
            System.out.println("+");
        }
    }
}
