/**
 * @author Luis Barrera
 * 
 * Eric Pogue is the author of:
 * HttpRequest.java
 * 
 * Nathaniel Wascher assisted us by allowing us to view his code
 * 
 */

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class sak {
    public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

        System.out.println("Now executing sak program...");

		if (args.length == 0) {
			HelpCommand.helpOutput();
		}

        else if (args[0].equalsIgnoreCase("-Help")) {
			System.out.println("-Help is now being executed...");
			HelpCommand.helpOutput();
		}

		else if (args[0].equalsIgnoreCase("-HttpRequest")) {
			if (args.length == 1) {
				System.out.println("Error... Please enter a valid URL");
			}else{
				System.out.println("\nPlease execute the same command again");
				int i;
				String link = args[1];
				HttpRequest request = new HttpRequest();
				for (i = 0; i < 1; i++) {
					String userText = scan.nextLine();
					System.out.println(userText);
					if (userText.contains("-HttpRequest")) {
						System.out.println("-HttpRequest is now being executed...");
						long startExecuting = System.nanoTime();
						request.readURL(link);
						long finishExecuting = System.nanoTime();
						System.out.println("\nYou entered: " + request);
						System.out.println("\nFunction execution time: " + (finishExecuting - startExecuting)/1000000 + " milliseconds");
						System.out.println("");
					}
					else {
						System.out.println("Error... Please enter a valid URL");
					}
				}
			}
		}
		
		else if (args[0].equalsIgnoreCase("-HttpRequestIndex")) {
			if (args.length == 1) {
				System.out.println("Error... Please enter a valid URL");
			}else{
				System.out.println("\nPlease execute the same command again");
				int i;
				String link = args[1];
				HttpRequest request = new HttpRequest();
				for (i = 0; i < 1; i++) {
					String userText = scan.nextLine();
					System.out.println(userText);
					if (userText.contains("-HttpRequestIndex")) {
						System.out.println("-HttpRequestIndex is now being executed...");
						long startExecuting = System.nanoTime();
						request.readURL(link);
						long finishExecuting = System.nanoTime();
						System.out.println("\nYou entered: " + request);
						System.out.println("\nFunction execution time: " + (finishExecuting - startExecuting)/1000000 + " milliseconds");
						System.out.println("");
					}
					else {
						System.out.println("Error... Please enter a valid URL");
					}
				}
			}
		}
	}
}