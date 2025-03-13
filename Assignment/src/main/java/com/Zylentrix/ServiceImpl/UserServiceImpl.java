package com.Zylentrix.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Zylentrix.Exception.FindingUserFailedException;
import com.Zylentrix.Exception.UserNotFoundByIdException;
import com.Zylentrix.Exception.UserUpdateFailureException;
import com.Zylentrix.Model.User;
import com.Zylentrix.Service.UserService;
import com.Zylentrix.Utility.ResponseStructure;

@Service
public class UserServiceImpl implements UserService {
    private List<User> userList = new ArrayList<>();
    private int nextId = 1; // Used to auto-increment user IDs

    @Override
    public ResponseEntity<ResponseStructure<User>> createUser(User u) {
        u.setuId(nextId++); 
        userList.add(u);

        ResponseStructure<User> rs = new ResponseStructure<>();
        rs.setStatusCode(HttpStatus.CREATED.value());
        rs.setMessage("User created successfully");
        rs.setData(u);

        return new ResponseEntity<>(rs, HttpStatus.CREATED);
    }
    

    @Override
    public ResponseEntity<ResponseStructure<List<User>>> findAllUsers() {
        ResponseStructure<List<User>> rs = new ResponseStructure<>();
        rs.setStatusCode(HttpStatus.OK.value());
        rs.setMessage("Users retrieved successfully");
        rs.setData(userList);

        return new ResponseEntity<>(rs, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseStructure<User>> findUser(int uId) {
        Optional<User> userOpt = userList.stream().filter(user -> user.getuId() == uId).findFirst();

        if (userOpt.isPresent()) {
            ResponseStructure<User> rs = new ResponseStructure<>();
            rs.setStatusCode(HttpStatus.OK.value());
            rs.setMessage("User found successfully");
            rs.setData(userOpt.get());

            return new ResponseEntity<>(rs, HttpStatus.OK);
        } else {
            throw new FindingUserFailedException("Finding user failed: " + uId);
        }
    }

    @Override
    public ResponseEntity<ResponseStructure<User>> updateUser(int uId, User updatedUser) {
        Optional<User> userUpdate = userList.stream().filter(user -> user.getuId() == uId).findFirst();

        if (userUpdate.isPresent()) {
            User user = userUpdate.get();
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            user.setAge(updatedUser.getAge());

            ResponseStructure<User> rs = new ResponseStructure<>();
            rs.setStatusCode(HttpStatus.OK.value());
            rs.setMessage("User updated successfully");
            rs.setData(user);

            return new ResponseEntity<>(rs, HttpStatus.OK);
        } else {
            throw new UserUpdateFailureException("Update failed. User not found with ID: " + uId);
        }
    }

    @Override
    public ResponseEntity<ResponseStructure<User>> deleteUser(int uId) {
        Optional<User> userDel = userList.stream().filter(user -> user.getuId() == uId).findFirst();

        if (userDel.isPresent()) {
            User userToRemove = userDel.get();
            userList.remove(userToRemove);

            ResponseStructure<User> rs = new ResponseStructure<>();
            rs.setStatusCode(HttpStatus.OK.value());
            rs.setMessage("User deleted successfully");
            rs.setData(userToRemove);

            return new ResponseEntity<>(rs, HttpStatus.OK);
        } else {
            throw new UserNotFoundByIdException("Deletion failed. Id: " + uId);
        }
    }
}
