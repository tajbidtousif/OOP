import java.util.Scanner;

class BillCalculator {

    static double calculateBasicBill(double unit) {
        double price = 0;
        switch ((int) unit / 200) {
            case 0:
                price = unit*1.20;
                break;
            case 1:
                price = 238.8 + (unit-199)*1.50;
                break;
            case 2:
                price = 538.8 + (unit-399)*1.80;
                break;
            default:
                price = 898.8 + (unit-599)*2.00;
        }
        return price;
    }

    static double calculateSurcharge(double basicBill) {

        return basicBill > 400 ? basicBill * 0.15 : 0;
    }

    static double getTotalBill(double unit) {
        double bill = calculateBasicBill(unit) + calculateSurcharge(unit);
        return bill < 100 ? 100 : bill;
    }
}

public class Task_03 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Unit for knowing the Payment: ");
         System.out.println(BillCalculator.getTotalBill(sc.nextDouble()) + " Tk");
         System.out.println("Enter Unit for knowing the Payment: ");
         System.out.println(BillCalculator.getTotalBill(sc.nextDouble()) + " Tk");
         System.out.println("Enter Unit for knowing the Payment: ");
         System.out.println(BillCalculator.getTotalBill(sc.nextDouble()) + " Tk");

        sc.close();
    }

}