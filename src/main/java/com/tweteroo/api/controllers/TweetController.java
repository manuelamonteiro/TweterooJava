package com.tweteroo.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dtos.TweetDTO;
import com.tweteroo.api.models.TweetModel;
import com.tweteroo.api.services.TweetService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tweets")
public class TweetController {
	final TweetService tweetService;

	public TweetController(TweetService tweetService) {
		this.tweetService = tweetService;
	}

	@GetMapping
	public ResponseEntity<Object> getTweets() {
		List<TweetModel> users = tweetService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<Object> getTweetByUser(@PathVariable("userId") Long userId) {
		return ResponseEntity.status(HttpStatus.OK).body(userId);
	}

	@PostMapping
	public ResponseEntity<Object> createTweet(@RequestBody @Valid TweetDTO body) {
		TweetModel tweet = tweetService.save(body);
		return ResponseEntity.status(HttpStatus.CREATED).body(tweet);
	}
}
