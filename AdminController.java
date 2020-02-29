package FTMT;

import java.util.*;

public class AdminController extends AccountController
{
  DBController dbController = new DBController();
  Admin admin = new Admin();

  /**
   * Returns a string of information on the specified profile
   * 
   * @param username
   * @return
   */
  public String viewProfile(String username)
  {
	char type = dbController.getProfileType(username);
	
    if (type == 'a' || type == 'A')
    {
    	admin = (Admin)dbController.getProfile(username);
    	return admin.toString();
    }
    
    else if (type == 'u' || type == 'U')
    {
    	User user = (User)dbController.getProfile(username);
    	return user.toString();
    }
    
    else
    {
    	return "Profile Not Found";
    }
  }
  
  public Account getProfile(String username)
  {
	  return dbController.getProfile(username);
  }
  
  /**
   * 
   * @param username
   * @param password
   * @param firstName
   * @param lastName
   * @param type
   * @param status
 * @return 
   */
  public int editProfile(String username, String password, String firstName, String lastName, char type, char status)
  {
    return dbController.setProfileInfo(username, password, firstName, lastName, type, status);
  }
  
  /**
   * AdminController Constructor
   */
  public AdminController()
  {
  }
  
  /**
   * Returns a list of all universities
   * 
   * @return ArrayList<University>
   */
  public ArrayList<University> viewUniversities()
  {
    return this.dbController.viewUniversities();
  }

  /**
   * Adds a new University object to the database
   * 
   * @param newUniv - University ) University to add to the database
   * @return int ) Number of universities added as a result ; or -1 if an error was encountered or university is a duplicate
   */
  public int addUniversity(University newUniv) 
  {
	return this.dbController.addUniversity(newUniv);
  }

  /**
   * Removes the specified university from the database
   * 
   * @param name - String ) Name of the university to remove
   * @return int ) Number of universities removed as a result ; or -1 if an error was encountered
   */
  public int removeUniversity(String name) 
  {
	return this.dbController.removeUniversity(name);
  }

  public University getUniversity(String name) 
  {
	  return this.dbController.getUniversity(name);
  }
  
  /**
   * 
   * @param name
   * @param state
   * @param location
   * @param control
   * @param numStudents
   * @param percFemales
   * @param satVerbal
   * @param satMath
   * @param expenses
   * @param percAid
   * @param numApply
   * @param percAdmit
   * @param percEnrolled
   * @param acadScale
   * @param socialScale
   * @param qualLife
   * @return int
   */
  public int editUniversity(String name, String state, String location, String control, int numStudents, double percFemales, double satVerbal,
                    double satMath, double expenses, double percAid, int numApply, double percAdmit, double percEnrolled, 
                    int acadScale, int socialScale, int qualLife)
  {
	  return this.dbController.editUniversity(name, state, location, control, numStudents, percFemales, satVerbal, satMath, expenses, 
			  percAid, numApply, percAdmit, percEnrolled, acadScale, socialScale, qualLife);
  }

  /**
   * 
   * @param acct
   * @return int ) Number of accounts added ; or -1 if an error is encountered
   */
  public int addProfile(Account acct) 
  {
	  return dbController.addProfile(acct);
  }

  /**
   * Returns a list of all profiles
   * 
   * @return ArrayList<Account> 
   */
  public ArrayList<Account> viewAllProfiles() 
  {
	  return dbController.viewAllProfiles();
  }

  /**
   * 
   * @param univName
   * @return ArrayList<String>
   */
  public ArrayList<String> getEmphases(String univName) 
  {
	  return dbController.getEmphases(univName);
  }
  
  /**
 * Deactivates the given profile from the database
 * 
 * @param username ) Username of profile to deactivate
 * @param type ) Type of the profile to deactivate
 * @return int ) -1 if error encountered/profile not found, 0 if profile was not deactivated/already deactivated, and 1 if profile was deactivated
 */
public int deactivateProfile(String username, char type)
  {
	  int result = -1;
	  User user = new User();
	  UserController uC = new UserController();
	  Admin admin = new Admin();
	  AdminController aC = new AdminController();
	  
	  if (type == 'u' || type == 'U')
	  {
		  user = (User)uC.getUser(username);
		  result = editProfile(username, user.getPassword(), user.getFirstName(), user.getLastName(), user.getType(), 'N');
	  }
	  
	  else if (type == 'a' || type == 'A')
	  {
		  admin = aC.getAdmin(username);
		  result = editProfile(username, admin.getPassword(), admin.getFirstName(), admin.getLastName(), admin.getType(), 'N');
	  }
	  
	  return result;
  }
public int removeProfile(String username)
{
	int result = dbController.removeProfile(username);
	
	return result;
}

/**
 * Returns an existing admin object from the database
 * 
 * @param username - String ) Username of the admin to get
 * @return Admin
 */
public Admin getAdmin(String username)
{
	  return (Admin)this.dbController.getProfile(username);
}
}