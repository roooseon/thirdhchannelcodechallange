package thirdChannel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.HashMap;


public class ReadandCreateNewFile {

	// This methods calls scanFile and writeNewFileWithChanges methods accordingly
	public void makeChanges(File inputFileDataToChange, String[] change, File template) {

		// HashMap returned with data to change and it's corresponding value by
		// scanFile method
		HashMap<String, String> dataChanged = scanFile(inputFileDataToChange, change, template);

		/*
		 * this calls writeNewFileWithChanges only if all data required data are
		 * found in input file to be written in a new output file otherwise a
		 * new empty file is written directly
		 */
		if (dataChanged.size() == change.length + 1) {
			writeNewFileWithChanges(template, dataChanged);
		} else {
			try {
				String workingDirectory = System.getProperty("user.dir");
				FileWriter writer = new FileWriter(workingDirectory + "\\Output\\" + dataChanged.get("fileName"));
				writer.write("");
				writer.close();
			} catch (IOException err) {
				System.out.println("Write error");
			}
		}
	}

	// This method scans the source file for data and returns HashMap with
	private static HashMap<String, String> scanFile(File inputFileDataToChange, String[] changesToMake, File template) {

		
		BufferedReader bffReader = null;
		BufferedReader bffReader2 = null;

		

		// HashMap to store dataToChange e.g. name, gift etc and it's
		// corresponding value
		HashMap<String, String> dataChanged = new HashMap<>();

		// catch exception on template
		try {
			bffReader = new BufferedReader(new FileReader(template));
		} catch (FileNotFoundException e) {
			System.out.println("Template not found");
			System.exit(0);
		}

		// catch no file found exception on input file
		try {
			bffReader2 = new BufferedReader(new FileReader(inputFileDataToChange));
		} catch (FileNotFoundException e) {
			System.out.println("Input file not found");
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// file name for new output file
		dataChanged.put("fileName", inputFileDataToChange.getName());

		//Read input file with data
		String stringsFromInputFile;
		try {
			while ((stringsFromInputFile = bffReader2.readLine()) != null) {

				for (int i = 0; i < changesToMake.length; i++) {

					// 
					if (stringsFromInputFile.contains(changesToMake[i])) {
						// string after equals (=) in input file
						String tempAfterEquals = stringsFromInputFile.substring(stringsFromInputFile.lastIndexOf("=") + 1);

						// string before equals (=) in input file
						String tempBeforeEquals = stringsFromInputFile.substring(0, stringsFromInputFile.lastIndexOf("="));
						tempAfterEquals = tempAfterEquals.trim();
						tempAfterEquals = tempAfterEquals.replaceAll("\\s+", " ");
						
						tempBeforeEquals = tempBeforeEquals.trim();
						tempBeforeEquals = tempBeforeEquals.replaceAll("\\s+", " ");
						
						// check word match
						if (tempBeforeEquals.equals(changesToMake[i])) {
							dataChanged.put(changesToMake[i], tempAfterEquals);
						}

					}

				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return dataChanged;

	}

	// this method writes changed data to a new output file
	private static void writeNewFileWithChanges(File template, HashMap<String, String> data) {
		File file = template;
		String outputFileName = data.get("fileName").toString();
		String workingDirectory = System.getProperty("user.dir");

		String oldTextFromTemplate = "";

		//this reads template
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = "";
			while ((line = reader.readLine()) != null) {
				oldTextFromTemplate += line + "\r\n";
			}
			reader.close();

		} 
		// catches error while reading template
		catch (Exception err) {
			System.out.println("Error occured while reading template file");
		}
		
		
		//writes changes on a new output file
		try {
			String result = oldTextFromTemplate;
			for (String hMapValue : data.keySet()) {

				String key = hMapValue.toString();
				String value = data.get(hMapValue).toString();

				if (!(value.equals(null)) || !(value.equals(""))) {
					oldTextFromTemplate = result;
					result = oldTextFromTemplate.replace(("((" + key + "))"), value);
				} else {
					result = "";
				}
			}

			
			FileWriter writer = new FileWriter(workingDirectory + "\\Output\\" + outputFileName);
			writer.write(result);
			writer.close();
			
		//catches errors while on writing new output file
		} catch (Exception err) {
			System.out.println("Write error");
		}

	}

}