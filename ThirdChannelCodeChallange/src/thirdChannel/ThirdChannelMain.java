package thirdChannel;

import java.io.File;
import java.io.IOException;

public class ThirdChannelMain {

	public static void main(String[] args) throws IOException {

		ReadandCreateNewFile readInputFile = new ReadandCreateNewFile();
		
		String workingDirectory = System.getProperty("user.dir");		
		File inputFile1 = new File(workingDirectory + "\\Input\\1");
		File inputFile2 = new File(workingDirectory + "\\Input\\2");
		File inputFile3 = new File(workingDirectory + "\\Input\\3");
		File inputFile4 = new File(workingDirectory + "\\Input\\4");
		File inputFile5 = new File(workingDirectory + "\\Input\\5");
		
		File template = new File(workingDirectory + "\\Template\\template");

		readInputFile.createNewFile(inputFile1, template);
		readInputFile.createNewFile(inputFile2, template);
		readInputFile.createNewFile(inputFile3, template);
		readInputFile.createNewFile(inputFile4, template);
		readInputFile.createNewFile(inputFile5, template);
		

	}

}