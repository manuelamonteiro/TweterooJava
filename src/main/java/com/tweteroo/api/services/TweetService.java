package com.tweteroo.api.services;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.tweteroo.api.dtos.TweetDTO;
import com.tweteroo.api.exceptions.UserNotFoundException;
import com.tweteroo.api.models.TweetModel;
import com.tweteroo.api.models.UserModel;
import com.tweteroo.api.repositories.TweetRepository;
import com.tweteroo.api.repositories.UserRepository;

@Service
public class TweetService {
	final TweetRepository tweetRepository;
	final UserRepository userRepository;

	TweetService(TweetRepository tweetRepository, UserRepository userRepository) {
		this.tweetRepository = tweetRepository;
		this.userRepository = userRepository;
	}

	public List<TweetModel> findAll() {
		return tweetRepository.findAll();
	}

	public TweetModel save(TweetDTO dto) {

		UserModel user = userRepository.findById(Objects.requireNonNull(dto.getUserId())).orElseThrow(
				() -> new UserNotFoundException("User not found by this id!"));
				
		TweetModel tweet = new TweetModel(dto, user);
		return tweetRepository.save(tweet);
	}
}
