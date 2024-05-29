package Programming;

import java.util.List;
import java.util.stream.Stream;

public class FP02ReduceDemo {

	public static void main(String[] args) {

		List<Integer> numbers = List.of(6, 2, 11, 78, 3, 9, 44);

		// how reduce is working internally
		// 0 6
		// 6 2
		// 8 11
		// 19 78
		// 97 3
		// 100 9
		// 109 44
		// 153 24
		// 177

//		int sum = addListFunctional(numbers);
//		System.out.println(sum);

		System.out.println(squareAndSumInList(numbers));
		System.out.println(SumOfOddsInList(numbers));

	}

	private static int SumOfOddsInList(List<Integer> numbers) {
		return numbers.stream()
				.filter(number -> number%2 != 0)
				.reduce(0, Integer::sum);
	}

	private static int squareAndSumInList(List<Integer> numbers) {
		return		numbers.stream()
				.map(number -> +number*number)
//				.forEach(System.out::println);
			.reduce(0,(x,y) -> x+y);
				

	}

//	private static int sum(int a, int b) {
//		System.out.println(a + " " + b);
//		return a + b;
//	}

	private static int addListFunctional(List<Integer> numbers) {
		// reduce -- combine them into one result
		// 0 - starting value and(a,b)-> a+b
		return numbers.stream()
		// reduce(0, FP01Functional::sum);
//					  .reduce(0, (x,y) -> x+y);
				.reduce(0, Integer::sum);
	}

}
