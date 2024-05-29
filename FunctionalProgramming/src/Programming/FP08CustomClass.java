package Programming;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
	private String name;
	private String catagory;
	private int reviewScore;
	private int noOfStudents;

	public Course(String name, String catagory, int reviewScore, int noOfStudents) {
		super();
		this.name = name;
		this.catagory = catagory;
		this.reviewScore = reviewScore;
		this.noOfStudents = noOfStudents;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	public int getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}

	public int getNoOfStudents() {
		return noOfStudents;
	}

	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}

	public String toString() {
		return name + ":" + noOfStudents + ":" + reviewScore;
	}

}

public class FP08CustomClass {

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
		
		//allMatch - true if every element in the stream matches the condition
		//noneMatch - true if no element in the stream matches the condition
		//anyMatch - true if at least one element in the stream matches the condition
		
		Predicate<Course> reviewCourseGreaterThan95Percentpredicate = course -> course.getReviewScore() > 95;
		Predicate<Course> reviewCourseGreaterThan90Percentpredicate = course -> course.getReviewScore() > 90;
		Predicate<Course> reviewCourseLessThan90Percentpredicate = course -> course.getReviewScore() < 90;
	
//		System.out.println(	courses.stream().allMatch(reviewCourseGreaterThan90Percentpredicate ));
//																																				
//		System.out.println(	courses.stream().noneMatch(reviewCourseLessThan90Percentpredicate ));
//																						
//		System.out.println(courses.stream().anyMatch(reviewCourseLessThan90Percentpredicate));
//		
//		System.out.println(courses.stream().anyMatch(reviewCourseGreaterThan90Percentpredicate));
		
		Predicate<  Course> noOfStudentsGreaterThan15000Predicate = course -> course.getNoOfStudents() > 15000;
		Predicate<  Course> noOfStudentsGreaterThan20000Predicate = course -> course.getNoOfStudents() > 20000;
		Predicate<  Course> noOfStudentsLessThan13000Predicate = course -> course.getNoOfStudents() < 13000;
		
		System.out.println(courses.stream().allMatch(noOfStudentsGreaterThan15000Predicate));
		System.out.println(courses.stream().anyMatch(noOfStudentsGreaterThan20000Predicate));
		System.out.println(courses.stream().noneMatch(noOfStudentsLessThan13000Predicate));

		Comparator<Course> comparingByNoOfStudents = Comparator.comparingInt(Course::getNoOfStudents);
		
		Comparator<Course> comparingByReview = Comparator.comparingInt(Course::getReviewScore);
		Comparator<Course> comparingByMaxNoOfStudents = Comparator.comparing(Course::getNoOfStudents).reversed();

		
	//	System.out.println(courses.stream().sorted(comparingByNoOfStudents).collect(Collectors.toList()));
	//[AWS:14000:99, Azure:16000:93, Spring Boot:18000:95, Spring:20000:98, API:20000:97, Docker:20000:98, Microservices:22000:98, 	Kubernetes:22000:91, FullStack:25000:96]
		
		
		System.out.println(courses.stream()
								  .sorted(comparingByReview)
								  .collect(Collectors.toList()));
// [Kubernetes:22000:91, Azure:16000:93, Spring Boot:18000:95, FullStack:25000:96, API:20000:97, Spring:20000:98, Microservices:22000:98, Docker:20000:98, AWS:14000:99]

		System.out.println(courses.stream()
								  .sorted(comparingByMaxNoOfStudents)
								  .collect(Collectors.toList()));
		
		Comparator<Course> comparingByStudentThenByReview = Comparator.comparingInt(Course::getNoOfStudents)
																      .thenComparingInt(Course::getReviewScore)
																      .reversed();
		
		System.out.println(courses.stream()
								  .sorted(comparingByStudentThenByReview)
								  .collect(Collectors.toList()));
//		[FullStack:25000:96, Microservices:22000:98, Kubernetes:22000:91, Spring:20000:98, Docker:20000:98, API:20000:97, Spring Boot:18000:95, Azure:16000:93, AWS:14000:99]


		
	}

}
