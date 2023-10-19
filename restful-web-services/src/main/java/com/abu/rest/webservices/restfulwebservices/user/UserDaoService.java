package com.abu.rest.webservices.restfulwebservices.user;


import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	static{
		users.add(new User(1,"Abu", LocalDate.now().minusYears(30)));
		users.add(new User(2,"John", LocalDate.now().minusYears(25)));
		users.add(new User(3,"Mike", LocalDate.now().minusYears(21)));

	}

	public List<User> findAll(){
		return users;
	}

	public User findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId() == id;
		return users.stream().filter(predicate).findFirst().get();
	}

}