package thirdChannel;

import java.io.File;
import java.io.IOException;

public class ThirdChannelMain {

	public static void main(String[] args) throws IOException {

		ReadandCreateNewFile readInputFile = new ReadandCreateNewFile();
		
		String workingDirectory = System.getProperty("user.dir");		
		File inputFile = new File(workingDirectory + "\\Input\\4");
		File template = new File(workingDirectory + "\\Template\\template2");

		readInputFile.createNewFile(inputFile, template);
		

	}

}