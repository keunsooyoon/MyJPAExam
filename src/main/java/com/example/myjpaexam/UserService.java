package com.example.myjpaexam;

import java.util.List;

public interface UserService {

		void create(User user);
		
		List<User> readlist();
		
		User readdetail(Integer uno);
		
		void update(User user);
		
		void delete(Integer uno);
}