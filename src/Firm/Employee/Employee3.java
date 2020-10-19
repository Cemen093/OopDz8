package Firm.Employee;

import java.util.Arrays;

public class Employee3 extends Employee{
    protected boolean havingChildren;

    public Employee3(String fullName, String paymentTypes, int salary, boolean havingChildren) {
        super(fullName, paymentTypes, salary);
        this.havingChildren = havingChildren;
    }

    @Override
    public String toString(){
        int pay = (paymentTypes.equals("ставка")) ? (numDays * salaryOnDay) :
                (paymentTypes.equals("почасовая") ? (numHours * salaryOnHour) : (Arrays.stream(sumForFinishedWorks).sum()));
        int tax = paymentTypes.equals("сдельная") ? 15 : 20;
        tax = (havingChildren) ? tax : tax + 5;
        return String.format("%1s%-20s%1s%-20s%1s%-20s%1s%-20s%1s",
                "|", fullName,
                "|", tax,
                "|", pay,
                "|", (int)(pay * (1 - tax * 0.01)),//Фигма округляет зарплату в свою сторону, ничего странного
                "|");
    }
}
