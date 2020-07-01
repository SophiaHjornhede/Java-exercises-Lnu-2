package sh224aw_assign2;

/**
 * Assignment-2, exercise-3, main class
 *
 * @author Sophia Hjörnhede
 * @version 1.10 30 June 2020
 */

public class PizzaMain {

    public static void main(String[] args) {
        Pizza thePizza = new Pizza();
        thePizza.showTime();
        thePizza.showWelcomeText();
        thePizza.createPizza(thePizza);
        thePizza.getDescription(thePizza);
    }
}
