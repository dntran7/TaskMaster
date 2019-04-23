package TaskMaster;


public class Task {
	private String description;
	private int priority;
	private int startMonth, startDay, startYear;
	private int endMonth,endDay, endYear;
	private String status;
	
	
	public Task()
	{
		
	}
	
	
	public Task(String description, int prioirty, int stmonth, int stday, int styear, int endmonth, int endday, int endyear, String status)
	{
		this.description = description;
		this.priority = priority;

		this.endMonth = endmonth;
		this.endDay = endday;
		this.endYear = endyear;
		

		this.startMonth = stmonth;
		this.startDay = stday;
		this.startYear = styear;
		
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


	


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}




	public int getStartMonth() {
		return startMonth;
	}




	public void setStartMonth(int startMonth) {
		this.startMonth = startMonth;
	}




	public int getStartDay() {
		return startDay;
	}




	public void setStartDay(int startDay) {
		this.startDay = startDay;
	}




	public int getStartYear() {
		return startYear;
	}




	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}




	public int getEndMonth() {
		return endMonth;
	}




	public void setEndMonth(int endMonth) {
		this.endMonth = endMonth;
	}




	public int getEndDay() {
		return endDay;
	}




	public void setEndDay(int endDay) {
		this.endDay = endDay;
	}




	public int getEndYear() {
		return endYear;
	}




	public void setEndYear(int endYear) {
		this.endYear = endYear;
	}
	
	public String toString()
	{
		String a ="";
		a+="Description:\t\t" +getDescription()+"\n";
		a+="Priority:\t\t\t" +getPriority()+"\n";
		a+="Start Date:\t\t" +getStartMonth()+"/" +getStartDay()+"/" +getStartYear()+"\n";

		a+="End Date:\t\t\t" +getEndMonth()+"/" +getEndDay()+"/" +getEndYear()+"\n";

		a+="Status:\t\t\t" +status+"\n";
		
		return a;
	}
	

}
