/**
 * 
 */

package FTMT;

import dblibrary.project.csci230.*;
import java.util.*;

/**
 * DBController.java
 * 
 * Interacts with the database
 * 
 * @author wcooper001
 * @version 3/19/19
 */
public class DBController
{
  UniversityDBLibrary dbLibrary = new UniversityDBLibrary("fearthem", "csci230");
  String [][] usernames = dbLibrary.user_getUsers();
  String [][] schools = dbLibrary.university_getUniversities();
  String [] userInfo = new String[6];
  String[][] emphasesList = dbLibrary.university_getNamesWithEmphases();
                                    
  /**
 *  DBController Constructor
 */
public DBController()
  {
    this.dbLibrary = new UniversityDBLibrary("fearthem", "csci230");
    this.usernames = dbLibrary.user_getUsers();
    this.schools = dbLibrary.university_getUniversities();
    this.userInfo = new String[6];
  }
  
  
  /**
   * Returns the password associated with the given username
   * 
 * @param username - String ) Username to get the password of
 * @return String
 */
public String getPassword(String username)
  {
	String password = "";
	
	for (int i = 0; i < this.usernames.length; i++)
    {
      if(username.equals(usernames[i][2]))
      {
        password = usernames[i][3];
      }
    }
    return password;
  }
  
/**
 * Adds a new University object to the database
 * 
 * @param univ - University ) University to add
 * @return int ) Number of universities added as a result; or -1 if an error was encountered or if the school is a duplicate
 */
public int addUniversity(University univ) {
	
	return dbLibrary.university_addUniversity(univ.name, univ.state, univ.location, univ.control, univ.numStudents,
			univ.percFemales, univ.satVerbal, univ.satMath,
			univ.expenses, univ.percAid, univ.numApply, univ.percAdmit, univ.percEnrolled,
			univ.acadScale, univ.socialScale, univ.qualLife);
}

/**
 * Returns the type (A for Admin, U for User) of the specified profile
 * 
 * @param username - String ) Username of the profile to get the type of
 * @return char
 */
public char getProfileType(String username)
{
	return this.getProfile(username).getType();
}


  /**
 * Returns a specified profile; or null if the account isn't found
 * 
 * @param username - String ) Username of the profile to get
 * @return Account object or null if no profile is found
 */
public Account getProfile(String username)
  { 
	String[] profileInfo = new String[6];
    for (int i = 0; i < this.usernames.length; i++)
    {
      if(username.equals(usernames[i][2]))
      {
        profileInfo = usernames[i];
        char type = profileInfo[4].charAt(0);
        if (type == 'U' || type == 'u')
        {
        	String name = profileInfo[0];
        	User profile = new User(name, profileInfo[1], profileInfo[2], 
        			profileInfo[3], profileInfo[4].charAt(0), profileInfo[5].charAt(0));
        	return profile;
        }
        
        else if (type == 'A' || type == 'a')
        {
        	String name = profileInfo[0];
        	
        	Admin profile = new Admin(name, profileInfo[1], profileInfo[2], 
        			profileInfo[3], profileInfo[4].charAt(0), profileInfo[5].charAt(0));
        	return profile;
        }
      }
    }

    return null;
  }

/**
 * Removes the given profile from the database
 * 
 * @param username ) Username of the profile to remove
 * @return int ) -1 if an error is encountered, otherwise the number of users removed as a result
 */
public int removeProfile(String username)
{
	int result = dbLibrary.user_deleteUser(username);
	
	return result;
}
  
/**
 * 
 * 
 * @param username - String ) 
 * @param password
 * @param firstName
 * @param lastName
 * @param type
 * @param status
 * @return
 */
  public int setProfileInfo(String username, String password, String firstName, String lastName, char type, 
                                    char status)
  {
    int result = dbLibrary.user_editUser(username, firstName, lastName, password, (char)type, (char)status);
    
    return result;
  }
  
