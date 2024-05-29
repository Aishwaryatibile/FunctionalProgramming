package Programming;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class FP08CustomClass3{

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
				new Course("Docker","Cloud",99,25000),
				new Course("Kubernetes","Cloud",91,22000)
				);
		
		Predicate<Course> reviewScoreLessThan90Predicate = course -> course.getReviewScore() < 90;
		Predicate<Course> reviewScoreGreaterThan95Predicate = course -> course.getReviewScore() > 95;
		courses.stream().anyMatch(reviewScoreLessThan90Predicate);
		
		Comparator<Course> comparingByNoofStudentsAndNoOfreviews = Comparator.comparingInt(Course::getNoOfStudents)
																			 .thenComparingInt(Course::getReviewScore);
		
		System.out.println(courses.stream()
								  .sorted(comparingByNoofStudentsAndNoOfreviews)
								  .collect(Collectors.toList())) ;
		System.out.println(
				courses.stream()
				   		.max(comparingByNoofStudentsAndNoOfreviews)
				);
		//Optional[Docker:25000:99]

		System.out.println(
				courses.stream()
				   		.min(comparingByNoofStudentsAndNoOfreviews)
				);
		//Optional[AWS:14000:99]

		//optional - if value is null then it might create null pointer exception 
		//			so using optional we can return empty back or we set values as default
		System.out.println(
				courses.stream()
					   .filter(reviewScoreLessThan90Predicate)
					   .min(comparingByNoofStudentsAndNoOfreviews)
					   .orElse(new Course("Spring Boot", "framework", 97, 20000))
				);
		//Optional.empty
		//Spring Boot:20000:97
		
		System.out.println(courses.stream()
				  .sorted(comparingByNoofStudentsAndNoOfreviews)
				  .findFirst()
					);
		//Optional[AWS:14000:99]

		System.out.println(courses.stream()
				  .sorted(comparingByNoofStudentsAndNoOfreviews)
				  .findAny()
					);
		//Optional[AWS:14000:99]
		
		System.out.println(
				courses.stream()
						.filter(reviewScoreGreaterThan95Predicate)
						.mapToInt(Course::getNoOfStudents)
						.sum()
				);//126000
		
		System.out.println(
				courses.stream()
						.filter(reviewScoreGreaterThan95Predicate)
						.mapToInt(Course::getNoOfStudents)
						.average()//OptionalDouble[21000.0]
				);//OptionalDouble[21000.0]
		
		System.out.println(
				courses.stream()
						.filter(reviewScoreGreaterThan95Predicate)
						.mapToInt(Course::getNoOfStudents)
						.count()
				);//6
		
		System.out.println(
				courses.stream()
						.filter(reviewScoreGreaterThan95Predicate)
						.mapToInt(Course::getNoOfStudents)
						.max()
				);//OptionalInt[25000]   
		
	
		
		//Higher Order Function - a function thet returns a function as a return value
		
		Predicate<Course> reviewScoreLessThan90Predicate2 = 
				createPredicateWithCutOffReviewScore(90);
				
		Predicate<Course> reviewScoreLessThan95Predicate2 
			= createPredicateWithCutOffReviewScore(95);

		
	}

	private static Predicate<Course> createPredicateWithCutOffReviewScore(int cutOffReviewScore) {
		return course -> course.getReviewScore() < cutOffReviewScore;
	}

}
  