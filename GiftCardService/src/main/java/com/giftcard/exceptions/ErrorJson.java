package com.giftcard.exceptions;

import java.util.Map;

public class ErrorJson {

	private Integer status;
	private String message;
	private String timeStamp;

	public ErrorJson(int status, Map<String, Object> errorAttributes) {
		this.status = 404;
		this.message = (String) errorAttributes.get("message");
		this.timeStamp = errorAttributes.get("timestamp").toString();
	}

	public Integer getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public String getTimeStamp() {
		return timeStamp;
	}
}
