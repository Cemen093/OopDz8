package Firm.Employee;

import java.util.Arrays;

public class Employee {
    //ФИО
    protected String fullName;
    //Вид оплаты
    protected String paymentTypes;
    //ставка – указывается, сколько сотрудник получает за рабочий день;
    protected int salaryOnDay = 0;
    //для каждого сотрудника записывается, сколько дней он отработал в месяце;
    protected int numDays = 0;
    //почасовая – указывается, сколько сотрудник получает в час
    protected int salaryOnHour = 0;
    //для каждого сотрудника; записывается, сколько часов он отработал в месяце
    protected int numHours = 0;
    //для каждого сотрудника записываются суммы для каждой работы, что он успел сделать за месяц
    protected int sumForFinishedWorks[] = new int[0];

    public Employee() {
    }

    public Employee(String fullName, String paymentTypes, int salary) {
        this.fullName = fullName;
        this.paymentTypes = paymentTypes;
        if (paymentTypes.equals("ставка")){salaryOnDay = salary;}
        else{salaryOnHour = salary;}
    }

    public void addDay(int number){
        numDays += number;
        numHours = numDays * 8;//пусть будет 8 часовой рабочий день
    }

    public void addHours(int number){
        numHours += number;
        numDays = numHours / 8;//пусть будет 8 часовой рабочий день
    }

    public void addFinishedWorks(int number, int numHours){
        sumForFinishedWorks = Arrays.copyOf(sumForFinishedWorks, sumForFinishedWorks.length+1);
        sumForFinishedWorks[sumForFinishedWorks.length - 1] = number;
        addHours(numHours);
    }

    @Override
    public String toString(){
        int pay = (paymentTypes.equals("ставка")) ? (numDays * salaryOnDay) :
                (paymentTypes.equals("почасовая") ? (numHours * salaryOnHour) : (Arrays.stream(sumForFinishedWorks).sum()));
        return String.format("%1s%-20s%1s%-20s%1s%-20s%1s", "|", fullName, "|", paymentTypes, "|", pay, "|");
    }
}
