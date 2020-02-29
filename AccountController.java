package FTMT;

/**
 * AccountController.java
 * 
 * @author wcooper001
 * @version 3/12/19
 */
public class AccountController
{
  DBController dbController = new DBController();
  
  /**
   * Login
   * 
   * Logs the account in
   * 
 * @param username
 * @param password
 * @return 0 if unmatched, 1 if matched but inactive, 2 if matched and active
 */
public int login(String username, String password)
  { 
    boolean matched = dbController.checkInfo(username, password);
    int loggedIn;
    
    if (matched)
    {
    	
    	if (dbController.getStatus(username) == 'Y' || dbController.getStatus(username) == 'y')
    	{
    		loggedIn = 2;
    	}
    	
    	else
    	{
    		loggedIn = 1;
    	}
    }
    
    else
    {
    	loggedIn = 0;
    }
    
	return loggedIn;
   }
  
	public Account getProfile(String username)
	{
	  return dbController.getProfile(username);
	}
	
	public int logOut(String username)
	{
		Account acct = dbController.getProfile(username);
		
		if (acct != null)
		{
			acct.setLoggedIn(false);
			return 1;
		}
		
		return -1;
	}

  public AccountController()
  {
    
  }
  
  
}