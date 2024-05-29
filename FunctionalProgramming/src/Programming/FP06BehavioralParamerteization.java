package Programming;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP06BehavioralParamerteization {

	public static void main(String[] args) {

		List<Integer> numbers = List.of(6, 2, 11, 78, 3, 9, 44);
 
//		System.out.println("Even number are : ");
//		filterAndPrint(numbers, x -> x%2 ==0);
//	
//		System.out.println("\nOdd number are : ");
//		filterAndPrint(numbers, x -> x%2 !=0);
//		filterAndPrint(numbers, x -> x%3 ==0);
			
//		mapAndCreateNewList(numbers, (Function< Integer,Integer>) x -> x*x);
		List<Integer> squredNumbers = mapAndCreateNewList(numbers, x -> x*x);
		List<Integer> cubedNumbers = mapAndCreateNewList(numbers, x -> x*x*x);
		List<Integer> doubledNumbers = mapAndCreateNewList(numbers, x -> x+x);
		
		System.out.println(doubledNumbers);
	}

	private static List<Integer> mapAndCreateNewList(List<Integer> numbers,
			Function< Integer, Integer> mappingFunction) {
		return numbers.stream()
		.map(mappingFunction)
		.collect(Collectors.toList());
	}

	private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate) {
		numbers.stream()
		.filter(predicate)
		.forEach(System.out::println);
	}
}
