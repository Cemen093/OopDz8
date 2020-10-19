package Firm.Employee;

import java.util.Arrays;

public class Employee6 extends Employee5{
    protected int premium;

    public Employee6(String fullName, String paymentTypes, int salary, boolean havingChildren, double exchangeRates, boolean offshore, int premium) {
        super(fullName, paymentTypes, salary, havingChildren, exchangeRates, offshore);
        this.premium = premium;
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
            if (numHours > 200) {
                //А премию сумировать то до выплаты налогов или после?
                pay += premium;
            }
            payAfterTax = (paymentTypes.equals("почасовая") ?
                    (int) ((pay * (1 - tax * 0.01)) / 2) + "/" + (int) ((pay * (1 - tax * 0.01)) / 2 * exchangeRates) :
                    String.valueOf((int) (pay * (1 - tax * 0.01))));

        }
        return String.format("%1s%-20s%1s%-20s%1s%-20s%1s%-20s%1s",
                "|", fullName,
                "|", tax,
                "|", pay,
                "|", payAfterTax,
                "|");
    }
}
