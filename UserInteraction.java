package FTMT;

import java.util.*;

/**
 * UserInteraction.java 
 * 
 * Interaction layer for the user
 * 
 * @author FTMT
 * @version 3/19/19
 */
public class UserInteraction
{ 
  UserController userCtrl = new UserController();
  AccountController acctCtrl = new AccountController();
  
  public ArrayList<String> browseHistory = new ArrayList<String>();
  
  /**
   * Search Schools
   * 
   * Searches the database for schools based on the given parameters
   * 
 * @param name - String) Name of the school
 * @param state - String) State where the school is located
 * @param location - String) Environment of the school (Urban, Suburban, Small-city)
 * @param control - String) Type of control over the school (State, Private)
 * @param numStudentsLow - String) Minimum number of students 
 * @param numStudentsHigh - String) Maximum number of students
 * @param percFemLow - String) Minimum percent female students
 * @param percFemHigh - String) Maximum percent female students
 * @param satVerbLow - String) Minimum average SAT Verbal score
 * @param satVerbHigh - String) Maximum average SAT Verbal score
 * @param satMathLow - String) Minimum average SAT Math score
 * @param satMathHigh - String) Maximum average SAT Math score
 * @param expenses - String) Tuition costs per year
 * @param percFinAidLow - String) Minimum percent of students receiving financial aid
 * @param percFinAidHigh - String) Maximum percent of students receiving financial aid
 * @param numAppLow - String) Minimum number of applicants
 * @param numAppHigh - String) Maximum number of applicants
 * @param percAdmitLow - String) Minimum percent admitted to the school
 * @param percAdmitHigh - String) Maximum percent admitted to the school
 * @param percEnrolledLow - String) Minimum percent enrolled of those admitted
 * @param percEnrolledHigh - String) Maximum percent enrolled of those admitted
 * @param acadScaleLow - String) Minimum academic quality (out of 5)
 * @param acadScaleHigh - String) Maximum academic quality (out of 5)
 * @param socialScaleLow - String) Minimum social quality (out of 5)
 * @param socialScaleHigh - String) Maximum social quality (out of 5)
 * @param qualLifeLow - String) Minimum quality of life (out of 5)
 * @param qualLifeHigh - String) Maximum quality of life (out of 5)
 * @param emphases - String []) Array of emphasized majors at this school
 * @return ArrayList<University> results
 */
public ArrayList<University> searchSchools(String name, String state, String location, String control,
		   String numStudentsLow, String numStudentsHigh, String percFemLow, String percFemHigh,
		   String satVerbLow, String satVerbHigh, String satMathLow, String satMathHigh, String expensesLow, String expensesHigh,
		   String percFinAidLow, String percFinAidHigh, String numAppLow, String numAppHigh, String percAdmitLow,
		   String percAdmitHigh, String percEnrolledLow, String percEnrolledHigh, String acadScaleLow, String acadScaleHigh,
		   String socialScaleLow, String socialScaleHigh, String qualLifeLow, String qualLifeHigh, String[] emphases)
  {
	ArrayList<University> results = this.userCtrl.searchSchools(name, state, location, control, numStudentsLow, numStudentsHigh,
    		percFemLow, percFemHigh, satVerbLow, satVerbHigh, satMathLow, satMathHigh, expensesLow, expensesHigh, percFinAidLow, percFinAidHigh, numAppLow, 
    		numAppHigh, percAdmitLow, percAdmitHigh, percEnrolledLow, percEnrolledHigh, acadScaleLow, acadScaleHigh, socialScaleLow,
    		socialScaleHigh, qualLifeLow, qualLifeHigh, emphases);
    
    return results;
  }

/**
 * Edits a profile, overwriting the old values with the given parameters
 * 
 * @param firstName - String ) new firstName value for the profile
 * @param lastName - String ) new lastName value for the profile
 * @param username - String ) Username of the profile to edit
 * @param password - String ) new password value for the profile
 * @param type - char ) new type value for the profile ; A for Admins, U for Users
 * @param status - char ) new status value for the profile ; Y for active, N for inactive
 * 
 * @return User ) the edited user profile
 */
  public User editProfile(String firstName, String lastName, String username, String password, char type, char status)
  {
    return this.userCtrl.editProfile(username, password, firstName, lastName, type, status);
  }
  
