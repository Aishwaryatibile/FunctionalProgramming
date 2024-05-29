package Programming;

import java.util.List;
import java.util.stream.Stream;

public class FP01Functional {

	public static void main(String[] args) {

		List<Integer> numbers = List.of(6, 2, 11, 78, 3, 9, 44, 24);
		List<String> courses = List.of("Spring", "Spring boot", "Azure", "Kubernetes", "Docker", "API", "Microservices");

//		PrintAllNumbers(numbers);
//		PrintEvenNumbers(numbers);
		PrintSquareOfOddNumbers(numbers);
//		PrintAllCourses(courses);
	}

	private static void PrintAllCourses(List<String> courses) {
		courses.stream()
				.filter(course -> course.length() >= 4)
				.map(coourse -> coourse + " " + coourse.length())
				.forEach(System.out::println);
	}

//	private static void print(int number)
//	{
//		System.out.println(number);
//	}

	private static void PrintAllNumbers(List<Integer> numbers) {
		numbers.stream().forEach(System.out::println);// method reference
//			.forEach(FP01Functional::print);
	}

	private static void PrintEvenNumbers(List<Integer> numbers) {
		numbers.stream()
				.filter(number -> number % 2 == 0)// filter even numbers using lamda expression
				.forEach(System.out::println);
	}

	private static void PrintSquareOfOddNumbers(List<Integer> numbers) {
		numbers.stream()
			   .filter(number -> number % 2 != 0)// filter even numbers using lamda expression
			   .map(number -> number * number)
			   .forEach(System.out::println);
	}

}
