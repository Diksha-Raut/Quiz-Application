package com.diksha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diksha.model.Question;
import com.diksha.service.QuetionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	QuetionService qservice;
	
	@GetMapping("/allquestions")
	public ResponseEntity< List<Question> > getAllQuestions() {
	 return qservice.getAllQuestions() ;
 }
	@PostMapping("/add")
	public String addQues(@RequestBody Question question) {
		return qservice.addQues(question);
	}
}
