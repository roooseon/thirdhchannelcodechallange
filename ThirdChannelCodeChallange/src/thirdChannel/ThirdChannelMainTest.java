	package thirdChannel;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class ThirdChannelMainTest {
	
	@Test
	public void assertReaders() throws IOException {
		String workingDirectory = System.getProperty("user.dir");

		BufferedReader expected = new BufferedReader(new FileReader(workingDirectory + "\\Output\\1"));
		BufferedReader actual = new BufferedReader(new FileReader(workingDirectory + "\\Expected\\1"));
		
		  String expectedLine;
		  while ((expectedLine = expected.readLine()) != null) {
		    String actualLine = actual.readLine();
		    assertNotNull("Expected had more lines then the actual.", actualLine);
		    assertEquals(expectedLine, actualLine);
		  }
		  assertNull("Actual had more lines then the expected.", actual.readLine());
		}
	
	@Test
	public void assertReaders2() throws IOException {
		String workingDirectory = System.getProperty("user.dir");

		BufferedReader expected = new BufferedReader(new FileReader(workingDirectory + "\\Output\\2"));
		BufferedReader actual = new BufferedReader(new FileReader(workingDirectory + "\\Expected\\2"));
		
		  String expectedLine;
		  while ((expectedLine = expected.readLine()) != null) {
		    String actualLine = actual.readLine();
		    assertNotNull("Expected had more lines then the actual.", actualLine);
		    assertEquals(expectedLine, actualLine);
		  }
		  assertNull("Actual had more lines then the expected.", actual.readLine());
		}
	
	
	@Test
	public void assertReaders4() throws IOException {
		String workingDirectory = System.getProperty("user.dir");

		BufferedReader expected = new BufferedReader(new FileReader(workingDirectory + "\\Output\\4"));
		BufferedReader actual = new BufferedReader(new FileReader(workingDirectory + "\\Expected\\4"));
		
		  String expectedLine;
		  while ((expectedLine = expected.readLine()) != null) {
		    String actualLine = actual.readLine();
		    assertNotNull("Expected had more lines then the actual.", actualLine);
		    assertEquals(expectedLine, actualLine);
		  }
		  assertNull("Actual had more lines then the expected.", actual.readLine());
		}
}


