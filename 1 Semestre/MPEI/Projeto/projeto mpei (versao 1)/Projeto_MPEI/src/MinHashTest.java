import java.io.*;

public class MinHashTest {

	public static void main(String[] args) throws IOException{
		
		System.out.println("------- MinHash Test -------");
	
		MinHash min = new MinHash("MinHashTest");
		
		String str[] = min.compareSignatures();
		
		for (int i = 0; i < str.length; i++) {
			if (str[i] != null) {
				System.out.println(str[i]);
			}
		}
		
		
		
	}
}
