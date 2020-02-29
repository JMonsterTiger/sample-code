/**
 * 
 */

package FTMT;

import java.util.*;

public class University
{

  String name;
  String state;
  String location;
  String control;
  int numStudents;
  double percFemales;
  double satVerbal;
  double satMath;
  double expenses;
  double percAid;
  double percAdmit;
  double percEnrolled;
  int acadScale;
  int socialScale;
  int qualLife;
  int numApply;
  DBController dbController = new DBController();
  
  String [] info = new String[15];
  
  /**
   * 
   * @param name - String ) 
   * @param state - String ) 
   * @param location - String ) 
   * @param control - String ) 
   * @param numStudents - int ) 
   * @param percFemales - double ) 
   * @param satVerbal - double ) 
   * @param satMath - double ) 
   * @param expenses - double ) 
   * @param percAid - double ) 
   * @param numApply - int ) 
   * @param percAdmit - double ) 
   * @param percEnrolled - double ) 
   * @param acadScale - int ) 
   * @param socialScale - int ) 
   * @param qualLife - int ) Quality of life (out of 5)
   */
  public University(String name, String state, String location, String control, int numStudents, double percFemales, double satVerbal,
                    double satMath, double expenses, double percAid, int numApply, double percAdmit, double percEnrolled, 
                    int acadScale, int socialScale, int qualLife)
  {
    this.name = name;
    this.state = state;
    this.location = location;
    this.control = control;
    this.numStudents = numStudents;
    this.percFemales = percFemales;
    this.satVerbal = satVerbal;
    this.satMath = satMath;
    this.expenses = expenses;
    this.percAid = percAid;
    this.percAdmit = percAdmit;
    this.percEnrolled = percEnrolled;
    this.acadScale = acadScale;
    this.socialScale = socialScale;
    this.qualLife = qualLife;
    this.numApply = numApply;
  }
  
  public University() {
	  this.name = "-1";
	    this.state = "-1";
	    this.location = "-1";
	    this.control = "-1";
	    this.numStudents = -1;
	    this.percFemales = -1;
	    this.satVerbal = -1;
	    this.satMath = -1;
	    this.expenses = -1;
	    this.percAid = -1;
	    this.percAdmit = -1;
	    this.percEnrolled = -1;
	    this.acadScale = -1;
	    this.socialScale = -1;
	    this.qualLife = -1;
	    this.numApply = -1;
}
  
  public University(String [] array) {
	    this.name = array[0];
	    this.state = array[1];
	    this.location = array[2];
	    this.control = array[3];
	    this.numStudents = Integer.parseInt(array[4]);
	    this.percFemales = Double.parseDouble(array[5]);
	    this.satVerbal = Double.parseDouble(array[6]);
	    this.satMath = Double.parseDouble(array[7]);
	    this.expenses = Double.parseDouble(array[8]);
	    this.percAid = Double.parseDouble(array[9]);
	    this.numApply = Integer.parseInt(array[10]);
	    this.percAdmit = Double.parseDouble(array[11]);
	    this.percEnrolled = Double.parseDouble(array[12]);
	    this.acadScale = Integer.parseInt(array[13]);
	    this.socialScale = Integer.parseInt(array[14]);
	    this.qualLife = Integer.parseInt(array[15]);
  }
  
  /**
   * Returns a string representation of the University's information
   * 
   * @return String
   */
	@Override
	public String toString() {
		return "University [name: " + name + ", state: " + state + ", location: " + location + ", control: " + control
				+ ", numStudents: " + numStudents + ", percFemales: " + percFemales + ", satVerbal: " + satVerbal
				+ ", satMath: " + satMath + ", expenses: " + expenses + ", percAid: " + percAid + ", percAdmit: "
				+ percAdmit + ", percEnrolled: " + percEnrolled + ", acadScale: " + acadScale + ", socialScale: "
				+ socialScale + ", qualLife: " + qualLife + ", numApply: " + numApply + "]";
	}

