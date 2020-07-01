package sh224aw_assign2;

/**
 * Assignment-2, exercise-4, main class
 *
 * @author Sophia Hjörnhede
 * @version 1.10 30 June 2020
 */

import java.text.NumberFormat;
import java.util.Locale;

public class MoneyMain {

    public static void main(String[] args) {
        // Building objects
        Money m1 = new Money(2);
        Money m2 = new Money(5, 5);

        showMeTheMoney(m1, m2); // Display the objects
        System.out.println();
        showMoneyByType(m1, m2); // Displays the details of the objects
        System.out.println();
        Money addedMoney = add(m1, m2); // Adding two objects

        Money subtracted = subtract(m2, m1);    // takes the difference between two Money objects
        System.out.println();

    }

    /**
     * Method takes to Money objects and adds the attributes and returns a summed up Money object
     *
     * @param pm1 Money class
     * @param pm2 Money class
     * @return pm1 Money class summed up with pm2
     */
    static Money add(Money pm1, Money pm2) {
        Money tmpMoney = new Money(0, 0);
        tmpMoney.setDollar((pm1.getDollar() + pm2.getDollar()));

        if (pm2.getCents() >= 100) {  // if we got more than a dollar in cents
            tmpMoney.setDollar(pm1.getDollar() + pm2.getCents() / 100);
            tmpMoney.setCents(pm1.getCents() + pm2.getCents() % 100);  // adding up the remaining cents

        } else {

            tmpMoney.setCents(pm1.getCents() + pm2.getCents());
        }
        System.out.println("Adding money1 and money2: $" + showMeTheMoney(tmpMoney));

        return tmpMoney;
    }

    /**
     * Takes the diffrence between Money p1 and Money p2 and returns a now money object as result
     *
     * @param p1 Money
     * @param p2 Money
     * @return
     */
    static Money subtract(Money p1, Money p2) {
        Money tmpMoney = new Money(0, 0);

        tmpMoney.setDollar(p1.getDollar() - p2.getDollar()); // can become negative
        if (p2.getCents() >= 100) {
            tmpMoney.setDollar(p1.getDollar() - p2.getCents() / 100);
            tmpMoney.setCents(p2.getCents() % 100);
        } else {
            tmpMoney.setCents(p1.getCents() - p2.getCents());
        }

        System.out.print("Subtracting money1 from money2: $" + showMeTheMoney(tmpMoney));

        return tmpMoney;
    }

    /**
     * Formats a Money class into a single  formatted type
     * @param m1
     * @return double
     */
    private static String showMeTheMoney(Money m1) {
        NumberFormat formatter = NumberFormat.getInstance(Locale.ENGLISH);
        formatter.setMinimumFractionDigits(2);

        double tmpm1 = m1.getDollar() + Double.valueOf(m1.getCents()) / 100;
        return formatter.format(tmpm1);

    }

    /**
     * Takes two money objects and displays the sum of the individual Money object
     * @param m1 Money
     * @param m2 Money
     * @return String
     */
    static String showMeTheMoney(Money m1, Money m2) {

        NumberFormat formatter = NumberFormat.getInstance(Locale.ENGLISH);
        formatter.setMinimumFractionDigits(2);
        String tmp;
        double tmpm1 = m1.getDollar() + Double.valueOf(m1.getCents()) / 100;
        double tmpm2 = m2.getDollar() + Double.valueOf(m2.getCents()) / 100;

        System.out.println("Money 1 is: $" + formatter.format(tmpm1));
        System.out.println("Money 2 is: $" + formatter.format(tmpm2));
        tmp = "Money 1 is: $\" + formatter.format(tmpm1)\n+Money 2 is: $\" + formatter.format(tmpm2)";
        return tmp;
    }


    /**
     * Takes to Money classes and displays individual dollar and cents
     * @param pMoney1 Money
     * @param pMoney2 Money
     */
    static void showMoneyByType(Money pMoney1, Money pMoney2) {
        System.out.println("Money1\'s dollars are: " + pMoney1.getDollar());
        System.out.println("Money1\'s cents are: " + pMoney1.getCents());
        System.out.println("Money1\'s dollars are: " + pMoney2.getDollar());
        System.out.println("Money1\'s cents are: " + pMoney2.getCents());
    }

}