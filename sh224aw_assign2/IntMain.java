package sh224aw_assign2;

/**
 * Assignment-2, exercise-1, main class
 *
 * @author Sophia Hjörnhede
 * @version 1.10 30 June 2020
 */

public class IntMain {

    public static void main (String[] args) {

        Int i1 = new Int(5); //give integer value
        Int i2 = new Int(2); //give integer value

        Int sum = i1.plus(i2);
        Int div = i1.div(i2);

        if (sum.isLargerThan(i1))
            System.out.println("Sum "+ sum + " is larger than " + i1 );
        if (div.isEqualTo(i2) )
            System.out.println("Both are equal");
        else
            System.out.println("They are not equal");
    }
}
