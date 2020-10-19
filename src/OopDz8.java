import Firm.Employee.*;
import Firm.Firm;

public class OopDz8 {
    public static void main(String[] args) {

        work(new Firm(
                String.format("%1s%-20s%1s%-20s%1s%-20s%1s", "|", "ФИО", "|", "Вид оплаты", "|", "Сумма", "|")),
                new Employee("Иванов","ставка",50),
                new Employee("Сидоров","почасовая",10),
                new Employee("Петров","сдельная", 0));

        work(new Firm(
                String.format("%1s%-20s%1s%-20s%1s%-20s%1s%-20s%1s",
                "|", "ФИО","|", "Налог, %", "|", "Сумма (грн)", "|", "К оплате (грн)", "|")),
                new Employee2("Иванов","ставка",50),
                new Employee2("Сидоров","почасовая",10),
                new Employee2("Петров","сдельная", 0));

        work(new Firm(
                        String.format("%1s%-20s%1s%-20s%1s%-20s%1s%-20s%1s",
                                "|", "ФИО","|", "Налог, %", "|", "Сумма (грн)", "|", "К оплате (грн)", "|")),
                new Employee3("Иванов","ставка",50, false),
                new Employee3("Сидоров","почасовая",10, true),
                new Employee3("Петров","сдельная", 0, false));

        work(new Firm(
                        String.format("%1s%-20s%1s%-20s%1s%-20s%1s%-20s%1s",
                                "|", "ФИО","|", "Налог, %", "|", "Сумма (грн)", "|", "К оплате, Курс 1/8", "|")),
                new Employee4("Иванов","ставка",50, false, (double)1/8),
                new Employee4("Сидоров","почасовая",10, true, (double)1/8),
                new Employee4("Петров","сдельная", 0, false, (double)1/8));

        work(new Firm(
                        String.format("%1s%-20s%1s%-20s%1s%-20s%1s%-20s%1s",
                                "|", "ФИО","|", "Налог, %", "|", "Сумма (грн)", "|", "К оплате, Курс 1/8", "|")),
                new Employee5("Иванов","ставка",50, false, (double)1/8, true),
                new Employee5("Сидоров","почасовая",10, true, (double)1/8, false),
                new Employee5("Петров","сдельная", 0, false, (double)1/8, false));

        work(new Firm(
                        String.format("%1s%-20s%1s%-20s%1s%-20s%1s%-20s%1s",
                                "|", "ФИО","|", "Налог, %", "|", "Сумма (грн)", "|", "К оплате, Курс 1/8", "|")),
                new Employee6("Иванов","ставка",50, false, (double)1/8, true, 700),
                new Employee6("Сидоров","почасовая",10, true, (double)1/8, false, 700),
                new Employee6("Петров","сдельная", 0, false, (double)1/8, false, 700));
    }

    public static void work(Firm firm, Employee e1, Employee e2, Employee e3){

        firm.addEmployee(e1);
        firm.addEmployee(e2);
        firm.addEmployee(e3);

        firm.addDay(0,15);


        firm.addHours(1,70);

        firm.addFinishedWorks(2,200, 40);
        firm.addFinishedWorks(2,100, 20);
        firm.addFinishedWorks(2,300, 60);

        firm.print();
    }
}
