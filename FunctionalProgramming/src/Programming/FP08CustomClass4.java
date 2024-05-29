package Programming;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class FP08CustomClass4{

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
		
		//group by catagory
		System.out.println(
				courses.stream()
						.collect(Collectors.groupingBy(Course::getCatagory))
				);
		//{Cloud=[AWS:14000:99, Azure:16000:93, Docker:25000:99, Kubernetes:22000:91],
		//Freamework=[Spring:20000:98, Spring Boot:18000:95], 
		//FullStack=[FullStack:25000:96], Microservies=[API:20000:97, Microservices:22000:98]}

		System.out.println(
				courses.stream()
						.collect(Collectors.groupingBy(Course::getCatagory, Collectors.counting()))
				);
		//{Cloud=4, Freamework=2, FullStack=1, Microservies=2}
		
		System.out.println(
				courses.stream()
						.collect(Collectors.groupingBy(Course::getCatagory, 
								Collectors.maxBy(Comparator.comparingInt(Course::getReviewScore))))
				);
		//{Cloud=Optional[AWS:14000:99], Freamework=Optional[Spring:20000:98],
		//FullStack=Optional[FullStack:25000:96], Microservies=Optional[Microservices:22000:98]}
		
		System.out.println(
				courses.stream()
						.collect(Collectors.groupingBy(Course::getCatagory,
								Collectors.mapping(Course::getName, Collectors.toList())))
				);
		//{Cloud=[AWS, Azure, Docker, Kubernetes], Freamework=[Spring, Spring Boot], 
		// FullStack=[FullStack], Microservies=[API, Microservices]}
		


	}

}
  