  /**
   *  Checks if the given username and password match
   * 
 * @param username
 * @param password
 * @return boolean
 */
public boolean checkInfo(String username, String password)
  {
    for (int i = 0; i < this.usernames.length; i++)
    {
      if(username.equals(usernames[i][2]))
      {
        if(password.equals(usernames[i][3]))
        {
          return true;
        }
      }
    }
    return false;
  }
  
public char getStatus(String username)
  {
	for (int i = 0; i < this.usernames.length; i++)
    {
		if(username.equals(usernames[i][2]))
        {
	      return usernames[i][5].charAt(0);
	    }
	}
	return 'n';
  }
   
   /**
    * Searches the database for values matching the given parameters, then sorts them based on how close they are to the search values (in descending order)
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
 * @return
 */
public ArrayList<University> searchSchools(String name, String state, String location, String control,
		   String numStudentsLow, String numStudentsHigh, String percFemLow, String percFemHigh,
		   String satVerbLow, String satVerbHigh, String satMathLow, String satMathHigh, String expensesLow, String expensesHigh,
		   String percFinAidLow, String percFinAidHigh, String numAppLow, String numAppHigh, String percAdmitLow,
		   String percAdmitHigh, String percEnrolledLow, String percEnrolledHigh, String acadScaleLow, String acadScaleHigh,
		   String socialScaleLow, String socialScaleHigh, String qualLifeLow, String qualLifeHigh, String[] emphases)
   { 
		 	   
	   
	   
     int i = 0;
     ArrayList<University> results = new ArrayList<University>();
     String [][] emphasesArray = dbLibrary.university_getNamesWithEmphases();
     University univ = new University();
     
     
     for (String[] schoolInfo : schools)
     {
    	 if (schoolInfo != null)
    	 {
    		 univ = new University(schoolInfo);
    	 
      // Name
       if (name != "" && name != "-1")  // Contains value
       {
    	if (this.schools[i][0].contains(name.toUpperCase()))
      	{
    	   if(!results.contains(univ))
    	   results.add(univ);
       	}	
       }
       
      // State
       if (state != "" || state != null)  // Contains value
       {
       	if (this.schools[i][1].contains(state.toUpperCase()))
       	{
    	   if(!results.contains(univ))
    	   results.add(univ);
       	}
       }
       
      // Location
        if (location != "" && this.schools[i][2].equals(location.toUpperCase()))
        {
    	   if(!results.contains(univ))
    	   results.add(univ);
        }
       
       
      // Control
    	if (control != "" && this.schools[i][3].equals(control.toUpperCase()))
        {
    	   if(!results.contains(univ))
    	   results.add(univ);
        }
       
      // Number of Students
       if (numStudentsLow != "" && numStudentsHigh != "") // Both contain values
       {
        if (Integer.parseInt(numStudentsLow) >= Integer.parseInt(this.schools[i][4]) && 
    		   Integer.parseInt(numStudentsHigh) <= Integer.parseInt(this.schools[i][4]))
        {
    	   if(!results.contains(univ))
    	   results.add(univ);
        }
       }
       
       else if (numStudentsLow != "" && numStudentsHigh == "")  // Empty numStudentsHigh
       {
    	   if (Integer.parseInt(numStudentsLow) >= Integer.parseInt(this.schools[i][4]))
            {
    		   if(!results.contains(univ))
    	    	   results.add(univ);
            }
       }
       
       else if (numStudentsLow == "" && numStudentsHigh != "")  // Empty numStudentsLow
       {
    	   if (Integer.parseInt(numStudentsHigh) <= Integer.parseInt(this.schools[i][4]))
            {
    		   if(!results.contains(univ))
    	    	   results.add(univ);
            }
       }
       
      // Percent Female
       if (percFemLow != "" && percFemHigh != "")  // Both contain values
       {
        if (Double.parseDouble(percFemLow) >= Double.parseDouble(this.schools[i][5]) && 
        		Double.parseDouble(percFemHigh) <= Double.parseDouble(this.schools[i][5]))
        {
    	   if(!results.contains(univ))
    	   results.add(univ);
        }
       }
       
       else if (percFemLow != "" && percFemHigh == "")  // Empty percFemHigh
       {
    	   if (Double.parseDouble(percFemLow) >= Double.parseDouble(this.schools[i][5]))
            {
    		   if(!results.contains(univ))
    	    	   results.add(univ);
            }
       }
       
       else if (percFemLow == "" && percFemHigh != "")  // Empty percFemLow
       {
    	   if (Double.parseDouble(percFemHigh) <= Double.parseDouble(this.schools[i][5]))
            {
    		   if(!results.contains(univ))
    	    	   results.add(univ);
            }
       }
       
      // SAT Verb
       if (satVerbLow != "" && satVerbHigh != "")  // Both contain values
       {
        if (Double.parseDouble(satVerbLow) >= Double.parseDouble(this.schools[i][6]) && 
        		Double.parseDouble(satVerbHigh) <= Double.parseDouble(this.schools[i][6]))
        {
    	   if(!results.contains(univ))
    	   results.add(univ);
        }
       }
       
       else if (satVerbLow != "" && satVerbHigh == "")  // Empty satVerbHigh
       {
    	   if (Double.parseDouble(satVerbLow) >= Double.parseDouble(this.schools[i][6]))
            {
    		   if(!results.contains(univ))
    	    	   results.add(univ);
            }
       }
       
       else if (satVerbLow == "" && satVerbHigh != "")  // Empty satVerbLow
       {
    	   if (Double.parseDouble(satVerbHigh) <= Double.parseDouble(this.schools[i][6]))
            {
    		   if(!results.contains(univ))
    	    	   results.add(univ);
            }
       }
       
      // SAT Math
       if (satMathLow != "" && satMathHigh != "")  // Both contain values
       {
        if (Double.parseDouble(satMathLow) >= Double.parseDouble(this.schools[i][7]) && 
        		Double.parseDouble(satMathHigh) <= Double.parseDouble(this.schools[i][7]))
        {
    	   if(!results.contains(univ))
    	   results.add(univ);
        }
       }
       
       else if (satMathLow != "" && satMathHigh == "")  // Empty satMathHigh
       {
    	   if (Double.parseDouble(satMathLow) >= Double.parseDouble(this.schools[i][7]))
            {
    		   if(!results.contains(univ))
    	    	   results.add(univ);
            }
       }
       
       else if (satMathLow == "" && satMathHigh != "")  // Empty satMathLow
       {
    	   if (Double.parseDouble(satMathHigh) <= Double.parseDouble(this.schools[i][7]))
            {
    		   if(!results.contains(univ))
    	    	   results.add(univ);
            }
       }
       
      // Expenses
       if (expensesLow != "" && expensesHigh != "") // Both contain values
       {
        if (Integer.parseInt(expensesLow) >= Integer.parseInt(this.schools[i][7]) && 
    		   Integer.parseInt(expensesHigh) <= Integer.parseInt(this.schools[i][7]))
        {
    	   if(!results.contains(univ))
    	   results.add(univ);
        }
       }
       
       else if (expensesLow != "" && expensesHigh == "")  // Empty expensesHigh
       {
    	   if (Integer.parseInt(expensesLow) >= Integer.parseInt(this.schools[i][7]))
            {
    		   if(!results.contains(univ))
    	    	   results.add(univ);
            }
       }
       
       else if (expensesLow == "" && expensesHigh != "")  // Empty expensesLow
       {
    	   if (Integer.parseInt(expensesHigh) <= Integer.parseInt(this.schools[i][7]))
            {
    		   if(!results.contains(univ))
    	    	   results.add(univ);
            }
       }
       
      // Percent Financial Aid
       if (percFinAidLow != "" && percFinAidHigh != "")  // Both contain values
       {
        if (Double.parseDouble(percFinAidLow) >= Double.parseDouble(this.schools[i][9]) && 
        		Double.parseDouble(percFinAidHigh) <= Double.parseDouble(this.schools[i][9]))
        {
    	   if(!results.contains(univ))
    	   results.add(univ);
        }     
       }
       
       else if (percFinAidLow != "" && percFinAidHigh == "")  // Empty percFinAidHigh
       {
    	   if (Double.parseDouble(percFinAidLow) >= Double.parseDouble(this.schools[i][9]))
            {
    		   if(!results.contains(univ))
    	    	   results.add(univ);
            }
       }
       
       else if (percFinAidLow == "" && percFinAidHigh != "")  // Empty percFinAidLow
       {
    	   if (Double.parseDouble(percFinAidHigh) <= Double.parseDouble(this.schools[i][9]))
            {
    		   if(!results.contains(univ))
    	    	   results.add(univ);
            }
       }
       
      // Number of Applicants
       if (numAppLow != "" && numAppHigh != "")  // Both contain values
       {
        if (Integer.parseInt(numAppLow) >= Integer.parseInt(this.schools[i][10]) && 
    		   Integer.parseInt(numAppHigh) <= Integer.parseInt(this.schools[i][10]))
        {
    	   if(!results.contains(univ))
    	   results.add(univ);
        }
       }
       
       else if (numAppLow != "" && numAppHigh == "")  // Empty numAppHigh
       {
    	   if (Integer.parseInt(numAppLow) >= Integer.parseInt(this.schools[i][10]))
            {
    		   if(!results.contains(univ))
    	    	   results.add(univ);
            }
       }
       
       else if (numAppLow == "" && numAppHigh != "")  // Empty numAppLow
       {
    	   if (Integer.parseInt(numAppHigh) <= Integer.parseInt(this.schools[i][10]))
            {
    		   if(!results.contains(univ))
    	    	   results.add(univ);
            }
       }
       
      // Percent Admitted
       if (percAdmitLow != "" && percAdmitHigh != "")  // Both contain values
       {
        if (Double.parseDouble(percAdmitLow) >= Double.parseDouble(this.schools[i][11]) && 
        		Double.parseDouble(percAdmitHigh) <= Double.parseDouble(this.schools[i][11]))
        {
    	   if(!results.contains(univ))
    	   results.add(univ);
        }
       }
       
       else if (percAdmitLow != "" && percAdmitHigh == "")  // Empty percAdmitHigh
       {
    	   if (Double.parseDouble(percAdmitLow) >= Double.parseDouble(this.schools[i][11]))
            {
    		   if(!results.contains(univ))
    	    	   results.add(univ);
            }
       }
       
       else if (percAdmitLow == "" && percAdmitHigh != "")  // Empty percAdmitLow
       {
    	   if (Double.parseDouble(percAdmitHigh) <= Double.parseDouble(this.schools[i][11]))
            {
    		   if(!results.contains(univ))
    	    	   results.add(univ);
            }
       }
       
      // Percent Enrolled
       if (percEnrolledLow != "" && percEnrolledHigh != "")  // Both contain values
       {
        if (Double.parseDouble(percEnrolledLow) >= Double.parseDouble(this.schools[i][12]) && 
        		Double.parseDouble(percEnrolledHigh) <= Double.parseDouble(this.schools[i][12]))
        {
    	   if(!results.contains(univ))
    	   results.add(univ);
        }
       }
       
       else if (percEnrolledLow != "" && percEnrolledHigh == "")  // Empty percEnrolledHigh
       {
    	   if (Double.parseDouble(percEnrolledLow) >= Double.parseDouble(this.schools[i][12]))
            {
    		   if(!results.contains(univ))
    	    	   results.add(univ);
            }
       }
       
       else if (percEnrolledLow == "" && percEnrolledHigh != "")  // Empty percEnrolledLow
       {
    	   if (Double.parseDouble(percAdmitHigh) <= Double.parseDouble(this.schools[i][12]))
            {
    		   if(!results.contains(univ))
    	    	   results.add(univ);
            }
       }
       
      // Academic Scale
       if (acadScaleLow != "" && acadScaleHigh != "")  // Both contain values
       {
        if (Integer.parseInt(acadScaleLow) >= Integer.parseInt(this.schools[i][13]) && 
    		   Integer.parseInt(acadScaleHigh) <= Integer.parseInt(this.schools[i][13]))
        {
    	   if(!results.contains(univ))
    	   results.add(univ);
        }
       }
       
       else if (acadScaleLow != "" && acadScaleHigh == "")  // Empty acadScaleHigh
       {
    	   if (Integer.parseInt(acadScaleLow) >= Integer.parseInt(this.schools[i][12]))
            {
    		   if(!results.contains(univ))
    	    	   results.add(univ);
            }
       }
       
       else if (acadScaleLow == "" && acadScaleHigh != "")  // Empty acadScaleLow
       {
    	   if (Integer.parseInt(acadScaleHigh) <= Integer.parseInt(this.schools[i][12]))
            {
    		   if(!results.contains(univ))
    	    	   results.add(univ);
            }
       }
       
      // Social Scale
       if (socialScaleLow != "" && socialScaleHigh != "")  // Both contain values
       {
        if (Integer.parseInt(socialScaleLow) >= Integer.parseInt(this.schools[i][14]) && 
    		   Integer.parseInt(socialScaleHigh) <= Integer.parseInt(this.schools[i][14]))
        {
    	   if(!results.contains(univ))
    	   results.add(univ);
        }
       }
       
       else if (socialScaleLow != "" && socialScaleHigh == "")  // Empty socialScaleHigh
       {
    	   if (Integer.parseInt(socialScaleLow) >= Integer.parseInt(this.schools[i][12]))
            {
    		   if(!results.contains(univ))
    	    	   results.add(univ);
            }
       }
       
       else if (socialScaleLow == "" && socialScaleHigh != "")  // Empty socialScaleLow
       {
    	   if (Integer.parseInt(socialScaleHigh) <= Integer.parseInt(this.schools[i][12]))
            {
    		   if(!results.contains(univ))
    	    	   results.add(univ);
            }
       }
       
      // Quality of Life
       if (qualLifeLow != "" && qualLifeHigh != "")  // Both contain values
       {
        if (Integer.parseInt(qualLifeLow) >= Integer.parseInt(this.schools[i][15]) && 
    		   Integer.parseInt(qualLifeHigh) <= Integer.parseInt(this.schools[i][15]))
        {
    	   if(!results.contains(univ))
    	   results.add(univ);
        }
       }
       
       else if (qualLifeLow != "" && qualLifeHigh == "")  // Empty qualLifeHigh
       {
    	   if (Integer.parseInt(qualLifeLow) >= Integer.parseInt(this.schools[i][12]))
            {
    		   if(!results.contains(univ))
    	    	   results.add(univ);
            }
       }
       
       else if (qualLifeLow == "" && qualLifeHigh != "")  // Empty qualLifeLow
       {
    	   if (Integer.parseInt(qualLifeHigh) <= Integer.parseInt(this.schools[i][12]))
            {
    		   if(!results.contains(univ))
    	    	   results.add(univ);
            }
       }
       
       i++;
     } 
    	 else
    	 {
    		 break;
    	 }
     }
     
    // Emphases
     int k = 0;
     
     if (emphases != null)
     {
     while (k <= this.schools.length)
     {
    	 for (String major : emphases)
    	 {
    		 if (major != null)
    		 {
    		  if (major.equals(emphasesArray[k][1]))
    		  {
    			  if (!results.contains(this.getUniversity(emphasesArray[k][0])))
    				  results.add(this.getUniversity(emphasesArray[k][0]));
    		  }
    		 }
    	 }
    	 k++;
     }
     }
     
     return results;
   }

