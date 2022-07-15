package com.sgp.service;

import java.util.List;




import com.sgp.model.User;

public interface UserService {
List<User> listAllUser();


	User getUserById(Long id);

	User updateUser(User user);

	void deleteUserById(Long id);

}
