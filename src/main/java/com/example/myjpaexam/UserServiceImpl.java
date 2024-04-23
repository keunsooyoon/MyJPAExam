package com.example.myjpaexam;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void create(User user) {
		userRepository.save(user);
	}

	@Override
	public List<User> readlist() {
		return userRepository.findAll();
	}

	@Override
	public User readdetail(Integer uno) {
		Optional<User> user = userRepository.findById(uno);
		return user.get();
	}

	@Override
	public void update(User user) {
		userRepository.save(user);
	}

	@Override
	public void delete(Integer uno) {
		Optional<User> user = userRepository.findById(uno);
		userRepository.delete(user.get());
	}

}
