package lesson1;

import java.io.Reader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UpperCase {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try(final Reader rdr = new InputStreamReader(System.in);
			final BufferedReader brdr = new BufferedReader(rdr)) {
			
			String result ;
			
			while ((result = brdr.readLine()) != null) {
				System.out.println(result.toUpperCase());
			}			
		}
	}

}
