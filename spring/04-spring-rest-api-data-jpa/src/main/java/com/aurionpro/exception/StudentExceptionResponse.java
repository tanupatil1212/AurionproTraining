package com.aurionpro.exception;

public class StudentExceptionResponse {
	private int status;
	private String messgae;
	private long timeStamp;
	public StudentExceptionResponse(int status, String messgae, long timeStamp) {
		super();
		this.status = status;
		this.messgae = messgae;
		this.timeStamp = timeStamp;
	}
	public StudentExceptionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessgae() {
		return messgae;
	}
	public void setMessgae(String messgae) {
		this.messgae = messgae;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	

}
