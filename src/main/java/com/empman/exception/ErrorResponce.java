package com.empman.exception;

import java.util.Date;

public class ErrorResponce
{
	private Date timeStamp;
	private String fieldName;
	private String fieldMessage;
	private String status;
	
	public ErrorResponce() 
	{
		 super();
	}

	public ErrorResponce(Date timeStamp, String fieldName, String fieldMessage, String status) {
		super();
		this.timeStamp = timeStamp;
		this.fieldName = fieldName;
		this.fieldMessage = fieldMessage;
		this.status = status;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldMessage() {
		return fieldMessage;
	}

	public void setFieldMessage(String fieldMessage) {
		this.fieldMessage = fieldMessage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
}