
package FTMT;

import java.util.*;

/**
 * 
 * User.java
 * 
 * Represents a user account type
 * 
 * @author FTMT
 * @version 3/18/19
 *
 */
public class User extends Account
{
	// Instance Variables
  public String username;
  public String password;
  public boolean matched;
  public String firstName;
  public String lastName;
  public char type;
  public char status;
  public UserInteraction userInter;
  public boolean loggedIn;
  
  /**
 * User Constructor
 * 
 * @param firstName
 * @param lastName
 * @param username
 * @param password
 * @param type
 * @param status
 */
public User(String firstName, String lastName, String username, String password, char type, char status)
  {
    this.username = username;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.type = type;
    this.status = status;
  }
  
  /* 
 *  Creates and returns a string representation of the user information
 *  
 *  @return String
 */
@Override
public String toString() {
	return "User [username: " + username + ", password: " + password + ", firstName: "
	+ firstName + ", lastName: " + lastName + ", type: "  + type + ", status: " + status + "]";
}


/**
 *  User Constructor
 *  
 *  Creates a new user with default values
 */
public User()
  {
	  this.username = "username";
	  this.password = "password";
	  this.firstName = "firstName";
	  this.lastName = "lastName";
	  this.type = 'u';
	  this.status = 'y';
  }

  public String getFullName()
  {
    return this.firstName + " " + this.lastName;
  }
  
  public String getFirstName()
  {
    return this.firstName;
  }
  
  public String getLastName()
  {
    return this.lastName;
  }
  
  public String getUsername()
  {
    return this.username;
  }
  
  public char getType()
  {
    return this.type;
  }
  
  public char getStatus()
  {
    return this.status;
  }

  public boolean isLoggedIn()
  {
	  return this.loggedIn;
  }
  
  public void setLoggedIn(boolean bool)
  {
	  this.loggedIn = bool;
  }
  
  /**
   * Logs the user in
   * 
   * @param username
   * @param password
   * @return int ) 1 if successfully logged in and 0 if failed login
   */
  public int login(String username, String password)
  {
	  if (this.username.equals(username) && this.password.equals(password))
	  {
		  this.loggedIn = true;
		  return 1;
	  }
	  
	  return 0;
  }

/**
 * @return the password
 */
public String getPassword() {
	return password;
}

/**
 * @param password the password to set
 */
public void setPassword(String password) {
	this.password = password;
}

/**
 * @return the matched
 */
public boolean isMatched() {
	return matched;
}

/**
 * @param matched the matched to set
 */
public void setMatched(boolean matched) {
	this.matched = matched;
}

/**
 * @param username the username to set
 */
public void setUsername(String username) {
	this.username = username;
}

/**
 * @param firstName the firstName to set
 */
public void setFirstName(String firstName) {
	this.firstName = firstName;
}

/**
 * @param lastName the lastName to set
 */
public void setLastName(String lastName) {
	this.lastName = lastName;
}

/**
 * Sets the type of the user; U for user, A for admin (U is default)
 * 
 * @param type the type to set
 */
public void setType(char type) {
	if (type == 'A' || type == 'a' || type == 'U' || type == 'u')
		this.type = type;
	else
	{
		this.type = 'U';
	}
}

/**
 * Sets the status of the user; Y for active, N for innactive (Y is default)
 * 
 * @param status the status to set
 */
public void setStatus(char status) {
	if (status == 'Y' || status == 'y' || status == 'N' || status == 'n')
		this.status = status;
	else
	{
		this.status = 'Y';
	}
}


  
  
}