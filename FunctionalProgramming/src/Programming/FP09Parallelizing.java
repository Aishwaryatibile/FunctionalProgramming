package Programming;

import java.util.stream.LongStream;

public class FP09Parallelizing {
	
	public static void main(String[] args) {
		
		long time = System.currentTimeMillis();
		
		//0, 1000000000
//		System.out.println(LongStream.range(0, 1000000000).sum());//499999999500000000
//		System.out.println(System.currentTimeMillis()-time);//performance time - 848 ms
		
		//in parallel, java actually split the stream into multiple parts and execute these operations on those multiple parts 
		//and finally, combine the result of all those multiple parts.
		System.out.println(LongStream.range(0, 1000000000).parallel().sum());
		System.out.println(System.currentTimeMillis()-time); //599 ms
		
	}

}
