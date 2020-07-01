package sh224aw_assign2;

/**
 * Assignment-2, exercise-4
 *
 * @author Sophia Hjörnhede
 * @version 1.10 30 June 2020
 */

public class Money {
    int dollar;
    int cents;

    // Default constructor
    public Money() {
    }

    public Money(int dollar) {
        this.dollar = dollar;
        this.cents = 0;
    }

    public Money(int dollar, int cents) {
        this.dollar = dollar;
        this.cents = cents;

    }

    // Getter and setters
    public int getDollar() {
        return dollar;
    }

    public void setDollar(int dollar) {
        this.dollar = dollar;
    }

    public int getCents() {
        return cents;
    }

    public void setCents(int cents) {
        this.cents = cents;
    }
}