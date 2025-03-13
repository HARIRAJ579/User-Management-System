package com.Zylentrix.Controller;

import java.util.List;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Zylentrix.Model.User;
import com.Zylentrix.Service.UserService;
import com.Zylentrix.Utility.ResponseStructure;

@RestController
public class UserController {

	@Autowired
	User u;
	
	@Autowired
	private UserService us;
	
	@PostMapping(value="/createUser")
	public ResponseEntity<ResponseStructure<User>> createUser(@RequestBody  @Valid User u){
		return us.createUser(u);
	}
	
	@GetMapping(value="/findAllUsers")
	public ResponseEntity<ResponseStructure<List<User>>> findAllUsers(){
		return us.findAllUsers();
	}
	
	@GetMapping(value="/findUser/byId/{uId}")
	public ResponseEntity<ResponseStructure<User>> findUser(@PathVariable int uId){
		return us.findUser(uId);
	}

	@PutMapping(value="/updateUser/byId/{uId}")
	public ResponseEntity<ResponseStructure<User>> updateUser(@PathVariable int uId,@RequestBody User updatedUser){
		return us.updateUser(uId, updatedUser);
	}

	@DeleteMapping(value="/deleteUser/byId/{uId}")
	public ResponseEntity<ResponseStructure<User>> deleteUser(@PathVariable int uId){
		return us.deleteUser(uId);
	}
}
