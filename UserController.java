package FTMT;

import java.util.*;

/**
 * UserController.java
 * 
 * Calls methods in the DBController class for the user
 * 
 * @author FTMT
 * @version 3/19/19
 *
 */
public class UserController extends AccountController
{
  DBController dbController = new DBController();
  
  /**
   * UserController Constructor
   */
  public UserController()
  {
	  
  }

  /**
   * Searches the database's list of schools and returns a list of results
   * 
   * @param name
   * @param state
   * @param location
   * @param control
   * @param numStudentsLow
   * @param numStudentsHigh
   * @param percFemLow
   * @param percFemHigh
   * @param satVerbLow
   * @param satVerbHigh
   * @param satMathLow
   * @param satMathHigh
   * @param expenses
   * @param percFinAidLow
   * @param percFinAidHigh
   * @param numAppLow
   * @param numAppHigh
   * @param percAdmitLow
   * @param percAdmitHigh
   * @param percEnrolledLow
   * @param percEnrolledHigh
   * @param acadScaleLow
   * @param acadScaleHigh
   * @param socialScaleLow
   * @param socialScaleHigh
   * @param qualLifeLow
   * @param qualLifeHigh
   * @param emphases
   * @return
   */
  public ArrayList<University> searchSchools(String name, String state, String location, String control,
		   String numStudentsLow, String numStudentsHigh, String percFemLow, String percFemHigh,
		   String satVerbLow, String satVerbHigh, String satMathLow, String satMathHigh, String expensesLow, String expensesHigh,
		   String percFinAidLow, String percFinAidHigh, String numAppLow, String numAppHigh, String percAdmitLow,
		   String percAdmitHigh, String percEnrolledLow, String percEnrolledHigh, String acadScaleLow, String acadScaleHigh,
		   String socialScaleLow, String socialScaleHigh, String qualLifeLow, String qualLifeHigh, String[] emphases)
  {
	  
    ArrayList<University> results = this.dbController.searchSchools(name, state, location, control, numStudentsLow, numStudentsHigh,
    		percFemLow, percFemHigh, satVerbLow, satVerbHigh, satMathLow, satMathHigh, expensesLow, expensesHigh, percFinAidLow, percFinAidHigh, numAppLow, 
    		numAppHigh, percAdmitLow, percAdmitHigh, percEnrolledLow, percEnrolledHigh, acadScaleLow, acadScaleHigh, socialScaleLow,
    		socialScaleHigh, qualLifeLow, qualLifeHigh, emphases);
    return results;
  }

  /**
   * Views a string representation of a profile's information
   * 
   * @param username - String ) Username of the profile to get the information of
   * @return String
   */
  public String viewProfile(String username)
  {
    User user = (User)this.dbController.getProfile(username);
    
    if (user == null)
    {
    	return "Profile [" + username + "] not found";
    }
    
    return user.toString();
  }
  
  /**
   * Edits a profile, overwriting the old values with the given parameters
   * 
   * @param username - String ) Username of the profile to edit
   * @param password - String ) new password value for the profile
   * @param firstName - String ) new firstName value for the profile
   * @param lastName - String ) new lastName value for the profile
   * @param type - char ) new type value for the profile ; A for Admins, U for Users
   * @param status - char ) new status value for the profile ; Y for active, N for inactive
   * 
   * @return User ) the edited profile, or null if no profile is found
   */
  public User editProfile(String username, String password, String firstName, String lastName, char type, char status)
  {
	User user = (User)this.dbController.getProfile(username);
	
	user.setFirstName(firstName);
	user.setLastName(lastName);
	user.setUsername(username);
	user.setPassword(password);
	user.setType(type);
	user.setStatus(status);
	
	int result = this.dbController.setProfileInfo(username, password, firstName, lastName, type, status);
	  
    return user;
  }

  /**
   * Returns a university based on the given university name
   * 
   * @param school - String) name of the school to view
   * @return University
   */
  public University viewSchool(String school) {
	return this.dbController.getUniversity(school);
  }

  /**
   * Adds the specified school to the specified user's saved school list
   * 
   * @param username - String ) Username of the profile that is associated with the saved list
   * @param univ - String ) Name of the university to remove
   * @return int ) Number of schools added by the call; or -1 if an error was encountered or if the school wasn't found
   */
  public int addSavedSchool(String username, String schoolName) {
	return this.dbController.addSavedSchool(username, schoolName);
  }

  /**
   * Removes the specified school from the specified user's saved school list
   * 
   * @param username - String ) Username of the profile that is associated with the saved list
   * @param univ - String ) Name of the university to remove
   * @return int ) Number of schools removed by the call; or -1 if an error was encountered or if the school wasn't found
   */
  public int removeSavedSchool(String username, String univ) {
	return this.dbController.removeSavedSchool(username, univ);
  }

  /**
   * Returns a list of the user's saved schools, along with the date it was saved
   * 
   * @param username - String ) Username of the profile that is associated with the saved list
   * @return ArrayList<String>
   */
  public ArrayList<String> viewSavedSchools(String username) {
	  return this.dbController.viewSavedSchools(username);
  }
  
  /**
   * Returns an existing user object from the database
   * 
   * @param username - String ) Username of the user to get
   * @return
   */
  public Account getUser(String username)
  {
	  return this.dbController.getProfile(username);
  }
  
  public boolean isLoggedIn(String username)
  {
	  Account user = this.getUser(username);
	  
	  return user.isLoggedIn();
  }
  
  public void setLoggedIn(String username, boolean bool)
  {
	  Account user = this.getUser(username);
	  
	  user.setLoggedIn(bool);
  }
  
  public String savedSchoolStringtoName(String savedStr)
  {
	  char [] charArray = savedStr.toCharArray();
	  char [] resArray = new char[savedStr.length()];
	  
	  int i = 0;
	  for (char lett : charArray)
	  {
		  if (lett == '(')
		  {
			  break;
		  }

		  resArray[i] = lett;
		  i++;
	  }
	  String result = new String(resArray);
	
	  result = result.trim();
	  return result;
  }

  /**
   * Finds and displays a list of recommended schools based on the given university parameter
   * 
   * @param univ - University ) University to base the recommended schools on
   * @return ArrayList<University>
   */
  public ArrayList<University> viewRecSchools(University univ)
  {
  ArrayList<University> univerArray = new ArrayList<University>();
  Map<Double,String> recSchools = this.dbController.schoolDist(univ);
   
  for(Double mapDoubles : recSchools.keySet())
   { 
  if(!dbController.getUniversity(recSchools.get(mapDoubles)).getName().equals("-1") )
    univerArray.add(dbController.getUniversity(recSchools.get(mapDoubles)));  
   }
  return univerArray;
   
  }
}
