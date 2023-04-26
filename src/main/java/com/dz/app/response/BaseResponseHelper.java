package com.dz.app.response;

public class BaseResponseHelper<T> {

	
	
	public BaseResponseHelper() {
		super();
	}

	public BaseResponse<T> setSaveResponse(T resoponseObj) {
		BaseResponse<T> response=new BaseResponse<T>();
		
		return response;
	}

	public BaseResponse<T> setUpdateResponse(T resoponseObj) {
		BaseResponse<T> response=new BaseResponse<T>();
		return response;
	}

	public BaseResponse<T> setGetResponse(T resoponseObj) {
		BaseResponse<T> response=new BaseResponse<T>();
		if(resoponseObj !=null){
			response.setSuccessResponse(resoponseObj);
		}else {
			response.setFailResponse(resoponseObj);
		}
		return response;
	}

	public BaseResponse<T> setGetAllResponse(T resoponseObj) {
		BaseResponse<T> response=new BaseResponse<T>();
		return response;
	}
}
