package com.dentist.clinicMgmt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dentist.clinicMgmt.exception.ResourceNotFoundException;
import com.dentist.clinicMgmt.model.User;
import com.dentist.clinicMgmt.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
    private UserRepository userRepository;

	@GetMapping("/userDetail")
	public List<User> getAllUserDetail() {
		return userRepository.findAll();
	}
	
	@GetMapping("/userDetail/{user_id}")
    @ResponseBody
    public Optional<User> findByUserId(@PathVariable("user_id") Long userId)
    {
        return userRepository.findById(userId);
    }
	
	@PostMapping(path = "/userDetail", 
				consumes = "application/json", 
				produces = "application/json")
	public User addUserDetail(@RequestBody User user) {
		System.out.println(" User obj:" + user);
	    return userRepository.save(user);
	}
	
	@PutMapping("/userDetail/{id}")
	public ResponseEntity<User> updateUserDetail(@PathVariable(value = "id") Long userId,
	  @Valid @RequestBody User userDetail) throws ResourceNotFoundException {
		User user = userRepository.findById(userId)
	 .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

	 user.setEmail(userDetail.getEmail());
	 user.setLast_name(userDetail.getLast_name());
	 user.setFirst_name(userDetail.getFirst_name());
	 user.setAddress(userDetail.getAddress());
	 user.setMobile_no(userDetail.getMobile_no());
	 final User updateduser = userRepository.save(user);
	 return ResponseEntity.ok(updateduser);
	}
	
	@DeleteMapping("/userDetail/{id}")
	public Map<String, Boolean> deleteuser(@PathVariable(value = "id") Long userId)
	  throws ResourceNotFoundException {
	 User user = userRepository.findById(userId)
	   .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

	 userRepository.delete(user);
	 Map<String, Boolean> response = new HashMap<>();
	 response.put("deleted", Boolean.TRUE);
	 return response;
	}
}
