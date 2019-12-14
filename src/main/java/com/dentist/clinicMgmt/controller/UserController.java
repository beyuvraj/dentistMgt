package com.dentist.clinicMgmt.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dentist.clinicMgmt.model.User;

@RestController
public class UserController {

	@GetMapping("/userDetails")
	public List<User> getUserDetail() {
		return Arrays.asList(
				new User(1L, 1L, "Yuvraj", "Radhai building", 97986568L));
	}
}
