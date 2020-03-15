package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.doamin.User;

public interface UserRepository extends JpaRepository<User, Long>{
public User findByEmail(String emial);
}