  /**
   * Returns a university object based on the given university name
   * 
   * @param name - String) name of the university
   * @return University or null if school is not found
   */
   public University getUniversity(String name)
   {
	   University result = null;
	   
	   for (int i = 0; i < this.schools.length; i++)
	   {
	       if (this.schools[i][0].contains(name.toUpperCase()))
	       {
	    	   result = new University(this.schools[i]);
	       }
	   }
	   
	   return result;
   }
   
   /**
    * Returns a list of all universities in the database
    * 
    * @return ArrayList<University>
    */
   public ArrayList<University> viewUniversities()
   {
     ArrayList<University> list = new ArrayList<University>();
     University univ = new University();
     
     for (int j = 0; j < this.schools.length; j++)
     {
    	 univ = new University(this.schools[j][0], this.schools[j][1], this.schools[j][2], this.schools[j][3],
        		 Integer.parseInt(this.schools[j][4]), Double.parseDouble(this.schools[j][5]), Double.parseDouble(this.schools[j][6]), 
        		 Double.parseDouble(this.schools[j][7]), Double.parseDouble(this.schools[j][8]),
        		 Double.parseDouble(this.schools[j][9]), Integer.parseInt(this.schools[j][10]), Double.parseDouble(this.schools[j][11]), Double.parseDouble(this.schools[j][12]), 
        		 Integer.parseInt(this.schools[j][13]), Integer.parseInt(this.schools[j][14]), Integer.parseInt(this.schools[j][15]));
    	 
       list.add(univ);
     }
     
     return list;
   }

