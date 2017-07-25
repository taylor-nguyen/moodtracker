package com.tnguyen.moodtracker.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tnguyen.moodtracker.model.UserMood;

@Repository("userMoodRepository")
public interface UserMoodRepository extends JpaRepository<UserMood, Long> {
	/**
	 * Find all user moods submitted in the given day
	 *
	 * @param submittedDate
	 * @return
	 */
	List<UserMood> findBySubmittedDate(Date submittedDate);
}
