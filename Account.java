package FTMT;

/**
 * @author wcooper001
 * @version 
 */
public abstract class Account
{
  public String username;
  public String password;
  public boolean matched;
  public String lastName;
  public char type;
  public char status;
  public String firstName;
  
  public abstract void setFirstName(String name); // Black box
  
  public abstract void setLastName(String name); // Black box
  
  public abstract void setUsername(String name); // Black box
  
  public abstract void setPassword(String password); // Black box
  
  public abstract void setType(char type); // Black box
  
  public abstract void setStatus(char status); // Black box
  
  public abstract String getFirstName(); // basic
  
  public abstract String getLastName(); // basic
  
  public abstract String getUsername(); // basic
  
  public abstract String getPassword(); // basic
  
  public abstract String getFullName(); // basic
  
  public abstract char getType(); // basic
  
  public abstract char getStatus(); // basic
  
  public abstract boolean isLoggedIn();
  
  public abstract void setLoggedIn(boolean bool);
}