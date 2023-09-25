package lesson1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;


public class HelloWorld {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		System.err.println("Hello world");
		final ProcessBuilder pb = new ProcessBuilder("java","-jar","test.jar");

		pb.directory(new File("c:/users/student"));
		final Process p = pb.start();
		
		final Reader rdr = new InputStreamReader(p.getInputStream());
		final BufferedReader brdr = new BufferedReader(rdr);

		try(final Writer wr = new OutputStreamWriter(p.getOutputStream())) {
			wr.write("test string\n");
			wr.flush();
		}
		
		String result ;
		
		while ((result = brdr.readLine()) != null) {
			System.err.println("line: "+result);
		}
		
		int rc = p.waitFor();
		System.err.println("The end");
	}

}
