package com.vijay.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	private static volatile int userCount = 0;

	static {
		users.add(new User(++userCount, "Vijay", LocalDate.now().minusYears(28)));
		users.add(new User(++userCount, "Rahul", LocalDate.now().minusYears(25)));
		users.add(new User(++userCount, "Karan", LocalDate.now().minusYears(27)));
	}

	public List<User> findAll() {
		return users;
	}

	public User findById(Integer id) {
		return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
	}

	public User save(User user) {
		user.setId(++userCount);
		users.add(user);
		return user;
	}

	public void deleteById(Integer id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);
	}
}
