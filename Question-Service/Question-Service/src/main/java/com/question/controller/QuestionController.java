package com.question.controller;

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

import com.question.entities.Question;
import com.question.serviceImpl.QuestionServiceImpl;


@RestController
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionServiceImpl questionServiceImpl;
	
	@GetMapping("/{id}")
	public ResponseEntity<Question> getQuestion(@PathVariable Long id){
		return new ResponseEntity<Question>(questionServiceImpl.getQuestion(id),HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Question>> getQuestion(){
		return new ResponseEntity<List<Question>>(questionServiceImpl.getAll(),HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Question> createQuestion(@RequestBody Question question){
		return new ResponseEntity<Question>(questionServiceImpl.createQuestion(question),HttpStatus.OK);
	}
	
	@GetMapping("/quiz/{quizId}")
	public ResponseEntity<List<Question>> getQuestionsOfQuizId(@PathVariable Long quizId){
		return new ResponseEntity<List<Question>>(questionServiceImpl.getQuestionsByQuizId(quizId),HttpStatus.OK);
	}
	
}
