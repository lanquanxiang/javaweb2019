package cn.edu.pzhu.sw.exp;

public class ShapeFactory {
	public static Shape getShape(String name,double... args){
		if (name==null) {
			return null;
		}
		if (name.equalsIgnoreCase("circle")) {
			return new Circle();
		}
		//.....其他图形的初始化
		return null;
	}
}
