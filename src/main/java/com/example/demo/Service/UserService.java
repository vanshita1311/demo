package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.doamin.User;
import com.example.demo.dto.UserDto;

@Service
public class UserService {
	@Autowired
	UserRepository userRepo;
	public boolean addUser(UserDto userDto)
	{
		  User user=new User();
	   if(userDto.getEmail()!=null)
	   {
		   user=userRepo.findByEmail(userDto.getEmail());
	   }
	   if(user==null)
	   {
		   user.setUserName(userDto.getUserName());
		   user.setAddress(userDto.getAddress());
		   user.setEmail(userDto.getEmail());
		   user.setPassword(userDto.getPassword());
		   user.setCity(userDto.getCity());
		   user.setFirstName(userDto.getFirstName());
		   user.setLastName(userDto.getLastName());
		   user.setPhoneNo(userDto.getPhoneNo());
		   user.setPincode(userDto.getPincode());
		   userRepo.save(user); 
		   return true;
		   
	   }
		return false;
	}
		
}