	/**
	   * Returns an array of string values of the University
	   * 
	   * @return String[]
	   */
public String[] getUniversityInfo()
  {
    info[0] = this.name;
    info[1] = this.state;
    info[2] = this.location;
    info[3] = this.control;
    info[4] = Double.toString(this.numStudents);
    info[5] = Double.toString(this.percFemales);
    info[6] = Double.toString(this.satVerbal);
    info[7] = Double.toString(this.satMath);
    info[8] = Double.toString(this.expenses);
    info[9] = Double.toString(this.percAid);
    info[10] = Integer.toString(this.numApply);
    info[11] = Double.toString(this.percAdmit);
    info[12] = Double.toString(this.percEnrolled);
    info[13] = Integer.toString(this.acadScale);
    info[14] = Integer.toString(this.socialScale);
    info[15] = Integer.toString(this.qualLife);
    
    return info;
  }

/**
 * @return the name
 */
public String getName() {
	return name;
}

/**
 * @param name - String ) the name to set
 */
public void setName(String name) {
	this.name = name;
}

/**
 * @return String
 */
public String getState() {
	return state;
}

/**
 * @param state the state to set
 */
public void setState(String state) {
	this.state = state;
}

/**
 * @return String
 */
public String getLocation() {
	return location;
}

/**
 * If location is valid, sets the location of the University
 * 
 * @param location the location to set
 */
public void setLocation(String location){
	if (location == "SMALL-CITY" || location == "SUBURBAN" || location == "URBAN")
	{
		this.location = location;
	}
	
	else
	{
		this.location = "-1";
	}
}

/**
 * @return String
 */
public String getControl() {
	return control;
}

/**
 * If control is valid, sets the control of the University; Else, sets it to unknown (-1)
 * 
 * @param control the control to set
 */
public void setControl(String control) {
	if (control == "CITY" || control == "PRIVATE" || control == "STATE")
	{
		this.control = control;
	}
	
	else
	{
		this.control = "-1";
	}
}

/**
 * @return int
 */
public int getNumStudents() {
	return numStudents;
}

/**
 * If numStudents is a positive number, sets the numStudents of the University; Else, sets it to 0
 * 
 * @param numStudents the numStudents to set
 */
public void setNumStudents(int numStudents) {
	if (numStudents >= 0)
	{
		this.numStudents = numStudents;
	}
	else
	{
		this.numStudents = 0;
	}
}

/**
 * @return double
 */
public double getPercFemales() {
	return percFemales;
}

/**
 * If percFemales is a positive number less than or equal to 100, sets the percFemales of the University; Else, sets it to 0
 * 
 * @param percFemales the percFemales to set
 */
public void setPercFemales(double percFemales) {
	if (percFemales >= 0 && percFemales <= 100)
		this.percFemales = percFemales;
	else if (percFemales > 100)
		this.percFemales = 100;
	else
	{
		this.percFemales = 0;
	}
}

/**
 * @return double
 */
public double getSatVerbal() {
	return satVerbal;
}

/**
 * If satVerbal is a positive number under 800, sets the satVerbal of the University; Else, sets it to 0
 * 
 * @param satVerbal the satVerbal to set
 */
public void setSatVerbal(double satVerbal) {
	if (satVerbal >= 0 && satVerbal <= 800)
		this.satVerbal = satVerbal;
	else if (satVerbal > 800)
		this.satVerbal = 800;
	else
	{
		this.satVerbal = 0;
	}
}

/**
 * @return double
 */
public double getSatMath() {
	return satMath;
}

/**
 * If satMath is a positive number under 800, sets the satMath of the University; Else, sets it to 0
 * 
 * @param satMath the satMath to set
 */
public void setSatMath(double satMath) {
	if (satMath >= 0 && satMath <= 800)
		this.satMath = satMath;
	else if (satMath > 800)
		this.satMath = 800;
	else
	{
		this.satMath = 0;
	}
}

/**
 * @return double
 */
public double getExpenses() {
	return expenses;
}

/**
 * If expenses is a positive number, sets the expenses of the University; Else, sets it to 0
 * 
 * @param expenses the expenses to set
 */
public void setExpenses(double expenses) {
	if (expenses >= 0)
		this.expenses = expenses;
	else
	{
		this.expenses = 0;
	}
}

/**
 * @return double
 */
public double getPercAid() {
	return percAid;
}

/**
 * If percAid is a positive number under 100, sets the percAid of the University; Else, sets it to 0
 * 
 * @param percAid the percAid to set
 */
public void setPercAid(double percAid) {
	if (percAid >= 0 && percAid <= 100)
		this.percAid = percAid;
	else if (percAid > 100)
		this.percAid = 100;
	else
	{
		this.percAid = 0;
	}
}

/**
 * @return double
 */
public double getPercAdmit() {
	return percAdmit;
}

/**
 * If percAdmit is a positive number under 100, sets the percAdmit of the University; Else, sets it to 0
 * 
 * @param percAdmit the percAdmit to set
 */
public void setPercAdmit(double percAdmit) {
	if (percAdmit >= 0 && percAdmit <= 100)
		this.percAdmit = percAdmit;
	else if (percAdmit > 100)
		this.percAdmit = 100;
	else
	{
		this.percAdmit = 0;
	}
}

/**
 * @return double
 */
public double getPercEnrolled() {
	return percEnrolled;
}

/**
 * If percEnrolled is a positive number under 100, sets the percEnrolled of the University; Else, sets it to 0
 * 
 * @param percEnrolled the percEnrolled to set
 */
public void setPercEnrolled(double percEnrolled) {
	if (percEnrolled >= 0 && percEnrolled <= 100)
		this.percEnrolled = percEnrolled;
	else if (percEnrolled > 100)
		this.percEnrolled = 100;
	else
	{
		this.percEnrolled = 0;
	}
}

/**
 * @return int
 */
public int getAcadScale() {
	return acadScale;
}

/**
 * If acadScale is a number between 1 and 5, sets the acadScale of the University; Else, sets it to 1
 * 
 * @param acadScale the acadScale to set
 */
public void setAcadScale(int acadScale) {
	if (acadScale >= 1 && acadScale <= 5)
		this.acadScale = acadScale;
	else
	{
		this.acadScale = 1;
	}
}

/**
 * @return int
 */
public int getSocialScale() {
	return socialScale;
}

/**
 * If socialScale is a number between 1 and 5, sets the socialScale of the University; Else, sets it to 1
 * 
 * @param socialScale the socialScale to set
 */
public void setSocialScale(int socialScale) {
	if (socialScale >= 1 && socialScale <= 5)
		this.socialScale = socialScale;
	else
	{
		this.socialScale = 1;
	}
}

/**
 * @return int
 */
public int getQualLife() {
	return qualLife;
}

/**
 * If qualLife is a number between 1 and 5, sets the qualLife of the University; Else, sets it to 1
 * 
 * @param qualLife the qualLife to set
 */
public void setQualLife(int qualLife) {
	if (qualLife >= 1 && qualLife <= 5)
		this.qualLife = qualLife;
	else
	{
		this.qualLife = 1;
	}
}

/**
 * @return int
 */
public int getNumApply()
{
	return this.numApply;
}

/**
 * If percEnrolled is a positive number under 100, sets the percEnrolled of the University; Else, sets it to 0
 * 
 * @param numApply the numApply to set
 */
public void setNumApply(int numApply) {
	if (numApply >= 0)
		this.numApply = numApply;
	else
	{
		this.numApply = 0;
	}
}

/**
 * @return String[]
 */
public String[] getInfo() {
	return info;
}

/**
 * @param info the info to set
 */
public void setInfo(String[] info) {
	this.info = info;
	
	setName(info[0]);
    setState(info[1]);
    setLocation(info[2]);
    setControl(info[3]);
    setNumStudents(Integer.parseInt(info[4]));
    setPercFemales(Double.parseDouble(info[5]));
    setSatVerbal(Double.parseDouble(info[6]));
    setSatMath(Double.parseDouble(info[7]));
    setExpenses(Integer.parseInt(info[8]));
    setPercAid(Double.parseDouble(info[9]));
    setNumApply(Integer.parseInt(info[10]));
    setPercAdmit(Double.parseDouble(info[11]));
    setPercEnrolled(Double.parseDouble(info[12]));
    setAcadScale(Integer.parseInt(info[13]));
    setSocialScale(Integer.parseInt(info[14]));
    setQualLife(Integer.parseInt(info[15]));
}
}