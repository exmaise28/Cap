package lab.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.User;
import repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public void save(User user) {
		
		userRepository.save(user);
	}

	public List<User> findAll() {
		
		return userRepository.findAll();
	}
	public User login(String username, String password) {
		return userRepository.login(username, password);		
	}
	
	public User getUser(String username)
	{
		return userRepository.findOne(username);
	}
}
