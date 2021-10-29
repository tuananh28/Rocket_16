package com.vti.service;

public interface IEmailService {

	public void sendRegistrationUserConfirm(String email);

	public void sendResetPassword(String email);

}
