//-----------------------------------------------------
// Title: MovieDatabase Tester class.
// Author: Hilalnur Beral ID: 11549136358
// Author: Ýrem Karpat ID: 61234117544
// Section: 01
// Assignment: This class is created in order to test our MovieDatabase class.. 
//-----------------------------------------------------

public class DBTester {
	public static void main(String[] args) {
		MovieDatabase md = new MovieDatabase();
		md.showAllMovies();
		md.addMovie("Eyes Wide Shut", "Stanley", "Kubrick", 22, 10, 1999);
		md.addMovie("Family Plot", "Alfred", "Hitchock", 9, 4, 1972);
		md.addMovie("Psycho", "Alfred", "Hitchock", 20, 5, 1960);
		md.addMovie("Sweet and Lowdown", "Woody", "Allen", 26, 1, 1999);
		md.addMovie("Midnight in Paris", "Woody", "Allen", 30, 9, 2011);
		md.addMovie("Barton Fink", "Coen", "Brothers", 21, 8, 1991);
		md.addMovie("The Interpreter", "Sydney", "Pollack", 22, 4, 2005);
		md.addMovie("The Interpreter", "Sydney", "Pollack", 22, 4, 2005);
		//md.showAllMovies();
		System.out.println();
		md.addActor("Barton Fink", "John", "Turturro", "Barton Fink");
		md.addActor("Barton Fink", "John", "Goodman", "Charlie Meadows");
		md.addActor("Barton Fink", "Judy", "Davis", "Audrey Taylor");
		md.addActor("Barton Fink", "Michael", "Lerner", "Jack Lipnick");
		md.addActor("Eyes Wide Shut", "Tom", "Cruise", " Bill Harford");
		md.addActor("Eyes Wide Shut", "Nicole", "Kidman", "Alice Harford");
		md.addActor("Eyes Wide Shut", "Madison", "Eginton", "Helena Harford");
		md.addActor("Eyes Wide Shut", "Jackie", "Sawaris", "Roz");
		md.addActor("Eyes Wide Shut", "Sydney", "Pollack", "Victor Ziegler");
		md.addActor("Midnight in Paris", "Woody", "Allen", "Woody Allen");
		md.addActor("The Interpreter", "Nicole", "Kidman", "Silvia Broom");
		md.addActor("The Interpreter", "Sean", "Penn", "Tobin Keller");
		md.addActor("The Interpreter", "Earl", "Cameron", "Zuwanie");
		System.out.println("ADDING AN ACTOR TO NON EXISTING MOVIE CAST.");
		System.out.println();
		md.addActor("Harry Potter", "Daniel", "Radcliffe", "Harry Potter");
		System.out.println();
		System.out.println("SHOWING ALL MOVIES:");
		md.showAllMovies();
		System.out.println();
		System.out.println("DELETION: ");
		System.out.println();
		md.removeMovie("Psycho");
		System.out.println();
		md.showAllMovies();
		System.out.println();
		System.out.println("SPECIFIC INFORMATION ABOUT A MOVIE: ");
		System.out.println();
		md.showMovie("Barton Fink");
		System.out.println();
		md.showMovie("Eyes Wide Shut");
		System.out.println();
		System.out.println("SPECIFIC INFORMATION ABOUT AN ACTOR/ACTRESS: ");
		System.out.println();
		md.showActorRoles("Nicole", "Kidman");
		System.out.println();
		System.out.println("SPECIFIC INFORMATION ABOUT A DIRECTOR: ");
		System.out.println();
		md.showDirectorMovies("Woody", "Allen");
		System.out.println();
		System.out.println("MOVIES RELEASED IN A PARTICULAR TIME: ");
		System.out.println();
		md.showMovies(1999);
		System.out.println();
		System.out.println("MOVIES RELEASED BETWEEN A PARTICULAR TIME INTERVAL: ");
		System.out.println();
		md.showMovies(1972,2005);
		System.out.println();
		System.out.println("REMOVING AN ACTOR/ACTRESS: ");
		System.out.println();
		md.removeActor("Barton Fink","Judy", "Davis");
		System.out.println("MOVIE INFORMATION AFTER DELETION OF ACTOR/ACTRESS: ");
		System.out.println();
		md.showMovie("Barton Fink");
		System.out.println();
		//We wrote this method to see the list of actors and actresses.
		//md.showAllActors();
		System.out.println();
		System.out.println("SEARCHING FOR NON EXISTING DATA: ");
		md.showActorRoles("Irem", "Karpat");
		md.showDirectorMovies("Hilal", "Beral");
		md.showMovies(2080,2090);
		md.showMovies(1803);
		md.showMovie("Lord of The Rings");
		System.out.println();
		System.out.println("TRY TO DELETE NON EXISTING DATA FROM ACTOR BST: ");
		System.out.println();
		md.removeActor("The Interpreter", "Irem", "Karpat");
		System.out.println();
		System.out.println("TRY TO DELETE NON EXISTING DATA FROM MOVIE BST: ");
		System.out.println();
		md.removeMovie("INCEPTION");

		
		
	}
	

}