   /**
    * Adds a school to a user's saved school list
    * 
    * @param username - String) username of the account associated with the saved list 
    * @param univ - String) name of the school to be added
    * @return int ) Number of schools added to the saved list
    */
   public int addSavedSchool(String username, String univ) {
	   return dbLibrary.user_saveSchool(username, univ);
   }
   
   /**
    * Calculates the distance between values between the given University and the rest of the database
    * 
    * @param univ - University ) University to calculate the distance from
    * @return String[][]
    */
   public Map<Double, String> schoolDist(University univ)
   {
   HashMap fullMap = new HashMap<Double,String>(1500);
   
   
   for(int j = 0; j < this.schools.length-1; j++)
   {
 int avgNumStud = 30000;
 int avgPercFem = 99;
 int avgSatVerb = 550;
 int avgSatMath = 550;
 int avgExpenses = 40000;
 int avgPercFinAid = 95;
 int avgNumApp = 13000;
 int avgPercAdmit = 95;
 int avgPercEnroll = 85;
 
   
   
   
   
   
   double total = 0;
    
    if(this.schools[j][0].equals(univ.name))
    {
      break;
    }
    else
    {
     total+=1;
    }
    
  
       if(!this.schools[j][1].equals(univ.state))
       {
        total+=1;
        
       }
         
         
      if(!this.schools[j][2].equals(univ.control))
      {
       total+=1;
       
      }
      if(this.schools[j][3].equals(univ.location))
      {
       
       total+=1;
      }
      
      
      
            int numStudDiff = Math.abs(Integer.parseInt(this.schools[j][4]) - univ.numStudents);
            if(numStudDiff>0)
            {
             total+=numStudDiff/avgNumStud;
            
            }
            
            double percFemDiff = Math.abs(Double.parseDouble(this.schools[j][5]) - univ.percFemales);
            if(percFemDiff >0)
            {
             total+=percFemDiff/avgPercFem;
            
            }
            
            
            double satVerbDiff = Math.abs((univ.getSatVerbal() - Double.parseDouble(this.schools[j][6]))/Double.parseDouble(this.schools[j][6]));
             if(satVerbDiff >0)
             {
              total+=satVerbDiff/avgSatVerb;
              
             }
             double satMathDiff = Math.abs(Double.parseDouble(this.schools[j][7]) - univ.satMath);
             if(satMathDiff > 0)
             {
              total+=satMathDiff/avgSatMath;
             
             }
             
             double expenseDiff = Math.abs(Double.parseDouble(this.schools[j][8]) - univ.expenses);
             if(expenseDiff > 0)
             {
              total+=expenseDiff/avgExpenses;
            
             }

             double finAid = Math.abs(Double.parseDouble(this.schools[j][9]) - univ.percAid);
             if(finAid > 0)
             {
             
              total+=finAid/avgPercFinAid;
             
             }
             
             int numApplyDif = Math.abs(univ.numApply -  Integer.parseInt(this.schools[j][10]) );
             if(numApplyDif > 0)
             {
              total+=numApplyDif/ avgNumApp;
              
             }
             
             double percAdmitted = Math.abs( Double.parseDouble(this.schools[j][11]) - univ.percAdmit);
             if(percAdmitted > 0)
             {
              total+=percAdmitted/ avgPercAdmit;
              
             }
             
            
             double percEnrolled = Math.abs( Double.parseDouble(this.schools[j][12]) - univ.percEnrolled);
             if(percEnrolled !=0)
             {
              total+=percEnrolled/ avgPercEnroll;
            
             }
             
             total+= Math.abs( Integer.parseInt(this.schools[j][13]) - univ.acadScale);
            
             total+=Math.abs( Integer.parseInt(this.schools[j][14]) - univ.socialScale);
             
             total+=Math.abs( Integer.parseInt(this.schools[j][15]) - univ.qualLife);
             
              
              
             

    
    java.lang.Math.abs(total);
    
    
   
    fullMap.put(total,this.schools[j][0]);

   }
  
  return fullMap;
   
   
   
   }

/**
 * Merge sorts the given array
 * 
 * @param distArray - String[][] ) 
 * @param l - int )
 * @param m - int )
 * @param r - int )
 */
private void mergeSort(String[][] distArray, int l, int m, int r) {
 int n1 = m - l + 1; 
     int n2 = r - m; 
     String L[][] = new String [n1][2]; 
     String R[] []= new String [n2][2]; 
     for (int i=0; i<n1; ++i) 
         L[i] = distArray[l + i]; 
     for (int j=0; j<n2; ++j) 
         R[j] = distArray[m + 1+ j]; 
     
     int i = 0, j = 0; 
     int k = l;
     
     while (i < n1 && j < n2) 
     { 
         if (Integer.parseInt(L[i][1]) <= Integer.parseInt(R[j][1])) 
         { 
             distArray[k][1] = L[i][1]; 
             i++; 
         } 
         else
         { 
          distArray[k][1] = R[j][1]; 
             j++; 
         } 
         k++; 
     } 
     while (i < n1) 
     { 
         distArray[k][1] = L[i][1]; 
         i++; 
         k++; 
     } 

     while (j < n2) 
     { 
         distArray[k][1] = R[j][1]; 
         j++; 
         k++; 
     }     
     
}

/**
 * Sorts a 2D array in descending order
 * 
 * @param distArray - String [][] ) 
 * @param length - int )
 * @param length2 - int ) 
 * @return
 */
private String[][] sort(String[][] distArray, int length, int length2)
{
 if(length<length2)
 {
  int m = (length+length2)/2;
  sort(distArray,length, m);
  sort(distArray,m+1,length2);
 
  mergeSort(distArray,length, m,length2);
 }
 return distArray;
}

/**
 * Returns a list of emphases of a specified university
 * 
 * @param name - String ) Name of the school to find the emphases of
 * @return ArrayList<String>
 */
public  ArrayList<String> getEmphases(String name) {
 int k = 0;
 ArrayList<String> emphases = new ArrayList<String>();
for(k = 0; k < emphasesList.length ; k++ )
 {
  if(emphasesList[k][0].equals(name.toUpperCase()))
  {
   emphases.add(emphasesList[k][1]);
  }
 
 }
return emphases;
}

