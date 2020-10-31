
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class SelectGoodies {

	public static void main(String[] args) {
		try {

			FileWriter myWriter = new FileWriter("C:\\Users\\user\\Desktop\\sample_output.txt");

			System.out.println("Enter Number of the employees :");
			Scanner scan = new Scanner(System.in);
			
			int totalEmployees = scan.nextInt();
			
			Random rand = new Random();
			File readTextFile = new File("C:\\Users\\user\\Desktop\\sample_input.txt");
			Scanner sc = new Scanner(readTextFile);
			ArrayList<String> goodiesList = new ArrayList<String>();

			while (sc.hasNextLine()) {
				if (!sc.nextLine().toUpperCase().startsWith("Goodies")
						&& !sc.nextLine().toUpperCase().startsWith("Number")) {
					goodiesList.add(sc.nextLine());
				}

			}

			ArrayList<String> selectedGoodiesList = new ArrayList<String>();
			int randomIndex;
			for (int i = 0; i < totalEmployees; i++) {
				randomIndex = rand.nextInt(goodiesList.size());
				selectedGoodiesList.add(goodiesList.get(randomIndex));
			}

			ArrayList<Integer> goodiesPriceList = new ArrayList<Integer>();
			String textToDisplay ="The goodies selected for distribution are:";
			System.out.println(textToDisplay);
			myWriter.write(textToDisplay);
			myWriter.write("\r\n");
			for (String string : selectedGoodiesList) {
				System.out.println(string);
				myWriter.write(string);
				myWriter.write("\r\n");
				String[] goodiesPrice = string.split(":");
				goodiesPriceList.add(Integer.parseInt(goodiesPrice[1].trim()));
			}

			int max = Collections.max(goodiesPriceList);
			int min = Collections.min(goodiesPriceList);
			String stringOutput = "And the difference between the chosen goodie with highest price and the lowest price is ";
			int toatalCost = 0;
			if (totalEmployees > 1) {
				
				toatalCost = (max - min);

			} else {
				toatalCost = max;
			}
			
			System.out.println(stringOutput + toatalCost);
			myWriter.write(stringOutput + toatalCost);
			myWriter.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}