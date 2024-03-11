package org.jsp.ecommerceapp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.ecommerceapp.dao.UserDao;
import org.jsp.ecommerceapp.dto.ResponseStructure;
import org.jsp.ecommerceapp.exception.IdNotFoundException;
import org.jsp.ecommerceapp.exception.InvalidCredentialsException;
import org.jsp.ecommerceapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public ResponseEntity<User> saveUser(User user){
		ResponseStructure<User> structure=new ResponseStructure<>();
		structure.setMessage("user saved");
		structure.setBody(userDao.saveUser(user));
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<User>(HttpStatus.CREATED);
	}
	
	
	public ResponseEntity<ResponseStructure<User>> updateUser(User user) {
		Optional<User> recUser = userDao.findById(user.getId());
		ResponseStructure<User> structure = new ResponseStructure<>();
		if (recUser.isPresent()) {
			User dbuser = recUser.get();
			dbuser.setEmail(user.getEmail());
			dbuser.setName(user.getName());
			dbuser.setPhone(user.getPhone());
			dbuser.setAge(user.getAge());
			dbuser.setGender(user.getGender());
			structure.setMessage("user  Updated");
			structure.setBody(userDao.saveUser(user));
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.ACCEPTED);
		}
		throw new IdNotFoundException();
		}
	
	
	public ResponseEntity<ResponseStructure<User>> findById(int id) {
		Optional<User> recUser = userDao.findById(id);
		ResponseStructure<User> structure = new ResponseStructure<>();
		if (recUser.isPresent()) {
			structure.setBody(recUser.get());
			structure.setMessage("User Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		}
		
		throw new IdNotFoundException();
	}
	public ResponseEntity<ResponseStructure<String>> deleteById(int id) {
		Optional<User> recUser = userDao.findById(id);
		ResponseStructure<String> structure = new ResponseStructure<>();
		if (recUser.isPresent()) {
			structure.setMessage("User found");
			structure.setBody("User deleted");
			structure.setStatusCode(HttpStatus.OK.value());
			userDao.deleteById(id);
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		}
		structure.setMessage("User Not found");
		structure.setBody("cannot delete User as Id is Invalid");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	public ResponseStructure<List<User>> findAll() {
		ResponseStructure<List<User>> structure = new ResponseStructure<>();
		structure.setMessage("List of Users");
		structure.setBody(userDao.findAll());
		structure.setStatusCode(HttpStatus.OK.value());
		return structure;
	}

	public ResponseEntity<ResponseStructure<User>> verifyMerchant(long phone, String password) {
		Optional<User> recUser = userDao.verify(phone, password);
		ResponseStructure<User> structure = new ResponseStructure<>();
		if (recUser.isPresent()) {
			structure.setMessage("Verification Succesfull");
			structure.setBody(recUser.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		}
		throw new InvalidCredentialsException("invalid phone or password");
	}
	
	
	public ResponseEntity<ResponseStructure<List<User>>> findByName(String name) {
		ResponseStructure<List<User>> structure = new ResponseStructure<>();
		List<User> users = userDao.findByName(name);
		structure.setBody(users);
		if (users.size() > 0) {
			structure.setMessage("List of users with entered name ");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<User>>>(structure, HttpStatus.OK);
		}
		structure.setMessage("No User found with the entered name ");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<List<User>>>(structure, HttpStatus.NOT_FOUND);
	}

}