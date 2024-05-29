package Programming;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

//Collecting stream elements to List using collect

public class FP04Collect {
	
	public static void main(String[] args) {
		List<Integer> numbers = List.of(6, 2, 11, 78, 3, 9, 44);

		List<Integer> squaredNmubers = squareList(numbers);
		System.out.println("list of squared numbers: " +squaredNmubers);
		
//		List<Integer> evenNmubers = evenList(numbers);
		System.out.println();
		System.out.println("even numbers are :");
		evenList(numbers);
		
		 List<String> courses = List.of("Spring", "Spring boot", "Azure", "Kubernetes", "Docker", "API","API","Microservices");
		
		List<String> courseLenght = courseLengthList(courses);
		
		System.out.println("\n"+courseLenght);
		
	}

	private static List<String> courseLengthList(List<String> courses) {
		return courses.stream()
					  .sorted().distinct()
					  .map(course -> course+" "+course.length())
					  .collect(Collectors.toList());
	}

	private static void evenList(List<Integer> numbers) {
		 numbers.stream()
					   .filter(number -> number%2 == 0)
					   .collect(Collectors.toList())			  
					   .forEach(System.out::println);
	}

	private static List<Integer> squareList(List<Integer> numbers) {
		return  numbers.stream()
					   .map(x -> x *x)
					   .collect(Collectors.toList());		  
	}

}
