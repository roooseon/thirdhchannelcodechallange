package thirdChannel;

import java.io.File;
import java.io.IOException;

public class ThirdChannelMain {

	// this program dynamically makes the changes and writes a new output file accordingly
	public static void main(String[] args) throws IOException {

		ReadandCreateNewFile readInputFile = new ReadandCreateNewFile();
		
		String workingDirectory = System.getProperty("user.dir");
		
		// input files
		File inputFileDataToChange1 = new File(workingDirectory + "\\Input\\1");
		File inputFileDataToChange2 = new File(workingDirectory + "\\Input\\2");
		File inputFileDataToChange3 = new File(workingDirectory + "\\Input\\3");
		File inputFileDataToChange4 = new File(workingDirectory + "\\Input\\4");
		File inputFileDataToChange5 = new File(workingDirectory + "\\Input\\5");
		
		// template
		File template = new File(workingDirectory + "\\Template\\template");
		File template2 = new File(workingDirectory + "\\Template\\template2");
		
		//Changes to make 
		// Add or remove changes to make here accordingly
		String[]  change = {"name", "product", "gift", "gift-value", "representative"};
		
		//calls to make changes
		readInputFile.makeChanges(inputFileDataToChange1, change, template);
		readInputFile.makeChanges(inputFileDataToChange2, change, template);
		readInputFile.makeChanges(inputFileDataToChange3, change, template);
		readInputFile.makeChanges(inputFileDataToChange4, change, template);
		readInputFile.makeChanges(inputFileDataToChange5, change, template);
		
		/*readInputFile.makeChanges(inputFileDataToChange1, change, template);
		readInputFile.makeChanges(inputFileDataToChange2, change, template);
		readInputFile.makeChanges(inputFileDataToChange3, change, template);
		readInputFile.makeChanges(inputFileDataToChange4, change, template);
		readInputFile.makeChanges(inputFileDataToChange5, change, template);*/
		

	}

}