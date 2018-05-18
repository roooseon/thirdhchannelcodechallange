package thirdChannel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ReadandCreateNewFile {

	public void createNewFile(File inputFile, File template) {
		String personName = "";
		BufferedReader bffReader = null;
		String str;

		// catch exception on template
		try {
			bffReader = new BufferedReader(new FileReader(template));
		} catch (FileNotFoundException e) {
			System.out.println("Template not found");
			System.exit(0);
		}

		// catch no file found exception on input file
		try {
			bffReader = new BufferedReader(new FileReader(inputFile));
		} catch (FileNotFoundException e) {
			System.out.println("Input file not found");
			System.exit(0);
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		
		// search for name in input file
		try {
			while ((str = bffReader.readLine()) != null)
				if (str.contains("name")) {
					String temp = str.substring(str.lastIndexOf("=") + 1);
					personName = temp.trim();
					personName = personName.replaceAll("\\s+", " ");
				}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// only if name is found app will call writeNewFile method
		if (!(personName.equals(null) || personName.equals(""))) {
			writeNewFile(template, personName);
		} else {
			System.out.println("No name found");
			System.exit(0);
		}
	}

	public static void writeNewFile(File template, String personName) {

		File file = template;
		String nameToReplace = "((name))";
		// creates file with unique name based on date and time
		String outputFileName = personName + new SimpleDateFormat("MMddyyyyHHmmss").format(new Date());
		String workingDirectory = System.getProperty("user.dir");
		try (PrintWriter writer = new PrintWriter(workingDirectory + "\\Output\\" + outputFileName);

				Scanner scanner = new Scanner(file)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				writer.println(line.replace(nameToReplace, personName));

			}
		} catch (Exception e) {
			System.out.println("Template not found");
			System.exit(0);
		}
	}

}