   /**
    * Removes a school from a user's saved school list
    * 
    * @param username - String) username of the account associated with the saved list 
    * @param univ - String) name of the school to be removed
    * @return int ; Number of schools removed from the saved list
    */
   public int removeSavedSchool(String username, String univ) {
	   return dbLibrary.user_removeSchool(username, univ);
   }

   /**
    * Returns a list of the user's saved schools, along with the date it was saved
    * 
    * @param username - String) the username of the account the list is saved to
    * @return ArrayList<String>
    */
  public ArrayList<String> viewSavedSchools(String username) {
	  
	  String [][] savedSchools = dbLibrary.user_getUsernamesWithSavedSchools();
	  ArrayList<String> results = new ArrayList<String>();
	  
	  if (savedSchools != null)
	{
	  
	  for (int i = 0; i < savedSchools.length; i++)
	  {
		  if(savedSchools[i][0].equals(username))
		  {
			  if (!results.contains(savedSchools[i][1]))
			  {
				  String nameDate = savedSchools[i][1] + " (added on: " + savedSchools[i][2] + ")";
				  results.add(nameDate);
			  }
		  }
	  }
	  return results;
	}
	
	else
	{
		System.err.println("Saved school list is empty");
	}
	  return results;
  }

  /**
   * Removes the specified university from the database
   * 
   * @param name - String ) Name of the university to remove
   * @return int ) Number of universities removed as a result ; or -1 if an error was encountered
   */
  public int removeUniversity(String name) {
	ArrayList<String> emphases = this.getEmphases(name);
	  
	for (String emph : emphases)
	{
		dbLibrary.university_removeUniversityEmphasis(name, emph);
	}
	  
	return dbLibrary.university_deleteUniversity(name);
  }
  
