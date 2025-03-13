package com.Zylentrix.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.Zylentrix.Model.User;
import com.Zylentrix.Utility.ResponseStructure;

public interface UserService {
	public ResponseEntity<ResponseStructure<User>> createUser(User u);
	public ResponseEntity<ResponseStructure<List<User>>> findAllUsers(); 
	public ResponseEntity<ResponseStructure<User>> findUser(int uId);
	public ResponseEntity<ResponseStructure<User>> updateUser(int uId,User updatedUser);
	public ResponseEntity<ResponseStructure<User>> deleteUser(int uId);
}
