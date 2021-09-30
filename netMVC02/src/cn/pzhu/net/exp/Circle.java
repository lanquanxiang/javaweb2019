package cn.pzhu.net.exp;

public class Circle implements Shape{
	
	private double r;
	
	@Override
	public boolean check() {
		if(r>0) return true;
		return false;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return 2*Math.PI*r*r;
	}

}
