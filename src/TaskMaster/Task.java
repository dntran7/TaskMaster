
package TaskMaster;

import java.util.Date;

public class Task {
	private String description;
	private int priority;
	private int stmonth, stday, styear, stdate;
	private int enmonth, enday, enyear, endate;
	private String status;
	
	
	public Task()
	{
		
	}
	
	public Task(String description, int prior, int stmonth, int stday, int styear, int endmonth, int endday, int endyear, String status)
	{
		this.description = description;
		this.priority = prior;

		this.enmonth = endmonth;
		this.enday = endday;
		this.enyear = endyear;
		String endmonthString;
		if(endmonth<10) {
			endmonthString = "0"+Integer.toString(endmonth);
		}
		else {
			endmonthString = Integer.toString(endmonth);
		}
		String enddayString;
		if(endday<10) {
			enddayString = "0"+Integer.toString(endday);
		}
		else {
			enddayString = Integer.toString(endday);
		}
		String temp = Integer.toString(endyear)+endmonthString+enddayString;
		this.endate = Integer.parseInt(temp);
		

		this.stmonth = stmonth;
		this.stday = stday;
		this.styear = styear;
		String stmonthString;
		if(stmonth<10) {
			stmonthString = "0"+Integer.toString(stmonth);
		}
		else {
			stmonthString = Integer.toString(stmonth);
		}
		String stdayString;
		if(stday<10) {
			stdayString = "0"+Integer.toString(stday);
		}
		else {
			stdayString = Integer.toString(stday);
		}
		temp = Integer.toString(styear)+stmonthString+stdayString;
		this.stdate = Integer.parseInt(temp);
		this.status = status;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getPriority() {
		return priority;
	}


	public void setPriority(int priority) {
		this.priority = priority;
	}


	public int getstMonth() {
		return stmonth;
	}


	public void setstMonth(int stmonth) {
		this.stmonth = stmonth;
	}


	public int getstDay() {
		return stday;
	}


	public void setstDay(int stday) {
		this.stday = stday;
	}


	public int getstYear() {
		return styear;
	}


	public void setstYear(int year) {
		this.styear = year;
	}
	
	public int getenMonth() {
		return enmonth;
	}


	public void setenMonth(int enmonth) {
		this.enmonth = enmonth;
	}


	public int getenDay() {
		return enday;
	}


	public void setenDay(int enday) {
		this.enday = enday;
	}


	public int getenYear() {
		return enyear;
	}


	public void setenYear(int year) {
		this.enyear = year;
	}

	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	public int getenDate() {
		return endate;
	}
	
	public int getstDate() {
		return stdate;
	}

	public boolean checkDate() {
		if (stdate<=endate){
			return true;
		}else {
			return false;
		}
	}
	public String toString()
	{
		String a ="";
		a+="Description:\t\t" +getDescription()+"\n";
		a+="Priority:\t\t\t" +getPriority()+"\n";
		a+="Start Date:\t\t" +getstMonth()+"/" +getstDay()+"/" +getstYear()+"\n";

		a+="End Date:\t\t\t" +getenMonth()+"/" +getenDay()+"/" +getenYear()+"\n";

		a+="Status:\t\t\t" +status+"\n";
		
		//return "KOPKO";
		return a;
	}
}
