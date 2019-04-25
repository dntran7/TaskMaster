package TaskMaster;
import java.util.*;
import java.util.ArrayList;

public class sortingList{
	private ArrayList<Task> sortedList;
	public ArrayList<Task> returnSortedList()
	{
		return sortedList;
	}
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
	
	public ArrayList<Task> getSortedList(){
		return sortedList;
	}


public class sortByDescription implements Comparator<Task>{
	public int compare(Task a, Task b) {
		return a.getDescription().compareTo(b.getDescription());
	}
}
public class sortByStatus implements Comparator<Task>{
	public int compare(Task a, Task b) {
		return a.getStatus().compareTo(b.getStatus());
	}
}
public class sortByDate implements Comparator<Task>{
	public int compare(Task a, Task b) {
		return a.getenDate()- b.getenDate();
	}
}

public class sortBystartDate implements Comparator<Task>{
	public int compare(Task a, Task b) {
		return a.getstDate()- b.getstDate();
	}
}

public class sortByPriority implements Comparator<Task>{
	public int compare(Task a, Task b) {
		return a.getPriority()-b.getPriority();
	}
}

}

