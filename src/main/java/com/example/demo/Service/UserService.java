package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.demo.Repository.UserRepository;
import com.example.demo.doamin.User;
import com.example.demo.dto.UserDto;

@Service
public class UserService {
	@Autowired
	UserRepository userRepo;

	public boolean addUser(UserDto userDto) {
		User user = new User();
		if (userDto.getEmail() != null) {
			user = userRepo.findByEmail(userDto.getEmail());
		}

		if (user == null) {
			User new_user = new User();
			new_user.setUserName(userDto.getUserName());
			new_user.setAddress(userDto.getAddress());
			new_user.setEmail(userDto.getEmail());
			new_user.setPassword(userDto.getPassword());
			new_user.setCity(userDto.getCity());
			new_user.setFirstName(userDto.getFirstName());
			new_user.setLastName(userDto.getLastName());
			new_user.setPhoneNo(userDto.getPhoneNo());
			new_user.setPincode(userDto.getPincode());
			new_user.setRole(userDto.getRole());
			userRepo.save(new_user);
			return true;
		}
		return false;
	}

	public List<User> getUsers() {
		return userRepo.findAll();
	}

}
