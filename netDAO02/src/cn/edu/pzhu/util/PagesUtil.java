package cn.edu.pzhu.util;

import java.util.ArrayList;

import cn.edu.pzhu.entity.Car;

public class PagesUtil {

	public static ArrayList<Car> splitList(ArrayList<Car> list, int page, int num) {
		if (list==null) {	
			return null;
		}
		if (page<=0) {
			page=1;
		}
		if (num<=0) {
			num=10;
		}
		//temp表示分割之后的集合
		/*	page    num
		 * 1		10		[0-10)
		 * 2		10		[10-20)
		 * 6		10		[50-52)
		 */
		ArrayList<Car> temp = new ArrayList<>();
		for (int i = (page-1)*num; i < page*num && i<list.size(); i++) {
			temp.add(list.get(i));
		}
		return temp;
	}

	public static StringBuffer createBar(ArrayList<Car> list, int page, int num,String path) {
		if (list==null) {return null;}
		int pages = list.size()%num==0?list.size()/num:list.size()/num+1;
		if (page<=0) {page=1;}
		if (page>pages) {page=pages;}
		if (num<=0) {num=10;}
		StringBuffer bar = new StringBuffer();
		if (page>1) {
			// "<a href='url?page=5&num=5'>上一页</a>"
			bar.append("<a href='"+path+"?page="+(page-1)+"&num="+num+"'>上一页</a>  ");
		}
		for(int i=1;i<=pages;i++){
			if (page==i) {
				bar.append("  [" + i+ "]  ");
			}else{
				bar.append("<a href='"+path+"?page="+i+"&num="+num+"'>  "+i+"  </a>");
			}
		}
		if(page<pages) {
			bar.append("<a href='"+path+"?page="+(page+1)+"&num="+num+"'>  下一页</a>");
		}
		return bar;
	}

	
}
