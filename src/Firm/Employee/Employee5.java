package Firm.Employee;

import java.util.Arrays;

public class Employee5 extends Employee4{
    protected boolean offshore;

    public Employee5(String fullName, String paymentTypes, int salary, boolean havingChildren, double exchangeRates, boolean offshore) {
        super(fullName, paymentTypes, salary, havingChildren, exchangeRates);
        this.offshore = offshore;
    }

    @Override
    public String toString(){
        String  payAfterTax;
        int pay = (paymentTypes.equals("ставка")) ? (numDays * salaryOnDay) :
                (paymentTypes.equals("почасовая") ? (numHours * salaryOnHour) : (Arrays.stream(sumForFinishedWorks).sum()));
        int tax;
        if (offshore){
            tax = 0;
            payAfterTax = String.valueOf(pay);
        }
        else {
            tax = paymentTypes.equals("сдельная") ? 15 : 20;
            tax = (havingChildren) ? tax : tax + 5;
            payAfterTax = (paymentTypes.equals("почасовая") ?
                    (int)((pay * (1 - tax * 0.01)) / 2) + "/" + (int)((pay * (1 - tax * 0.01)) / 2 * exchangeRates):
                    String.valueOf((int)(pay * (1 - tax * 0.01))));
        }
        return String.format("%1s%-20s%1s%-20s%1s%-20s%1s%-20s%1s",
                "|", fullName,
                "|", tax,
                "|", pay,
                "|", payAfterTax,
                "|");
    }
}
