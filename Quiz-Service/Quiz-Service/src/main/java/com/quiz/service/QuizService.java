package com.quiz.service;

import java.util.List;

import com.quiz.entities.Quiz;

public interface QuizService {
	public Quiz getQuiz(Long quizId);
	public List<Quiz> getAllQuiz();
	public Quiz createQuiz(Quiz quiz);
}
