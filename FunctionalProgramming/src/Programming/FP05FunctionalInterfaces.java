package Programming;

/*
  Intermediate Operations :
  	map(), filter(), distinct(), sorted(), limit(), skip()
  
  Terminal Operations :
	forEach(), toArray(), reduce(), collect(), min(), max(), count(), anyMatch(), allMatch(), noneMatch(), findFirst(), findAny()
	
   boolean isEven(int x){
   		return x%2 == 0;
   	}
   	
   	int squared(int x){
   		return x*x;
   	}
   	
   	filter -> Predicate(Functional Interface) -> test(abstract method) -- check condition and output is boolean
   	map -> Function(Functional Interface) -> apply(abstract method) -- takes input costmizes it and produce output 
   	forEach -> Consumer(Functional Interface) -> accept(abstract method) -- it takes input and consumes it 
   				-- it might print it to console or sent it to utility or it might save it to database
  
   The single abstract method in Functional interace is called function descriptor
  
 */

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP05FunctionalInterfaces {

	public static void main(String[] args) {

		List<Integer> numbers = List.of(6, 2, 11, 78, 3, 9, 44);

		Predicate<Integer> isEvenPredicate = x -> x % 2 == 0;

		// internal working using abstact method in Predicate functional interface
		Predicate<Integer> isEvenPredicate2 = new Predicate<Integer>() {
			@Override
			public boolean test(Integer x) {
				return x % 2 == 0;
			}
		};

		Function<Integer, Integer> squareFunction = x -> x * x;

		Function<Integer, Integer> squareFunction2 = new Function<Integer, Integer>() {
			@Override
			public Integer apply(Integer x) {
				return x * x;
			}

		};

		Consumer<Integer> sysoutConsumer = System.out::println;

		Consumer<Integer> sysoutConsumer2 = new Consumer<Integer>() {
			@Override
			public void accept(Integer x) {
				System.out.println(x);
			}
		};

		numbers.stream()
		.filter(isEvenPredicate)
		.map(squareFunction)
		.forEach(sysoutConsumer);
		
		
		BinaryOperator<Integer> sumBinaryOperator = new BinaryOperator<Integer>() {
			@Override
			public Integer apply(Integer x, Integer y) {
				return x+y;
			}
		};
		
		  
		int sum = numbers.stream()
				.reduce(0, sumBinaryOperator);
		
		
	}

}
