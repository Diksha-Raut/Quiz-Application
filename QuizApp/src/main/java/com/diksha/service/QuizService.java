package com.diksha.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.diksha.dao.QDao;
import com.diksha.dao.QuizDao;
import com.diksha.model.QWrap;
import com.diksha.model.Question;
import com.diksha.model.Quiz;
import com.diksha.model.Response;

@Service
public class QuizService {
	@Autowired
	QuizDao QuizDao;
	
	@Autowired
	QDao qdao;

	public ResponseEntity<String> createQuiz(int numQ, String title) {
		
		List<Question> questions= qdao.findRandomQuetions(numQ);
		
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuetions(questions);
		QuizDao.save(quiz);
		
		return new ResponseEntity<> ("sucess", HttpStatus.CREATED);
	}

	public ResponseEntity<List<QWrap>> getQuizQuetions(Integer id) {
		Optional<Quiz> quiz=QuizDao.findById(id);
		List <Question> questionfromDB= quiz.get().getQuetions();
		List<QWrap> quetionsforuser = new ArrayList<>();
		for (Question q : questionfromDB ) {
			
			QWrap qw =  new QWrap(q.getId(),q.getQuestiontitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
			quetionsforuser.add(qw);
	
		}
		return new ResponseEntity<> (quetionsforuser, HttpStatus.OK);
	}

	public ResponseEntity<Integer> Result(Integer id, List<Response> responses) {
		
		Quiz quiz=QuizDao.findById(id).get();
		List <Question> questions= quiz.getQuetions();
		
		int i=0;
		int right= 0;
		
		for (Response response: responses) {
			if(response.getResponse().equals(questions.get(i).getAnswer())) {
			right++;
			}
			i++;
		}
		return new ResponseEntity<> (right, HttpStatus.OK);
	}
	
	

}
