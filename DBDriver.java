package FTMT;

import java.util.*;

/**
 * DBDriver.java
 * 
 * Runs and tests the different elements of the project
 * 
 * @author FTMT
 * @version 3/19/19
 *
 */
public class DBDriver {

	/**
	 * DBDriver Constructor
	 */
	public DBDriver() 
	{
	}

	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Information
		String username = "juser";
		String password = "user";
		String firstName = "John";
		String lastName = "Miller";
		String type = "u";
		String status = "Y";
		
		// University Testing info
		String name = "Jesus university";
		String state = "Texas";
		String location = "Houston";
		String control = "Private";
		int numStudents = 777;
		double percFemales = 00.01;
		double satVerbal = 800.00;
		double satMath = 800.00;
		double expenses = 1.00;
		double percAid = 100;
		int numApply = 100;
		double percAdmit = 1.00;
		double percEnrolled = 3.00;
		int acadScale = 3;
		int socialScale = 4;
		int qualLife = 5;
		// https://github.com/FTMT/Project2
		
		UserInteraction userInteract = new UserInteraction();
		AdminInteraction adminInteract = new AdminInteraction();
		
	// Log In
		System.out.println("   // Log in //");
		if (userInteract.login(username, password) == 2)
		{
			System.out.println(username + " has logged in");
		}
		
		else if (userInteract.login(username, password) == 1)
		{
			System.out.println(username + " has failed to log in; Account inactive");
		}
		
		else if (userInteract.login(username, password) == 0)
		{
			System.out.println(username + " has failed to log in; Username or password incorrect");
		}
		
	// View and Edit Profile
		System.out.println("\n   // View Profile // (" + username + ")");
		System.out.println(userInteract.viewProfile(username));
		int edited = adminInteract.editProfile("George", lastName, username, password, type.charAt(0), status.charAt(0));
		System.out.println(edited);
		System.out.println("\n   // Edit Profile //");
		System.out.println(userInteract.viewProfile(username));
		
		if (edited == -1)
		{
			System.out.println("Error encountered while editing: " + username);
		}
		else if (edited == 0)
		{
			System.out.println("Nothing to change in the profile" + username);
		}
		else
		{
			System.out.println("Successfully Edited Profile");
		}
		
	// Add profile
		System.out.println("\n   // Add Profile //");
		User newUser = new User("First", "Last", "juser", "password", 'U', 'Y');
		int added = adminInteract.addProfile(newUser);
		if (added == -1)
		{
			System.out.println("Error encountered when adding profile [" + newUser.getUsername() + "]");
		}
		else if (added == 0)
		{
			System.out.println("Unable to add profile");
		}
		else if (added >= 1)
		{
			System.out.println("Added Profile");
		}
		System.out.println(userInteract.viewProfile("New_Username"));
		
	// View List of Profiles
		System.out.println("\n   // View List of Profiles //");
		ArrayList<Account> acctList = adminInteract.viewAllProfiles();
		
		for (Account acct : acctList)
		{
			System.out.println(acct.toString() + "\n");
		}
		
		
	// Add University
		System.out.println(" \n  // Add University //");
		int addedUniv = adminInteract.addUniversity(name, state, location, control, numStudents, percFemales, satVerbal, 
				satMath, expenses, percAid, numApply, percAdmit, percEnrolled,
				acadScale, socialScale, qualLife);
		if (addedUniv == -1)
		{
		System.out.println("Add failed: [" + name + "] is NOT unique!");
		}
		else
		{
		System.out.println("School [" + name + "] has been added!");
		}

	// Search
		String [] emphases = new String[5];
//		emphases[0] = "BIOLOGY";
//		emphases[1] = "CHEMISTRY";
		
		ArrayList<University> univArray = userInteract.searchSchools("-1", "MINNESOTA", "-1", "-1", "1000", "-1", "-1",
	    		"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1",
	    		"-1", "-1", "-1", emphases);
		
		
	// Print search results
		System.out.println("\n   // Search schools //");
		for (University univ : univArray)
		{
			System.out.println(univ.toString() + "\n");
	    }
		
	// View List of Schools
		System.out.println("\n    // View List of Schools //");
		for (University univ2 : adminInteract.viewUniversities())
		{
			System.out.println(univ2.toString() + "\n");
		}
		
	// Save a school
		userInteract.addSavedSchool(username, "HARVARD");
		userInteract.addSavedSchool(username, "HARVARD");
		userInteract.addSavedSchool(username, "BOSTON COLLEGE");
		
	// View saved school list
		System.out.println("\n    // View Saved School List //");
		ArrayList<String> savedSchools = userInteract.viewSavedSchools(username);
		for (String univ3 : savedSchools)
		{
			System.out.println(univ3 + "\n");
		}
		
	// Remove a school
//		System.out.println("\n   // Remove Saved School //");
//		int removed = userInteract.removeSavedSchool(username, "HARVARD");
//		if (removed == -1)
//		{
//			System.out.println("Add university [" + name + "] failed");
//		}
//		else if (removed == 0)
//		{
//			System.out.println("Add university [" + name + "] failed");
//		}
//		else 
//		{
//			System.out.println("University [" + name + "] added");
//		}
		
	// Search Specific Profile
		System.out.println("\n   // Search Specific Profile //\n" + adminInteract.viewProfile("luser"));
		
	// View Browsing History
		System.out.println("\n   // Show Browsing History //");
		userInteract.viewSchool("HARVARD");
		userInteract.viewSchool("BUCKNELL");
		ArrayList<String> history = userInteract.getBrowseHistory();
		System.out.println("History length: " + history.size());
		String result = "";
		for (String school : history)
		{
		  result += " + " + school + "\n";
		}
		System.out.println(result);
		
	// Recommended Schools
		System.out.println("\n   // View Top 5 Recommended Schools //");
		 ArrayList<University> recSchools = userInteract.viewRecSchools(new University(name, state, location,control, numStudents,  percFemales,satVerbal,
		           satMath, expenses, percAid, numApply, percAdmit,percEnrolled, 
		            acadScale, socialScale, qualLife));
		 
		 String recSchoolString = "";
		 for (int i = 0; i < 5; i++)
		 {
			 recSchoolString += recSchools.get(i).toString() + "\n";
		 }
		 System.out.println(recSchoolString);
		 
	// School Emphases
		 System.out.println("\n   // View School Emphases // (Yale)");
		 ArrayList<String> schoolEmphases = adminInteract.getEmphases("YALE");
		 
		 String schoolEmphString = "";
		 for (String univ5 : schoolEmphases)
		 {
			 schoolEmphString += univ5 + "\n";
		 }
		 System.out.println(schoolEmphString);
		 
	// Edit University
		 adminInteract.editUniversity("HARVARD", "MASSACHUSETTS", location, control, numStudents, 
				 percFemales, satVerbal, satMath, expenses, percAid, numApply, percAdmit, percEnrolled, acadScale, socialScale, qualLife);
		 
	// Remove University
//		System.out.println("\n   // Remove University //");
//		int removedUniv = adminInteract.removeUniversity(name);
//		if (removedUniv == -1)
//		 {
//		  System.out.println("Remove university [" + name + "] failed");
//		 }
//		else
//		 {
//		  System.out.println("School [" + name + "] has been removed!");
//		 }
		 
	// Log out
		 System.out.println("\n   // Log Out //");
		 if (userInteract.logOut(username) == 1)
		 {
			 System.out.println("Successfully logged out");
		 }
		 else
		 {
			 System.out.println("Failed to log out");
		 }
	}

}
