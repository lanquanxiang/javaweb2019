package cn.pzhu.net.model;

public class Single {
	private static Single single = new Single();
	private Single() {
		// TODO Auto-generated constructor stub
	}
	public static Single getSingle() {
		return single;
	}
	//Single.getSingle()
}