  /**
   * 
   * Edits a university in the database
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
	  return dbLibrary.university_editUniversity(name, state, location, control, numStudents, percFemales, satVerbal, satMath, expenses, 
			  percAid, numApply, percAdmit, percEnrolled, acadScale, socialScale, qualLife);
  }

  /**
   * Adds a profile to the database
   * 
   * @param acct
   * @return int ) Number of accounts added ; or -1 if an error is encountered
   */
  public int addProfile(Account acct) {
	  for (int i = 0; i < usernames.length; i++)
	  {
		  if(usernames[i][2].equals(acct.getUsername()))
		  {
			  return 0;
		  }
	  }
	  return dbLibrary.user_addUser(acct.getFirstName(), acct.getLastName(), acct.getUsername(), acct.getPassword(), acct.getType());
  }

/**
 * Returns a list of all profiles
 * 
 * @return String[][]
 */
  public ArrayList<Account> viewAllProfiles() 
  {String [][] usernames = dbLibrary.user_getUsers();
	  ArrayList<Account> accountList = new ArrayList<Account>();
	  
	  for (int i = 0; i < usernames.length; i++)
	  {
		  if (usernames[i][4].charAt(0) == 'U' || usernames[i][4].charAt(0) == 'u')
		  {
			  accountList.add(new User(usernames[i][0], usernames[i][1], usernames[i][2], usernames[i][3], usernames[i][4].charAt(0), usernames[i][5].charAt(0)));
		  }
		  
		  else if (usernames[i][4].charAt(0) == 'A' || usernames[i][4].charAt(0) == 'a')
		  {
			  accountList.add(new Admin(usernames[i][0], usernames[i][1], usernames[i][2], usernames[i][3], usernames[i][4].charAt(0), usernames[i][5].charAt(0)));
		  }
	  }
	  
	 return accountList;
  }
   
}