package TaskMaster;
import java.util.*;
import java.util.ArrayList;
/***
*@Class Name: sortingList.java
*@Description: This class implements the sorting when the user clicks the "Display by" drop down combo box
***/
public class sortingList{
	private ArrayList<Task> sortedList;
	/***
	*@MethodName: returnSortedList
	*@param: none
	*@return: ArrayList<Task>
	*@Description: This method returns a sorted ArrayList<Task>
	***/
	public ArrayList<Task> returnSortedList()
	{
		return sortedList;
	}
	/***
	*@MethodName: sortingList
	*@param: ArrayList<Task> list, int sortingBy
	*@return: none
	*@Description: This constructor takes in the list needs to be sorted and the sorting type, and then calls the comparator that sorts it. 
	***/
	public sortingList(ArrayList<Task> list, int sortingBy) {
		if(sortingBy==1) {
			Collections.sort(list, new sortByPriority());
		}
		if(sortingBy==2) {
			Collections.sort(list, new sortByDescription());
		}
		if(sortingBy==3) {
			Collections.sort(list, new sortByStatus());
		}
		if(sortingBy==4) {
			Collections.sort(list, new sortBystartDate());
		}
		if(sortingBy==5) {
			Collections.sort(list, new sortByDate());
		}
		sortedList = list;
		
	}
	
	/***
	*@MethodName: getSortedList
	*@param: none
	*@return: ArrayList<Task>
	*@Description: This method returns a sorted ArrayList<Task>
	***/
	public ArrayList<Task> getSortedList(){
		return sortedList;
	}

	/***
	*@ClassName: sortByDescription
	*@param: none
	*@return: Comparator
	*@Description: This method returns a Comparator for desc
	***/
public class sortByDescription implements Comparator<Task>{
	public int compare(Task a, Task b) {
		return a.getDescription().compareTo(b.getDescription());
	}
}
	
	/***
	*@ClassName: sortByStatus
	*@param: none
	*@return: Comparator
	*@Description: This method returns a Comparator for status
	***/
public class sortByStatus implements Comparator<Task>{
	public int compare(Task a, Task b) {
		return a.getStatus().compareTo(b.getStatus());
	}
}
	/***
	*@ClassName: sortByDate
	*@param: none
	*@return: Comparator
	*@Description: This method returns a Comparator for end date
	***/
public class sortByDate implements Comparator<Task>{
	public int compare(Task a, Task b) {
		return a.getenDate()- b.getenDate();
	}
}

	/***
	*@ClassName: sortBystartDate
	*@param: none
	*@return: Comparator
	*@Description: This method returns a Comparator for start date
	***/
public class sortBystartDate implements Comparator<Task>{
	public int compare(Task a, Task b) {
		return a.getstDate()- b.getstDate();
	}
}

	/***
	*@ClassName: sortByPriority
	*@param: none
	*@return: Comparator
	*@Description: This method returns a Comparator for priority
	***/
public class sortByPriority implements Comparator<Task>{
	public int compare(Task a, Task b) {
		return a.getPriority()-b.getPriority();
	}
}

}

