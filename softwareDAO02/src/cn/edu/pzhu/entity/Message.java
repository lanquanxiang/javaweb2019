package cn.edu.pzhu.entity;

public class Message {
	private boolean success;
	private String msg;
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Message(boolean success, String msg) {
		super();
		this.success = success;
		this.msg = msg;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
