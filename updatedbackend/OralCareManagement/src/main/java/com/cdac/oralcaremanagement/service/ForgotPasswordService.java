package com.cdac.oralcaremanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cdac.oralcaremanagement.dao.UserRepository;
import com.cdac.oralcaremanagement.entity.User;

@Service
public class ForgotPasswordService {

   @Autowired
   private UserRepository userRepository;
   
   @Autowired
   private PasswordEncoder passwordEncoder;
   
   public String resetPassword(User user) {
	   User dbUser = userRepository.findByEmail(user.getEmail());
	   String ans = dbUser.getAns();
	   String ques=dbUser.getQue();
	   System.out.println(ques);
	   if(dbUser != null) {
		   if(user.getAns().equals(ans)) {
			   dbUser.setPassword(passwordEncoder.encode(user.getPassword()));
			   return "Password changed Successfully ";
		   }
		   return "wrong ans";
	   } else
		return "email not found";
   }
}
