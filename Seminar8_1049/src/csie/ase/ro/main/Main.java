package csie.ase.ro.main;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import csie.ase.ro.classes.Calculator;
import csie.ase.ro.interfaces.Displayable;
import csie.ase.ro.interfaces.Operator;
import csie.ase.ro.interfaces.Printable;

public class Main {

	public static void main(String[] args) {
		Operator operator = new Calculator(); // interface as type

		double value = operator.operate(2, 5);
		System.out.println("Initial sum: " + value);

		// anonymous class
		operator = new Operator() {
			@Override
			public double operate(double o1, double o2) {
				return o1 - o2;
			}
		};

		value = operator.operate(2, 5);
		System.out.println("Substraction: " + value);

		// anonymous object
		System.out.println(new Calculator().operate(4, 5));

		// anonymous function
		operator = (/* double */o1, o2) -> o1 * o2;
		value = operator.operate(2, 5);
		System.out.println("Multiplication: " + value);

		operator = (x, y) -> {
			double sum = x + y;
			return sum / 2;
		};
		value = operator.operate(2, 5);
		System.out.println("Average: " + value);

		Displayable d = () -> System.out.println("Hello");
		d.display();

		Printable p = m -> System.out.println(m);
		p.print("Hi");

		// streams
		List<Integer> list = Arrays.asList(2, 5, 4, 78, 5, 7, 5, 6, 9, 5, 1, 4, 5, 3, 10);
		long count = list.stream().filter(x -> x % 2 == 0).count();
		System.out.println(count);

		long sum = list.stream().filter(x -> x % 2 == 0).mapToInt(x -> x.intValue()).sum();
		System.out.println(sum);

		List<Integer> sublist = list.stream().sorted().distinct().collect(Collectors.toList());
		for (Integer i : sublist) {
			System.out.println(i);
		}

		List<String> strings = Arrays.asList("ac", "adf", "adsfdv", "rgrg", "erewt", "f", "a");
		strings.stream().filter(s -> s.startsWith("a")).sorted().forEach(s -> System.out.println(s));

		strings.stream().filter(s -> s.length() > 3).sorted().forEach(s -> System.out.println(s));

		list.stream().distinct().sorted().map(x -> x * x).forEach(System.out::println);

		// parallel streams
		strings.parallelStream().filter(s -> s.startsWith("r")).forEach(System.out::println);

	}

}
