package cn.edu.pzhu.sw.exp;

public class ShapeFactory {
	public static Shape getShape(String name,double... args){
		if (name==null) {
			return null;
		}
		if (name.equalsIgnoreCase("circle")) {
			return new Circle();
		}
		//.....����ͼ�εĳ�ʼ��
		return null;
	}
}
