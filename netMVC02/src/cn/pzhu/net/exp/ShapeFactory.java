package cn.pzhu.net.exp;

public class ShapeFactory {
	public static Shape getShape(String name){
		if(name==null) return null;
		if(name.equalsIgnoreCase("circle")){
			return new Circle();
		}
		//∆‰À˚Õº–Œ
		return null;
	}
}
