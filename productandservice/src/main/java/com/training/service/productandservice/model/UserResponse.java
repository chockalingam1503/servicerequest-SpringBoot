package com.training.service.productandservice.model;

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
public class UserResponse {

	private User user;
	private boolean errorFlag = false;
	private ErrorMessage errorDetails;

	public UserResponse(User user) {
		super();
		this.user = user;
	}

	public UserResponse(ErrorMessage errorDetails) {
		this.errorFlag = true;
		this.errorDetails = errorDetails;
	}

}
