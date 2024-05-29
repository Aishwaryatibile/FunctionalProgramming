package Programming;

import java.util.List;
import java.util.function.Supplier;

public class FP07MethodReferences {

	private  void print(String str) {
		System.out.println(str);
	}

	public static void main(String[] args) {
		List<String> courses = List.of("Spring", "Spring boot", "Azure", "Kubernetes", "Docker", "API",
				"Microservices");

		courses.stream()
		//map(str -> str.toUpperCase())
		.map(String::toUpperCase)//non static method reference
		.forEach(new FP07MethodReferences()::print);//non static method reference
		
		Supplier<String> supplier  =  String::new;//constructor reference - we can use it to create new obj
		System.out.println(supplier);
	}

}
