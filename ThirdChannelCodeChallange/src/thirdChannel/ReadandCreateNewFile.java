package thirdChannel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;


public class ReadandCreateNewFile {

	public void createNewFile(File inputFile, File template) {
		String personName = "", product = "", gift = "", giftValue = "", representative = "";
		String fileName = inputFile.getName();
		BufferedReader bffReader = null;
		BufferedReader bffReader2 = null;
		
		String str;

		ArrayList<String> data = new ArrayList<String>();
		// catch exception on template
		try {
			bffReader = new BufferedReader(new FileReader(template));
		} catch (FileNotFoundException e) {
			System.out.println("Template not found");
			System.exit(0);
		}

		// catch no file found exception on input file
		try {
			bffReader2 = new BufferedReader(new FileReader(inputFile));
		} catch (FileNotFoundException e) {
			System.out.println("Input file not found");
			System.exit(0);
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		// search for name in input file
		try {
			while ((str = bffReader2.readLine()) != null)
				if (str.contains("name")) {
					String temp = str.substring(str.lastIndexOf("=") + 1);
					personName = temp.trim();
					personName = personName.replaceAll("\\s+", " ");
				} else if (str.contains("product")) {
					String temp2 = str.substring(str.lastIndexOf("=") + 1);
					product = temp2.trim();
					product = product.replaceAll("\\s+", " ");
				}

				else if (str.contains("gift")) {

					if (str.contains("gift-value")) {
						String temp3 = str.substring(str.lastIndexOf("=") + 1);
						giftValue = temp3.trim();
						giftValue = giftValue.replaceAll("\\s+", " ");
					} else {
						String temp4 = str.substring(str.lastIndexOf("=") + 1);
						gift = temp4.trim();
						gift = gift.replaceAll("\\s+", " ");
					}

				} else if (str.contains("gift")) {

				} else if (str.contains("representative")) {
					String temp5 = str.substring(str.lastIndexOf("=") + 1);
					representative = temp5.trim();
					representative = representative.replaceAll("\\s+", " ");
				}

		} catch (IOException e) {
			e.printStackTrace();
		}

		data.add(fileName);
		data.add(personName);
		data.add(product);
		data.add(gift);
		data.add(giftValue);
		data.add(representative);

		writeNewFile(template, data);
		
	}



	public static void writeNewFile(File template, ArrayList<String> data) {

		File file = template;
		String nameToReplace = "((name))";
		String productToReplace = "((product))";
		String giftToReplace = "((gift))";
		String giftValueToReplace = "((gift-value))";
		String representativeToReplace = "((representative))";
		String outputFileName = data.get(0);
		

		
		String workingDirectory = System.getProperty("user.dir");
	
		for (String d : data) {
			if (!(d.equals(null) || d.equals(""))) {
				try {				    
				    BufferedReader reader = new BufferedReader(new FileReader(file));
				    String line = "", oldtext = "";
				    while ((line = reader.readLine()) != null) {
				        oldtext += line + "\r\n";
				    }
				    reader.close();
				    
				    String result = oldtext.replace(nameToReplace, data.get(1))
		                    .replace(productToReplace, data.get(2))
		                    .replace(giftToReplace, data.get(3))
		                    .replace(giftValueToReplace, data.get(4))
		                    .replace(representativeToReplace, data.get(5));

				    // Write updated record to a file
				    FileWriter writer = new FileWriter(workingDirectory + "\\Output\\" + outputFileName);
				    writer.write(result);                
				    writer.close();                
				} catch (IOException ioe) {
				    ioe.printStackTrace();
				}		

			} else {
				try{
			    FileWriter writer2 = new FileWriter(workingDirectory + "\\Output\\" + outputFileName);
					writer2.write("");
					writer2.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				 
			}
		}
		
		
		
		
	}
}

