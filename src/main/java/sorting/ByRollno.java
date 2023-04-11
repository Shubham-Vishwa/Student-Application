package sorting;

import java.util.Comparator;

import beans.ResultBean;

public class ByRollno implements Comparator<ResultBean>{

	public int compare(ResultBean rb1, ResultBean rb2) {
		//ResultBean rb1 = (ResultBean)o1;
		//ResultBean rb2 = (ResultBean)o2;
		int z = rb1.getRollno().compareTo(rb2.getRollno());
		
		if(z==0) return 0;
		else if(z>0) return 1;
		else return -1;
	}
}
