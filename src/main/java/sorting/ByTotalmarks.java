package sorting;

import java.util.Comparator;

import beans.ResultBean;

public class ByTotalmarks implements Comparator<ResultBean>{
	public int compare(ResultBean rb1, ResultBean rb2) {
		if(rb1.getTotmarks()==rb2.getTotmarks())return 0;
		else if(rb1.getTotmarks()>rb2.getTotmarks())return 1;
		else return -1;
	}

}
