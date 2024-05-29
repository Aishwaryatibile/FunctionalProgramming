package Programming;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DuplicateEmployeeCount {
	
	public static void main(String[] args) {
		
		List<Employee> empList = List.of(
				new Employee("1","PRADEEP","H.R", 28),
				new Employee("2","ASHOK","H.R", 28),
				new Employee("3","PRADEEP","H.R", 28),
				new Employee("4","SANTOSH","H.R", 28),
				new Employee("5","ASHOK","H.R", 28));
		
		Map<String, Long> nameCount = empList.stream().collect(Collectors.groupingBy(Employee::getName, Collectors.counting()));
		System.out.println(nameCount);
		
		//duplicate Employee name
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(Employee e: empList) {
			if(!map.containsKey(e.getName())) {
				map.put(e.getName(), 1);
			}else {
				map.put(e.getName(),map.get(e.getName())+1);
			}
		}
		
		System.out.println(map);
			
		String s ="tcsinterview";
		Long count = s.chars().filter(i -> i == 'a' ||i == 'e' ||i == 'i' ||i == 'o' ||i == 'u').count();
		System.out.println("Total no. of vowels are "+count);
		
		String reverse = Stream.of(s).map(word -> new StringBuilder(word).reverse()).collect(Collectors.joining(" "));
		System.out.println("Reverse String is "+ reverse);
				
		
		Map<Integer, String> map1 = new HashMap<>();
		map1.put(1,"Aishwarya");
		map1.put(2,"Pratham");
		
//		Iterator<Integer> it =map1.keySet().iterator();	
//		while(it.hasNext()) {
//			int key=(int)it.next();  
//			System.out.println(key+" "+map1.get(key));
//		}
		
		for(Map.Entry<Integer, String> entry : map1.entrySet())
		{
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
	}
}
