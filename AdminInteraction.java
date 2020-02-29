package FTMT;

import java.util.*;

/**
 * AdminInteraction.java
 * 
 * Interaction layer for the admin
 * 
 * @author FTMT
 * @version 3/19/19
 */
public class AdminInteraction
{
  AdminController adminCtrl = new AdminController();
  AccountController acctCtrl = new AccountController();
  DBController DBController = new DBController();
  
  /**
   * 
   * @return
   */
  public ArrayList<University> viewUniversities()
  {
    ArrayList<University> results = this.adminCtrl.viewUniversities();
    return results;
  }
  
  /**
   * 
   * @param firstName
   * @param lastName
   * @param username
   * @param password
   * @param type
   * @param status
   * @return
   */
  public int editProfile(String firstName, String lastName, String username, String password, char type, char status)
  {
	  return adminCtrl.editProfile(username, password, firstName, lastName, type, status);
  }
  
  /**
   * 
   * @param username
   * @param password
   * @return
   */
  public int login(String username, String password) 
  {
	return this.acctCtrl.login(username, password);
  }
  
  /**
   * 
   */
  public AdminInteraction()
  {
  
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
   * @return
   */
  public int addUniversity(String name, String state, String location, String control, int numStudents, double percFemales, double satVerbal, 
		  double satMath, double expenses, double percAid, int numApply, double percAdmit, double percEnrolled,
		  int acadScale, int socialScale, int qualLife)
  {
	  University newUniv = new University(name, state, location, control, numStudents, percFemales, satVerbal,
			  satMath, expenses, percAid, numApply, percAdmit, percEnrolled,
			  acadScale, socialScale, qualLife);
	  
	  int added = adminCtrl.addUniversity(newUniv);
	  return added;
  }
  
  /**
   * Removes the specified university from the database
   * 
   * @param name - String ) Name of the university to remove
   * @return int ) Number of universities removed as a result ; or -1 if an error was encountered
   */
  public int removeUniversity(String name)
  {
	  return adminCtrl.removeUniversity(name);
  }

  /**
   * 
   * @param username
   * @return
   */
 public String viewProfile(String username) 
 {
	return this.adminCtrl.viewProfile(username);
 }
 
 /**
  * Returns a list of all profiles
  * 
  * @return 
  */
 public ArrayList<Account> viewAllProfiles() 
 {
	return this.adminCtrl.viewAllProfiles();
 }
 
 /**
  * 
  * @param name
  * @return
  */
 public University getUniversity(String name)
 {
	 return this.adminCtrl.getUniversity(name);
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
	  return this.adminCtrl.editUniversity(name, state, location, control, numStudents, percFemales, satVerbal, satMath, expenses, 
			  percAid, numApply, percAdmit, percEnrolled, acadScale, socialScale, qualLife);
 }
 
 /**
  * 
  * @param acct
  * @return
  */
 public int addProfile(Account acct)
 {
	 return adminCtrl.addProfile(acct);
 }

 /**
  * 
  * @param univName
  * @return
  */
  public ArrayList<String> getEmphases(String univName) 
  {
	  return this.adminCtrl.getEmphases(univName);
  }
  
  public int removeProfile(String username)
  {
  	int result = adminCtrl.removeProfile(username);
  	
  	return result;
  }
}
