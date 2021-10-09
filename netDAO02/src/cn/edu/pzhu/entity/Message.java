package cn.edu.pzhu.entity;

public class Message {
	private boolean res;
	private String msg;
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Message(boolean res, String msg) {
		super();
		this.res = res;
		this.msg = msg;
	}
	public boolean isRes() {
		return res;
	}
	public void setRes(boolean res) {
		this.res = res;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
