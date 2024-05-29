package Programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortListByTwoFields {
	
	public static void main(String[] args) {
		List<Book> booklist = new ArrayList<>() ;
		booklist.add(new Book("Core Java","Kathy Sierra",1065.5));
		booklist.add(new Book("Core Java","Gary Cornell",1749.0));
		booklist.add(new Book("Core Java","Craig Walls",940.75));
		booklist.add(new Book("Angular","Freeman",1949.25));
		booklist.add(new Book("Angular","Freeman",2317.09));
		booklist.add(new Book("Angular","Freeman",889.25));
		
		//System.out.println(booklist);
		
		//create comparators for Name authour and cost field respectively	
		System.out.println("\nSort list of book objects by name then by author then by cost");
		Comparator<Book> sortByName =(b1,b2) -> b1.getName().compareToIgnoreCase(b2.getName());
		Comparator<Book> sortByAuthor =(b1,b2) -> b1.getAutour().compareToIgnoreCase(b2.getAutour());
		Comparator<Book> sortByCost =(b1,b2) -> Double.compare(b1.getCost(), b2.getCost());
		
		//sort by name then sort by author then sort by cost
		booklist.stream().sorted(sortByName.thenComparing(sortByAuthor).thenComparing(sortByCost))
		.forEach(book -> System.out.println(book));
		
		System.out.print(booklist.stream().collect(Collectors.groupingBy(Book::getAutour)));
	}

}
