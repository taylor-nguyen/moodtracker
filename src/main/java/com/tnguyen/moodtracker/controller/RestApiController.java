package com.tnguyen.moodtracker.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.tnguyen.moodtracker.model.UserMood;
import com.tnguyen.moodtracker.service.UserMoodService;

/**
 * Rest api controller for front end
 *
 * @author Taylor Nguyen
 */
@RestController
@RequestMapping("/api")
public class RestApiController {
	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	@Autowired
	private UserMoodService userMoodService;

	@RequestMapping(value = "/usermood/", method = RequestMethod.GET)
	public ResponseEntity<List<UserMood>> listAllUserMoodsInTheDay() {
		final Date date = new Date();
		logger.info("Getting all user moods submitted in the current day: {} ", date);
		final List<UserMood> userMoods = this.userMoodService.getAllUserMoods(date);
		if (userMoods == null || userMoods.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<UserMood>>(userMoods, HttpStatus.OK);
	}

	@RequestMapping(value = "/usermood/", method = RequestMethod.POST)
	public ResponseEntity<?> saveUserMood(@RequestBody final UserMood userMood, final UriComponentsBuilder ucBuilder) {
		logger.info("Saving user mood : {}", userMood);

		// check the timestamp
		// if (userMoodService.isUserExist(userMood)) {
		// logger.error("Unable to create. A User with name {} already exist",
		// userMood.getName());
		// return new ResponseEntity(
		// new CustomErrorType("Unable to create. A User with name " +
		// userMood.getName() + " already exist."),
		// HttpStatus.CONFLICT);
		// }
		this.userMoodService.saveUserMood(userMood);

		final HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/usermood/{id}").buildAndExpand(userMood.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
}
