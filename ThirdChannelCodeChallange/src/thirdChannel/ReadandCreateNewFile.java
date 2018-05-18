package thirdChannel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class ReadandCreateNewFile {

	public void createNewFile(File inputFile, File template) {
		String personName = "", product = "", gift = "", giftValue ="", representative="";
		String fileName = inputFile.getName();
		BufferedReader bffReader = null;
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
				else if (str.contains("product")){
					String temp2 = str.substring(str.lastIndexOf("=") + 1);
					product = temp2.trim();
					product = product.replaceAll("\\s+", " ");
				}
				
				else if (str.contains("gift")){
					
					if(str.contains("gift-value")){
						String temp3 = str.substring(str.lastIndexOf("=") + 1);
						giftValue = temp3.trim();
						giftValue = giftValue.replaceAll("\\s+", " ");
					}
					else{
						String temp4 = str.substring(str.lastIndexOf("=") + 1);
						gift = temp4.trim();
						gift = gift.replaceAll("\\s+", " ");	
					}
					
					
				}
				else if (str.contains("gift")){
					
				}
				else if (str.contains("representative")){
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
		
		// only if name is found app will call writeNewFile method
		
		for(String d : data){
		if (!(d.equals(null) || d.equals(""))) {
			writeNewFile(template, data);
			
		} else {
			System.out.println("Data not found");
			System.exit(0);
		}
		}
	}
	
	
	
	
	

	public static void writeNewFile(File template, ArrayList<String> data) {

		File file = template;
		String nameToReplace = "((name))";
		String productToReplace = "((product))";
		String giftToReplace = "((gift))";
		String giftValueToReplace = "((gift-value))";
		String representativeToReplace = "((representative))";
		
		// creates file with unique name based on date and time
		String outputFileName = data.get(0) + new SimpleDateFormat("MMddyyyyHHmmss").format(new Date());
		
		
		
		String workingDirectory = System.getProperty("user.dir");
		try (PrintWriter writer = new PrintWriter(workingDirectory + "\\Output\\" + outputFileName);

				Scanner scanner = new Scanner(file)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				writer.println(line.replace(productToReplace, data.get(1)));
				writer.println(line.replace(nameToReplace, data.get(2)));
				writer.println(line.replace(giftToReplace, data.get(3)));
				writer.println(line.replace(giftValueToReplace, data.get(4)));
				writer.println(line.replace(representativeToReplace, data.get(5)));

			}
		} catch (Exception e) {
			System.out.println("Destination folder not found");
		}
	}

}
