package cn.edu.pzhu.util;

import java.util.ArrayList;
import java.util.List;

import cn.edu.pzhu.entity.Car;

public class PageUtil {

	public static List<Car> splitList(List<Car> list, int page, int num) {
		List<Car> temp = new ArrayList<Car>();
		if (list==null || list.size()==0) {
			return null;
		}
		if (page<=0) {
			page = 1;//return null;
		}
		if (num<=0) {
			num = 10;
		}
		//52 10 1 [0-10)
		//52 10 2 [10-20)
		//52 10 6 [50-52)
		for (int i = (page-1)*num ; i < page*num && i<list.size(); i++) {
			temp.add(list.get(i));
		}
		return temp;
	}

	public static StringBuffer createBar(List<Car> list, int page, int num,String path) {
		StringBuffer bar = new StringBuffer();
		if (list==null || list.size()==0) {
			return null;
		}
		int pages = list.size()%num==0?list.size()/num:list.size()/num+1;
		if (page<=0) {
			page = 1;//return null;
		}
		if (page>pages) {
			page = pages;
		}
		if (num<=0) {
			num = 10;
		}
		
		if (page>1) {
			bar.append("<a href='"+path+"?page="+(page-1)+"&num="+num+"'>上一页</a>    ");
		}
		
		for (int i = 1; i <= pages; i++) {
			if (page==i) {
				bar.append("  ["+i+"]   ");
			}else{
				bar.append("  "+"<a href='"+path+"?page="+i+"&num="+num+"'>"+i+"</a>"+"   ");
			}
		}
		
		if(page<pages){
			bar.append("<a href='"+path+"?page="+(page+1)+"&num="+num+"'>下一页</a>    ");
		}
		return bar;
	}

}
