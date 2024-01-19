package com.diksha.service;




import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.diksha.dao.QDao;
import com.diksha.model.Question;

@Service
public class QuetionService {
	@Autowired
	QDao qDao;
	public ResponseEntity<List <Question> >getAllQuestions(){
		try {
	return new ResponseEntity<>( qDao.findAll(), HttpStatus.OK);
	}catch(Exception e) {
		e.printStackTrace();
	}
		return new ResponseEntity<>( new ArrayList<>(), HttpStatus.BAD_REQUEST);
		
	}
	
	
	public String addQues(Question question) {
		
		 qDao.save(question);
		 return "sucess";
	}

}
