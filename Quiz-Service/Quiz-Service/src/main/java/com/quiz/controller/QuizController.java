package com.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.entities.Quiz;
import com.quiz.serviceImpl.QuizServiceImpl;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	private QuizServiceImpl quizServiceImpl;
	
	@GetMapping("/{quizId}")
	public ResponseEntity<Quiz> getQuiz(@PathVariable Long quizId){
		return new ResponseEntity<Quiz>(quizServiceImpl.getQuiz(quizId),HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Quiz>> getQuiz(){
		return new ResponseEntity<List<Quiz>>(quizServiceImpl.getAllQuiz(),HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz){
		return new ResponseEntity<Quiz>(quizServiceImpl.createQuiz(quiz),HttpStatus.OK);
	}
}
