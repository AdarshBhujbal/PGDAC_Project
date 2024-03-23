package com.cdac.oralcaremanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.oralcaremanagement.entity.User;
import com.cdac.oralcaremanagement.service.ForgotPasswordService;


@RestController
@RequestMapping("/forgot-password")
@CrossOrigin("*")
public class ForgotPasswordController {

    @Autowired
    private ForgotPasswordService forgotPasswordService;

    //http://localhost:8000/forgot-password/reset
    @PostMapping("/reset")
    public ResponseEntity<String> resetPassword(@RequestBody User user) {
        String result = forgotPasswordService.resetPassword(user);
        if (result.equals("Password reset successfully")) {
            return ResponseEntity.ok(result);
        } else if (result.equals("wrong answer")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        } else if (result.equals("email not found")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
        }
    }
}
