package com.question.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.question.entities.Question;
import com.question.repository.QuestionRepo;
import com.question.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService{
	
	@Autowired
	private QuestionRepo questionRepo;
	
	
	
	@Override
	public Question getQuestion(Long id) {
		return questionRepo.findById(id).orElseThrow(()-> new RuntimeException("question doesn't exist"));
	}

	@Override
	public List<Question> getAll() {
		return questionRepo.findAll();
	}

	@Override
	public Question createQuestion(Question question) {
		return questionRepo.save(question);
	}

	@Override
	public List<Question> getQuestionsByQuizId(Long quizId) {
		return questionRepo.findByQuizId(quizId);
	}

}
