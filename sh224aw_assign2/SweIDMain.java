package sh224aw_assign2;

import java.util.Scanner;

/**
 * Assignment-2, exercise-2, main class
 *
 * @author Sophia Hjörnhede
 * @version 1.10 30 June 2020
 */

public class SweIDMain {

    public static void main(String[] args){
        SweID id = new SweID();

        String test = id.regex;
        test = "640123-8826";

        String test2 = id.regex;
        test2 = "640123-8826";

        String test3 = id.regex;
        test3 = "550414-0913";

        String test4 = id.regex;
        test4 = "551314-0913";

        String test5 = id.regex;
        test5 = "550414-0912";

        System.out.println(test);
        id.isFemaleNumber(test);
        id.isCorrectNumber(test);

        System.out.println("  ");
        System.out.println(test3);
        id.isFemaleNumber(test3);
        id.isCorrectNumber(test3);

        System.out.println("  ");
        System.out.println(test4);
        id.isFemaleNumber(test4);
        id.isCorrectNumber(test4);

        System.out.println("");
        System.out.println(test5);
        id.isFemaleNumber(test5);
        id.isCorrectNumber(test5);

        System.out.println("");
        id.areEqual(test,test2);

        System.out.println("");
        id.areEqual(test,test5);
    }
}
