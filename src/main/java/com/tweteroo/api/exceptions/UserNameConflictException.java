package com.tweteroo.api.exceptions;

public class UserNameConflictException extends RuntimeException {
	public UserNameConflictException(String message) {
		super(message);
	}
}