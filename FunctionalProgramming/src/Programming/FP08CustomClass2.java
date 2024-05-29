package Programming;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class FP08CustomClass2{

	public static void main(String[] args) {
		
		//when we are comparing the primitive it is better to use comparingInt/thenComparingInt because no need of boxing and auto boxing

		List<Course> courses =List.of(
				new Course("Spring","Freamework",98,20000),
				new Course("Spring Boot","Freamework",95,18000),
				new Course("API","Microservies",97,20000),
				new Course("Microservices","Microservies",98,22000),
				new Course("FullStack","FullStack",96,25000),
				new Course("AWS","Cloud",99,14000),
				new Course("Azure","Cloud",93,16000),
				new Course("Docker","Cloud",98,20000),
				new Course("Kubernetes","Cloud",91,22000)
				);
		
		//skip -- skip the no of elements
		//limit-- take specific no. of elements
		
		//second highest no of students using stream
		Comparator<Course> secondHighest = Comparator.comparingInt(Course::getNoOfStudents)
													 .thenComparing(Course::getName)
													 .reversed();
		System.out.println(courses.stream()
								  .sorted(secondHighest)
								  .skip(1)
								  .findFirst());
		
		//System.out.println(courses.stream().sorted(Comparator.comparing(Course::getNoOfStudents).reversed()).skip(1).findFirst());
		
		//print 1st five courses
		System.out.println(
				courses.stream()
						.limit(5)
						.collect(Collectors.toList())
				);
		
		//take 1st 5 and among them skip top 3 results -[Microservices:22000:98, FullStack:25000:96]
		System.out.println(
				courses.stream()
						.limit(5)
						.skip(3)
						.collect(Collectors.toList())
				);
		
		//skip 1st 3 and after that take 5
		System.out.println(
				courses.stream()
						.skip(3)
						.limit(5)	
						.collect(Collectors.toList())
				);
		
	//	System.out.println(courses);
		
		//takeWhile - take elements until the condition is true after that break/skip
		System.out.println(
				courses.stream()
					   .takeWhile(course -> course.getReviewScore() >=95)
					   .collect(Collectors.toList())
				);
		//[Spring:20000:98, Spring Boot:18000:95, API:20000:97, Microservices:22000:98, FullStack:25000:96, AWS:14000:99]

		
		//dropWhile - as long as the condition is true it will skip
		System.out.println(
				courses.stream()
				  	   .dropWhile(course -> course.getReviewScore() >= 95)
				  	   .collect(Collectors.toList())
				);
		//[Azure:16000:93, Docker:20000:98, Kubernetes:22000:91]

		
		
		
		
		
	}

}
  