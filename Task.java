package TaskMaster;

import java.util.ArrayList;
import java.util.Date;

public class Task {
	private String description;
	private int priority;
	private int stmonth, stday, styear;
	private int enmonth, enday, enyear;
	private String status;
	
	
	public Task()
	{
		
	}
	
	public Task(String description, int prioirty, int stmonth, int stday, int styear, int endmonth, int endday, int endyear, String status)
	{
		this.description = description;
		this.priority = priority;

		this.enmonth = endmonth;
		this.enday = endday;
		this.enyear = endyear;
		

		this.stmonth = stmonth;
		this.stday = stday;
		this.styear = styear;
		
		this.status = status;
	}

	ArrayList<String> entry = new ArrayList<String>();

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
		this.styear = styear;
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
		this.enyear = enyear;
	}

	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	public String toString()
	{
		/*
		String a ="";
		a+="Description:\t\t" +getDescription()+"\n";
		a+="Priority:\t\t\t" +getPriority()+"\n";
		a+="Start Date:\t\t" +getstMonth()+"/" +getstDay()+"/" +getstYear()+"\n";

		a+="End Date:\t\t\t" +getenMonth()+"/" +getenDay()+"/" +getenYear()+"\n";

		a+="Status:\t\t\t" +status+"\n";
		*/
		
		
		return "KOPKO";
	}
	
}