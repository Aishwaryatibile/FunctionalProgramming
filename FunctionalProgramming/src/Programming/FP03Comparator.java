package Programming;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;

//Comaprators to sort streams with sorted

public class FP03Comparator {
	
	public static void main(String[] args) {
		 List<String> courses = List.of("Spring", "Spring boot", "Azure", "Kubernetes", "Docker", "API","API","Microservices");
		 
		 System.out.println("Elements are compared and sorted in natural order");
		 courses.stream()
		 		.sorted(Comparator.naturalOrder())
		 		.distinct()
		 		.forEach(System.out::println);
		 
		 System.out.println(""); 
		 System.out.println("Elements are compared and sorted in reverse order");
		 courses.stream()
	 		.sorted(Comparator.reverseOrder())
	 		.distinct()
	 		.forEach(System.out::println);
		 
		 String colum1Format ="%-3.3s";
		 String colum2Format ="%-8.8s";
		 String formatInfo =colum1Format+" "+colum2Format;
		 System.out.println("\nElements are compared and sorted in order of length of their strings");
		 courses.stream()
	 		.sorted(Comparator.comparing(str -> str.length()))
	 		.distinct()
	 		.map(str -> str.length()+"\t"+str)
	 		.forEach(System.out::println);
		 
	}

}
