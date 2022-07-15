package com.sgp.controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sgp.model.User;
import com.sgp.model.UserNotFoundException;
import com.sgp.service.Utility;
import com.sgp.service.impl.UserServiceImp;


import net.bytebuddy.utility.RandomString;

@Controller
public class ForgotPasswordController {
    @Autowired
    private JavaMailSender mailSender;
     
    @Autowired
    private UserServiceImp userServiceimp;
     
    @GetMapping("/forgot_password")
    public String showForgotPasswordForm( Model model) {
    	model.addAttribute("pageTitle", "forgot Password");
    	return "user/forgot_password_form";
    }
 
    @PostMapping("/forgot_password")
    public String processForgotPasswordForm(HttpServletRequest request, Model model) throws UserNotFoundException {
    	 String email = request.getParameter("email");
    	    String token = RandomString.make(45);
    	     
    	    try {
    	        userServiceimp.updateResetPasswordToken(token, email);
    	        String resetPasswordLink = Utility.getSiteURL(request) + "/reset_password?token=" + token;
    	        sendEmail(email, resetPasswordLink);
    	        model.addAttribute("message", "We have sent a reset password link to your email. Please check.");
    	         
    	    } catch (UserNotFoundException ex) {
    	        model.addAttribute("error", ex.getMessage());
    	    } catch (UnsupportedEncodingException | MessagingException e) {
    	        model.addAttribute("error", "Error while sending email");
    	    }
    	         
    	    return "user/forgot_password_form";
    	}
    
     
    public void sendEmail(String email, String resetPasswordLink)  throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = mailSender.createMimeMessage();              
        MimeMessageHelper helper = new MimeMessageHelper(message);
         
        helper.setFrom("hedichaker.sgp@gmail.com","sgp123");
        helper.setTo(email);
         
        String subject = "Here's the link to reset your password";
         
        String content = "<p>Hello,</p>"
                + "<p>You have requested to reset your password.</p>"
                + "<p>Click the link below to change your password:</p>"
                + "<p><b><a href=\"" + resetPasswordLink + "\">Change my password</a></b></p>"
                + "<br>"
                + "<p>Ignore this email if you do remember your password, "
                + "or you have not made the request.</p>";
         
        helper.setSubject(subject);
         
        helper.setText(content, true);
         
        mailSender.send(message);
    }
     
     
    @GetMapping("/reset_password")
    public String showResetPasswordForm(@Param(value = "token") String token, Model model) {
        User user = userServiceimp.getByResetPasswordToken(token);
        model.addAttribute("token", token);
         
        if (user == null) {
            model.addAttribute("message", "Invalid Token");
            return "message";
        }
         
        return "user/reset_password_form";
    }
    
    @PostMapping("/reset_password")
    public String processResetPassword(HttpServletRequest request, Model model) {
        String token = request.getParameter("token");
        String password = request.getParameter("password");
         
        User user = userServiceimp.getByResetPasswordToken(token);
        model.addAttribute("title", "Reset your password");
         
        if (user == null) {
            model.addAttribute("message", "Invalid Token");
            return "message";
        } else {           
            userServiceimp.updatePassword(user, password);
             
            model.addAttribute("message", "You have successfully changed your password.");
        }
         
        return "message";
    }
}