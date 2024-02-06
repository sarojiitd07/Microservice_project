package com.question.service;

import java.util.List;

import com.question.entities.Question;

public interface QuestionService {

	public Question getQuestion(Long id);
	public List<Question> getAll();
	public Question createQuestion(Question question);
	
	public List<Question> getQuestionsByQuizId(Long quizId);
}
