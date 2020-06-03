import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
	
	public static String genToString(String className, List<String> variables) {
		
		String toString = "@Override\n" + "public String toString() {\n" +
		"\treturn \"" + className + " [";
		
		for (int i = 0; i < variables.size(); i++) {
			//next line after so many variables
			if ((i != 0) &&  (i == 2 || i % 2 != 1)) {
				toString += "\n\t\t";
			}
			
			if (i != 0 && i != variables.size() - 1) {
				toString += "\", ";
			}
			
			if (i == variables.size() - 1) {
				toString += "\"";
			}
			
			toString += variables.get(i) + "=\" + " + variables.get(i) + " + ";
		}
		
		toString += "\"]\";" + "\n}";
		
		return toString;
	}

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		boolean anotherClass = true;
		String className = "";
		List<String> varNames = new ArrayList<>();
		String toString = "";

		//Title and instructions
		System.out.println("\n*ToString Generator*\n\n" + 
		"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"
		+ "\nUse this to automatically generate "
		+ "a custom toString() method for a class.\n(Be careful about spelling.)\n"
		+ "\nThis will generate the ENTIRE toString() method.\n" 
		+"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		System.out.println("\nImportant Note:\nType 'Q' at any time to stop entering "
				+ "variables \nand generate the 'toString'.");
		
		//If they enter "y" or "Y", quit getting classes
		do {
			//get class name
			System.out.print("\nClass name: ");
			className = scan.nextLine();
			
			System.out.println();
			//If they enter "q" or "Q", quit getting variables
			int i = 1; //counter
			String var = "";
			while (!var.equals("Q") && !var.equals("q")) {
				
				//get next variable name
				System.out.print("Variable " + i + ": ");
				i++;
				var = scan.nextLine();
				
				if (!var.equals("Q") && !var.equals("q")) {
					varNames.add(var);
				}
				
			}
			
			
			//generate the toString
			toString = genToString(className, varNames);
			
			//Show result
			System.out.println("\nHere is your toString:\n");
			System.out.println(toString);
			
			//See if user wants to generate another
			System.out.print("\nWould you like to generate another toString? (y/n): ");
			String cont = scan.nextLine();
			if (!cont.startsWith("y") && !cont.startsWith("y")) {
				anotherClass = false;
			}
			
			//reset variables
			className = "";
			varNames.clear();
			toString = "";
		} while (anotherClass = true);

	}

}
