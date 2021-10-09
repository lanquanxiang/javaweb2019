package cn.edu.pzhu.sw.exp;

public class Circle implements Shape {
	private double r;

	public Circle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Circle(double r) {
		super();
		this.r = r;
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return Math.PI*r*r;
	}
	
}
