package sorting;
import java.util.Vector;
import beans.ResultBean;

public class SwitchSort {
	
	public void choiceSort(String choice, Vector<ResultBean> temp){
		switch(choice) {
		case "rollno": temp.sort(new ByRollno());
			break;
		case "totalmarks": temp.sort(new ByTotalmarks());
			break;
		default : temp.sort(null);
		}
	}
}
