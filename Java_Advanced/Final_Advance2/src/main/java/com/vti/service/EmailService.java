package com.vti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.vti.entity.Account;
import com.vti.repository.RegistrationUserTokenRepository;
import com.vti.repository.ResetPasswordTokenRepository;

@Component
public class EmailService implements IEmailService {

	@Autowired
	private IAccountService accountService;

	@Autowired
	private RegistrationUserTokenRepository registrationUserTokenRepository;

	@Autowired
	private ResetPasswordTokenRepository resetPasswordTokenRepository;

	@Autowired
	private JavaMailSender mailSender;

	/*
	 * @see
	 * com.vti.service.IEmailService#sendRegistrationUserConfirm(java.lang.String)
	 */
	@Override
	public void sendRegistrationUserConfirm(String email) {

		Account account = accountService.getAccountByEmail(email);
		String token = registrationUserTokenRepository.findByUserId(account.getId());

		String confirmationUrl = "http://localhost:8080/api/v1/registration/activeUser?token=" + token;

		String subject = "Xác Nhận Đăng Ký Account";
		String content = "Bạn đã đăng ký thành công. Click vào link dưới đây để kích hoạt tài khoản \n"
				+ confirmationUrl;

		sendEmail(email, subject, content);

	}

	@Override
	public void sendResetPassword(String email) {
		Account account = accountService.getAccountByEmail(email);

		String token = resetPasswordTokenRepository.findByUserId(account.getId());

		String confirmationUrl = "http://localhost:3000/auth/new-password/" + token;

		String subject = "Thiết lập lại mật khẩu";
		String content = "Click vào link dưới đây để thiết lập lại mật khẩu (nếu không phải bạn xin vui lòng bỏ qua).\n"
				+ confirmationUrl;
		sendEmail(email, subject, content);
	}

	private void sendEmail(final String recipientEmail, final String subject, final String content) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(recipientEmail);
		message.setSubject(subject);
		message.setText(content);

		mailSender.send(message);
	}

}
