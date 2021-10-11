package cn.edu.pzhu.sw.exp;

public class ShapeFactory {
	//还需要传入图形的其他参数
	public static Shape getShape(String name){
		if(name == null){
	         return null;
	      }        
	      if(name.equalsIgnoreCase("CIRCLE")){
	         return new Circle();
	      } else if(name.equalsIgnoreCase("RECTANGLE")){
	         return new Rectangle();
	      } else if(name.equalsIgnoreCase("Triangle")){
	         return null;
	      }
	      return null;
	}
}
