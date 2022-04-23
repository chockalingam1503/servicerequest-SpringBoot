package com.training.service.productandservice.data;

import java.util.List;

import com.training.service.productandservice.exceptions.ErrorMessage;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class RequestResponse {

	private Request request;
	private List<Request> requestList;
	private boolean errorFlag = false;
	private ErrorMessage errorDetails;

	public RequestResponse(Request request) {
		super();
		this.request = request;
	}
	
	public RequestResponse( List<Request> requestList) {
		super();
		this.requestList = requestList;
	}

	public RequestResponse(ErrorMessage errorDetails) {
		this.errorFlag = true;
		this.errorDetails = errorDetails;
	}

}
