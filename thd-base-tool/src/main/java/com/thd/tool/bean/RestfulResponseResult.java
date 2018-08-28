package com.thd.tool.bean;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


/**
 * 该类是用于restful服务出现错误时返回客户端的DTO
 * @author wangl
 *
 */
public class RestfulResponseResult {
	//HTTP状态码(只有为200才是正确返回,如果不是200则需要设置message属性)
	private int httpCode ;
	
	//HTTP状态码对应英文状态
	private HttpStatus httpStatus;
	//返回结果
	private Object result;
	//消息
    private String message;

    
    public static ResponseEntity returnSuccess(Object obj){
    	RestfulResponseResult rrr = new RestfulResponseResult();
    	rrr.setHttpStatus(HttpStatus.OK);
    	rrr.setHttpCode(HttpStatus.OK.value());
    	rrr.setResult(obj);
    	return new ResponseEntity<RestfulResponseResult>(rrr,rrr.getHttpStatus());
    }
    
    public static ResponseEntity returnFailure(HttpStatus httpStatus,String message){
    	RestfulResponseResult rrr = new RestfulResponseResult();
    	rrr.setHttpStatus(httpStatus);
    	rrr.setHttpCode(httpStatus.value());
    	rrr.setMessage(message);
    	return new ResponseEntity<RestfulResponseResult>(rrr,rrr.getHttpStatus());
    }
    
    
    

    public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public int getHttpCode() {
		return httpCode;
	}
	public void setHttpCode(int httpCode) {
		this.httpCode = httpCode;
	}
}
