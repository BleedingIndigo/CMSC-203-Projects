package cmsc203;

import java.util.Scanner;

public class MovieDriver {
	
public static void main(String[] cmsc) {
	
	  Scanner keyboard = new Scanner(System.in);

      String continueInput = "y";

      while (continueInput.equalsIgnoreCase("y")) {

          System.out.print("Enter the title of a movie: ");
          String title = keyboard.nextLine();

          System.out.print("Enter the movie's rating: ");
          String rating = keyboard.nextLine();

          System.out.print("Enter the number of tickets sold at a theater: ");
          int soldTickets = keyboard.nextInt();

          keyboard.nextLine();

          Movie movie = new Movie(title, rating, soldTickets);

          System.out.println("Movie title: " + movie.getTitle());
          System.out.println("Movie rating: " + rating);
          System.out.println("Number of tickets sold: " + soldTickets);

          System.out.print("Do you want to enter another movie? (y/n): ");
          continueInput = keyboard.nextLine();
      }

      keyboard.close();
      System.exit(0); 
  }
}