  /**
   * 
   * 
   * @param username
   * @return
   */
  public String viewProfile(String username)
  {
    return this.userCtrl.viewProfile(username);
  }
  
  /**
   * Logs the user out
   * 
   * @param username - String ) Username of the profile to log out
   * @return int ) 1 if the user successfully logged out, or 0 if an error was encountered
   */
  public int logOut(String username)
  {
	  (this.userCtrl.getUser(username)).setLoggedIn(false);
	  this.clearBrowsingHistory();
	  
	  if (this.userCtrl.getUser(username).isLoggedIn()) // If the user is still logged in
	  {
		  return 0;
	  }
	  
	  return 1; // If the user successfully logged out
  }
  
  /**
   * Gets the list of schools viewed by the user this session
   * 
   * @return ArrayList<String>
   */
  public ArrayList<String> getBrowseHistory() {
  	return this.browseHistory;
  }

  /**
   * @param browseHistory - String ) The school to add to the list of viewed schools
   */
  public void addBrowseHistory(String school) {
  	this.browseHistory.add(school);
  }

  /**
   * Returns a university based on the given university name
   * 
   * @param school - String) name of the university
   * @return University
   */
  public University viewSchool(String school)
  {
	  this.addBrowseHistory(school);

	  return this.userCtrl.viewSchool(school);
  }
  
  /**
   * Returns a string of university names that the user has looked at
   * 
   * @return String
   */
  public String showBrowsingHistory()
  {
	  String result = "";
	  
	  if (this.getBrowseHistory() != null)
	  {
		for(String univ : (this.getBrowseHistory()))
	  	{
		  result += univ + "\n";
	  	}
	  }
	  
	  return result;
  }
  
  /**
   * Clears the user's viewing history
   */
  public void clearBrowsingHistory()
  {
	  this.browseHistory = null;
  }

  /**
   * 
   * @param username - String ) Username of the profile that is associated with the saved list
   * @param univ - String ) Name of the university to remove
   * @return int ) Number of schools removed by the call, or -1 if an error was encountered or if the school wasn't found
   */
  public int removeSavedSchool(String username, String univ)
  {
	  return this.userCtrl.removeSavedSchool(username, univ);
  }
  
  /**
   * Adds the specified school to the specified user's saved school list
   * 
   * @param username - String ) Username of the profile that is associated with the saved list
   * @param univ - String ) Name of the university to remove
   * @return int ) Number of schools added by the call; or -1 if an error was encountered or if the school wasn't found
   */
  public int addSavedSchool(String username, String univ)
  {
	  return this.userCtrl.addSavedSchool(username, univ);
  }

  /**
   * Calls the login method in AccountController.java and returns an int based on the result
   * 
   * @param username - String) username of the account trying to log in
   * @param password - String) password of the account trying to log in
   * @return int ) 0 if unmatched, 1 if matched but inactive, 2 if matched and active
   */
  public int login(String username, String password) 
  {
	return this.acctCtrl.login(username, password);

  }

  /**
   * Returns a list of the user's saved schools, along with the date it was saved
   * 
   * @return ArrayList<String>
   */
  public ArrayList<String> viewSavedSchools(String username) 
  {
	  return this.userCtrl.viewSavedSchools(username);
  }

  /**
   * 
   * @param username
   * @return
   */
  public Account getUser(String username) {
	return this.userCtrl.getUser(username);
  }

  /**
   * 
   * @param university
   * @return
   */
  public ArrayList<University> viewRecSchools(University university) {
	  return this.userCtrl.viewRecSchools(university);
  }
}