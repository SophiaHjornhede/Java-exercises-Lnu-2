package sh224aw_assign2;

/**
 * Assignment-2, exercise-3
 *
 * @author Sophia Hjörnhede
 * @version 1.10 30 June 2020
 */

import java.util.Date;
import java.util.Scanner;

import static java.lang.String.valueOf;

public class Pizza {
    private int value;
    private Size size; //use enum to represent sizes
    private Topping topping; //use enum
    private int numberOfToppings;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getNumberOfToppings() {
        return numberOfToppings;
    }

    public void setNumberOfToppings(int numberOfToppings) {
        this.numberOfToppings = numberOfToppings;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(String stringSize) {
        this.size = size.valueOf(stringSize);
    }

    public Topping getTopping() {
        return topping;
    }

    public void setTopping(String toppingChoice) {
        this.topping = topping.valueOf(toppingChoice);
    }

    public Pizza createPizza(Pizza customPizza) {
        System.out.println("Please enter size of your pizza (small, medium, or large): " + java.util.Arrays.asList(size.values()));
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        String sizeChooseByUser = scanner.nextLine();  // Read user input
        String toUpper = sizeChooseByUser.toUpperCase(); //to ensure the user can input any letter cases
        //System.out.println("sizeChosen: " + sizeChooseByUser);
        //Pizza.Size pizzaSize = Pizza.Size.valueOf(toUpper);
        customPizza.setSize(toUpper);
        System.out.println("Please enter type of topping (cheese, pepperoni, ham): " + java.util.Arrays.asList(topping.values()));
        String toppingChooseByUser = scanner.nextLine();
        customPizza.setTopping(toppingChooseByUser.toUpperCase());
        //Pizza.Topping topping = Pizza.Topping.valueOf(toppingChooseByUser.toUpperCase());
        System.out.println("Please enter number of toppings you want: ");
        String numberOfToppings = scanner.nextLine();
        this.numberOfToppings = Integer.parseInt(numberOfToppings);
        //System.out.println("size: "+ size.toString());

        return customPizza;
    }

    //method calcCost
    public double calcCost(Pizza thePizza) {

        if (thePizza.size.equals(size.SMALL)) {
            //System.out.println("The small one");
            return 10 + 3.0 * numberOfToppings;
        }
        if (thePizza.size.equals(size.MEDIUM)) {
            return 15 + 2.5 * numberOfToppings;
        }
        if (thePizza.size.equals(size.LARGE)) {
            return 20 + 2.0 * numberOfToppings;
        }
        return 1000;
    }

    public void getDescription(Pizza thePizza) {

        System.out.println("Thank you, \"You ordered a " + thePizza.getSize().toString().toLowerCase() +
                " pizza with " + numberOfToppings + " " + thePizza.getTopping().toString().toLowerCase() + ".\n" +
                "Your bill is " + thePizza.calcCost(thePizza) + " kr\"");

        System.out.println("\nEnjoy the food!");

    }

    public
    enum Size {
        SMALL,
        MEDIUM,
        LARGE
    }
    enum Topping {
        CHEESE,
        PEPPERONI,
        HAM
    }

    public void showWelcomeText() {
        System.out.println("Welcome to the Café LNU!\n");
    }

    //method to display the current date and time
    public void showTime() {
        Date date = java.util.Calendar.getInstance().getTime();
        System.out.println(date.toString() + "\n");
    }
}