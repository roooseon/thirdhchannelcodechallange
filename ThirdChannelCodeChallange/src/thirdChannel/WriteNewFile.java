package thirdChannel;

import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class WriteNewFile {

	public void writeNewFile(File template, String personName) {

		File file = template;
		String nameToReplace = "((name))";
		String outputFileName = personName + new SimpleDateFormat("MMddyyyyHHmmss").format(new Date());

		if (!(personName.equals(null) || personName.equals(""))) {

			try (PrintWriter writer = new PrintWriter(
					"C:\\Users\\Rojan\\Documents\\ThirdChannel\\Output\\" + outputFileName);

					Scanner scanner = new Scanner(file)) {
				while (scanner.hasNextLine()) {
					String line = scanner.nextLine();
					writer.println(line.replace(nameToReplace, personName));

				}
			} catch (Exception e) {
				System.out.println("Template not found");
			}
		}

		else {
			System.out.println("");
		}

	}
}
