package com.tnguyen.moodtracker.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tnguyen.moodtracker.model.UserMood;
import com.tnguyen.moodtracker.repository.UserMoodRepository;

@Service("userMoodService")
@Transactional
public class UserMoodServiceImpl implements UserMoodService {

	@Autowired
	private UserMoodRepository repository;

	@Override
	public List<UserMood> getAllUserMoods(final Date date) {
		return this.repository.findBySubmittedDate(date);
	}

	@Override
	public void saveUserMood(final UserMood userMood) {
		this.repository.save(userMood);
	}

}
