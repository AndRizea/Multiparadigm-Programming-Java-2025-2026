package csie.ase.ro.classes;

import csie.ase.ro.interfaces.Operator;

public class Calculator implements Operator {

	@Override
	public double operate(double o1, double o2) {
		return o1 + o2;
	}

}
