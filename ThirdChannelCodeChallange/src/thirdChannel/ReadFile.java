package thirdChannel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
	
	public String getPersonName(File file){
		String personName ="";
		BufferedReader bffReader = null;
		String str;
		//String name = "Name".equalsIgnoreCase("name")
		try {
			bffReader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			System.out.println("File not found");
			return "";
		}
		
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

		return personName;
	}
}
