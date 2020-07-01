package sh224aw_assign2;

/**
 * Assignment-2, exercise-1
 *
 * @author Sophia Hjörnhede
 * @version 1.10 30 June 2020
 */

public class Int {
	
	int value;
	//constructor
	Int(int value) {
		this.value = value;		
	}
    Int(){	
	}	
	
	@Override
	public String toString() {
		return String.valueOf(value);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	//method plus
	public Int plus(Int n) {
		Int s = new Int(n.getValue() + this.getValue());
		return s;
	}
	//method div
	public Int div(Int m) {
		Int d = new Int(this.getValue() / m.getValue());
		return d;
	}
	//method isLargerThan
	public boolean isLargerThan(Int i) {
		return this.value > i.getValue();
	}
	//method isEqualTo
	public boolean isEqualTo(Int j) {
		return this.value == j.getValue();
	}
}

