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
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FP05FunctionalInterfacesPrimitive {

	public static void main(String[] args) {

		List<Integer> numbers = List.of(6, 2, 11, 78, 3, 9, 44);
		List<String> courses = List.of("Spring", "Spring boot", "Azure", "Kubernetes", "Docker", "API","Microservices");

		Predicate<Integer> isEvenPredicate = x -> x % 2 == 0;

		Function<Integer, Integer> squareFunction = x -> x * x;
		
		Function<Integer, String> stringFunction = x -> x+"";//integer is input and string will be output
		
		Function< String,String> StringOutputFunction = x -> x+"";
		
//		Consumer<Integer> sysoutConsumer = System.out::println;// taking an input and giving np otput back(returning void is ouput)
//		Consumer<String> sysoutConsumer1 = System.out::println;
		
		BinaryOperator<Integer> sumBinaryOperator1 = (x,y) ->x+y;//take two parameters of same type returns a value of same type
		//all operators all the input and output are of the same type
       		
		
		//when we use wrapper classess boxing and unboxing comes in picture 
		//if we have set of primitives we can use primitive functional interfaces
		IntBinaryOperator intBinaryOperator = (x,y) -> x+y;
		
		
		

		
	}

}
