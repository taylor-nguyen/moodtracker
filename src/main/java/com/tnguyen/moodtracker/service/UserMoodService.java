package com.tnguyen.moodtracker.service;

import java.util.Date;
import java.util.List;

import com.tnguyen.moodtracker.model.UserMood;

/**
 * Models all user-related operations regarding user mood
 *
 * @author Taylor Nguyen
 */
public interface UserMoodService {
	/**
	 * Retrieves all user moods recorded by the given date.
	 *
	 * @param date the date to search for
	 * @return
	 */
	List<UserMood> getAllUserMoods(Date date);

	/**
	 * Persists this user mood to database
	 *
	 * @param userMood
	 */
	void saveUserMood(UserMood userMood);
}
