package com.diksha.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.diksha.model.Question;
import com.diksha.model.Quiz;

@Repository
public interface QDao extends JpaRepository <Question, Integer>{
	@Query(value = "SELECT * FROM question ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
	List<Question> findRandomQuetions(int numQ);

	

}

