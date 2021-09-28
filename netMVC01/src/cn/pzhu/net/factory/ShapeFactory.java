package cn.pzhu.net.factory;

public class ShapeFactory {
	public Shape getShape(String name){
		if("circle".equals(name)){
			return new Circle();
		}
		if("rectangle".equals(name)){
			return null;
		}
		return null;
	}
}
