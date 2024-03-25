package org.jsp.ecommerceapp.controller;

import java.util.List;


import org.jsp.ecommerceapp.dto.ResponseStructure;
import org.jsp.ecommerceapp.model.User;
import org.jsp.ecommerceapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user, HttpServletRequest request) {
		return userService.saveUser(user, request);
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ResponseStructure<User>> findById(@PathVariable(name = "id") int id) {
		return userService.findById(id);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteById(@PathVariable(name = "id") int id) {
		return userService.deleteById(id);
	}

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseStructure<List<User>> findAll() {
		return userService.findAll();
	}

	@PostMapping("/verify-by-phone")
	public ResponseEntity<ResponseStructure<User>> verifyUser(@RequestParam long phone,
			@RequestParam String password) {
		return userService.verifyUser(phone, password);
	}

	@GetMapping("/find-by-name/{name}")
	public ResponseEntity<ResponseStructure<List<User>>> findByName(@PathVariable String name) {
		return userService.findByName(name);
	}

	@PostMapping("/verify-by-email")
	public ResponseEntity<ResponseStructure<User>> verifyUser(@RequestParam(name = "email") String email,
			@RequestParam(name = "password") String password) {
		return userService.verifyUser(email, password);
	}
	
	@GetMapping("/activate")
	public ResponseEntity<ResponseStructure<String>> activate(@RequestParam String token) {
		return userService.activate(token);
	}
}