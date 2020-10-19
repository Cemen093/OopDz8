package Firm.Employee;

import java.util.Arrays;

public class Employee4 extends Employee3{
    protected double exchangeRates;

    public Employee4(String fullName, String paymentTypes, int salary, boolean havingChildren, double exchangeRates) {
        super(fullName, paymentTypes, salary, havingChildren);
        this.exchangeRates = exchangeRates;
    }

    @Override
    public String toString(){
        int pay = (paymentTypes.equals("ставка")) ? (numDays * salaryOnDay) :
                (paymentTypes.equals("почасовая") ? (numHours * salaryOnHour) : (Arrays.stream(sumForFinishedWorks).sum()));
        int tax = paymentTypes.equals("сдельная") ? 15 : 20;
        tax = (havingChildren) ? tax : tax + 5;
        String  payAfterTax = (paymentTypes.equals("почасовая") ?
                (int)((pay * (1 - tax * 0.01)) / 2) + "/" + (int)((pay * (1 - tax * 0.01)) / 2 * exchangeRates):
                String.valueOf((int)(pay * (1 - tax * 0.01))));
        return String.format("%1s%-20s%1s%-20s%1s%-20s%1s%-20s%1s",
                "|", fullName,
                "|", tax,
                "|", pay,
                "|", payAfterTax,
                "|");
    }
}
