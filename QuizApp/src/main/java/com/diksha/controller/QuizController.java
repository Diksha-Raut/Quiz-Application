package com.diksha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.diksha.model.QWrap;
import com.diksha.model.Response;
import com.diksha.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	@Autowired
	QuizService QService;
	
	@PostMapping("/create")
	public ResponseEntity<String> createquiz(@RequestParam int numQ,@RequestParam String title) {
		//return new  ResponseEntity<>("Im here", HttpStatus.OK);
		return QService.createQuiz(numQ,title);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<List <QWrap>> geyquiz(@PathVariable Integer id) {
		//return new  ResponseEntity<>("Im here", HttpStatus.OK);
		return QService.getQuizQuetions(id);
	}
	
	@PostMapping("/submit/{id}")
	public ResponseEntity<Integer> submitquiz(@PathVariable Integer id, @RequestBody List<Response> responses) {
		//return new  ResponseEntity<>("Im here", HttpStatus.OK);
		return QService.Result(id,responses);
	}
	
}
