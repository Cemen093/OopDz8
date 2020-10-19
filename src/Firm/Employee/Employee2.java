package Firm.Employee;

import java.util.Arrays;

public class Employee2 extends Employee{

    public Employee2(String fullName, String paymentTypes, int salary) {
        super(fullName, paymentTypes, salary);
    }

    @Override
    public String toString(){
        int pay = (paymentTypes.equals("ставка")) ? (numDays * salaryOnDay) :
                (paymentTypes.equals("почасовая") ? (numHours * salaryOnHour) : (Arrays.stream(sumForFinishedWorks).sum()));
        int tax = paymentTypes.equals("сдельная") ? 15 : 20;
        return String.format("%1s%-20s%1s%-20s%1s%-20s%1s%-20s%1s",
                "|", fullName,
                "|", tax,
                "|", pay,
                "|", (int)(pay * (1 - tax * 0.01)),//Фигма округляет зарплату в свою сторону, ничего странного
                "|");
    }
}
