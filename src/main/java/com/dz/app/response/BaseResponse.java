package com.dz.app.response;

import com.dz.app.utility.Constant.ResponseCode;
import com.dz.app.utility.Constant.ResponseMessage;

public class BaseResponse<T> {

	private Integer responseCode;
	private String responseMessage;
	private T responseData;
	
	
	
	public BaseResponse() {
		super();
	}



	public void setSuccessResponse(T data) {
		this.setResponseCode(ResponseCode.SUCCESS.getResponseCodeValue());
		this.setResponseMessage(ResponseMessage.SUCCESS.getResponseMessageValue());
		this.setResponseData(data);
	}

	public void setFailResponse(T data) {
		this.setResponseCode(ResponseCode.FAIL.getResponseCodeValue());
		this.setResponseMessage(ResponseMessage.FAIl.getResponseMessageValue());
		this.setResponseData(data);
	}
	
	public Integer getResponseCode() {
		return responseCode;
	}


	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}


	public String getResponseMessage() {
		return responseMessage;
	}


	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}


	public T getResponseData() {
		return responseData;
	}


	public void setResponseData(T responseData) {
		this.responseData = responseData;
	}
	
}
