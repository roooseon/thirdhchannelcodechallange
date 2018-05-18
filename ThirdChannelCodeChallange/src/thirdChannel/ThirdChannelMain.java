package thirdChannel;

import java.io.File;
import java.io.IOException;

public class ThirdChannelMain {

	public static void main(String[] args) throws IOException {

		ReadFile readInputFile = new ReadFile();
		WriteNewFile writeOutputFile = new WriteNewFile();

		
		File inputFile = new File("C:\\Users\\Rojan\\Documents\\ThirdChannel\\Input\\5");
		File template = new File("C:\\Users\\Rojan\\Documents\\ThirdChannel\\Template\\template");

		String personName = readInputFile.getPersonName(inputFile);
		writeOutputFile.writeNewFile(template, personName);

		

	}

}