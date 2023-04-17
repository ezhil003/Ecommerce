package com.edison.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edison.entity.User;
import com.edison.repo.UserRepository;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository uDao;

	
	/**

	*Retrieves a list of all users from the user repository.
	*@return A list of all users in the system.
	*/
	public List<User> getAllUsers() {
// TODO Auto-generated method stub
		return uDao.findAll();
	}
	
	/**

	*Saves a User object to the User repository.
	*@param prop The User object to be saved.
	*@return The saved User object.
	*/
	public User saveToUserByUser(User prop) {
// TODO Auto-generated method stub
		return uDao.save(prop);
	}
	/**

	*Retrieves a User object from the UserDAO (data access object) based on the provided user ID.
	*@param userId The ID of the user to be retrieved.
	*@return The User object matching the provided user ID, or null if not found.
	*/
	public User getUserByUserId(int userId) {
// TODO Auto-generated method stub
		return uDao.findByUserId(userId);
	}
	
	/**

	*Updates an existing user's information in the system based on the provided user ID and user request.
	*If a user with the given ID does not exist, a RuntimeException is thrown.
	*@param id The ID of the user to be updated.
	*@param userReq The user request containing the updated information.
	*@return The updated user object.
	*/
	public User updateUser(int id, User userReq) {
		Optional<User> optuser=uDao.findById(id);
		if(!optuser.isPresent()) {
			throw new RuntimeException("user with id "+id+"does not exist");
		}
		User user=optuser.get();
		if(userReq.getUserName()!=null) {
			user.setUserName(userReq.getUserName());
			user.setEmailId(userReq.getEmailId());
		}
		if(userReq.getPassword()!=null) {
			user.setPassword(userReq.getPassword());
		}
		uDao.save(user);
		return user;
	}
	
	/**

	*Deletes a user from the system based on the provided user ID.
	*@param id The ID of the user to be deleted.
	*@return The user that was deleted.
	*/
	public User deleteUser(int id) {
		// TODO Auto-generated method stub
		User user = uDao.findByUserId(id);
		uDao.deleteById(id);
		return user;
	}

	/**

	*Retrieves a user from the data access object (DAO) based on the provided username.
	*@param username The username of the user to be retrieved.
	*@return The user object matching the provided username.
	*/
	public User getUserByUserName(String username) {
		// TODO Auto-generated method stub
		return uDao.getUserByUserName(username);
	}

}