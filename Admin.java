package FTMT;

/**
 * 
 * @author wcooper001
 *
 */
public class Admin extends Account
{
  public String username;
  public String password;
  public boolean loggedIn;
  public String firstName;
  public String lastName;
  public char type;
  public char status;

  /**
 * @return the password
 */
public String getPassword() {
	return this.password;
}

public String getFullName() {
	return this.firstName + " " + this.lastName;
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
	return this.matched;
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
 * @param type the type to set
 */
public void setType(char type) {
	this.type = type;
}

/**
 * @param status the status to set
 */
public void setStatus(char status) {
	this.status = status;
}

public Admin()
  {
    this.username = "adminUser";
    this.password = "password";
    this.firstName = "firstName";
    this.lastName = "lastName";
    this.type = 'A';
    this.status = 'Y';
  }

  public Admin(String username, String password)
  {
    this.username = username;
    this.password = password;
    this.firstName = "firstName";
    this.lastName = "lastName";
    this.type = 'A';
    this.status = 'Y';
  }
  
  public Admin(String firstName, String lastName, String username, String password, char type, char status)
  {
    this.username = username;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.type = type;
    this.status = status;
    
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

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "Admin [username: " + username + ", password: " + password + ", firstName: "
			+ firstName + ", lastName: " + lastName + ", type: "  + type + ", status: " + status + "]";
}
}