package org.jsp.mailsendingapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
public class MailSendingController {
	@Autowired
	private JavaMailSender javaMailSender;
	@Value(value = "udayreddy")
	private String token;

	@PostMapping("/send-mail")
	public String sendMail(HttpServletRequest request, @RequestParam String email) {
		String siteUrl = request.getRequestURL().toString();
		String url = siteUrl.replace(request.getServletPath(), "/verify") + "?token=" + token;
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		try {
			helper.setTo(email);
			helper.setSubject("Account Verification");
			helper.setText(url);
			javaMailSender.send(message);
			return "Mail Has Been Sent";
		} catch (MessagingException e) {
			e.printStackTrace();
			return "Can not send mail";
		}
	}

	@GetMapping("/verify")
	public String verify(@RequestParam String token) {
		if (this.token.equals(token)) {
			return "Verification Successfull";
		} else {
			return "Cannot Verify";
		}
	}
}
