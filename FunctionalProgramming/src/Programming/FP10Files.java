package Programming;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FP10Files {

	public static void main(String[] args) throws IOException {
		
//		Files.lines(Paths.get("file.txt")) // read the file
//			 .map(str -> str.split(" ")) //array of string
//			 .flatMap(Arrays::stream) //combining arrays of stream into one
//			 .distinct()
//			 .sorted() // all uppercase sorted 1st the alll lowercase words
//			 .forEach(System.out::println);

		Files.list(Paths.get(".")) //all the files in root
			 .filter(Files::isDirectory)
			 .forEach(System.out::println);;
	}
}
