package com.tweteroo.api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tweteroo.api.dtos.UserDTO;
import com.tweteroo.api.exceptions.UserNameConflictException;
import com.tweteroo.api.exceptions.UserNotFoundException;
import com.tweteroo.api.models.UserModel;
import com.tweteroo.api.repositories.UserRepository;

@Service
public class UserService {
	final UserRepository userRepository;

	UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<UserModel> findAll() {
		return userRepository.findAll();
	}

	public UserModel findById(Long id) {
		return userRepository.findById(id).orElseThrow(
				() -> new UserNotFoundException("User not found!"));
	}

	public UserModel save(UserDTO dto) {
		if (userRepository.existsByUsername(dto.getUsername())) {
			throw new UserNameConflictException("User already exists!");
		}

		UserModel user = new UserModel(dto);
		return userRepository.save(user);
	}

	public UserModel update(Long id, UserDTO dto) {
		this.findById(id);

		UserModel user = new UserModel(dto);
		user.setId(id);
		return userRepository.save(user);
	}

	public void deleteById(Long id) {
		this.findById(id);
		userRepository.deleteById(id);
	}
}
