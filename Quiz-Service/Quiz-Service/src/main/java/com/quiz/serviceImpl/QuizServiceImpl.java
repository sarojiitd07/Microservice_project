package com.quiz.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.entities.Quiz;
import com.quiz.repository.QuizRepository;
import com.quiz.service.QuestionClient;
import com.quiz.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService{
	
	@Autowired
	private QuizRepository quizRepository;
	
	@Autowired
	private QuestionClient questionClient;

	@Override
	public Quiz getQuiz(Long quizId) {
		Quiz quiz = quizRepository.findById(quizId).orElseThrow(()-> new RuntimeException("Quiz doesn't Exist"));
		quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
		return quiz;
	}

	@Override
	public List<Quiz> getAllQuiz() {
		List<Quiz> quizzes = quizRepository.findAll();
		List<Quiz> quizzesWithQue = quizzes.stream().map(quiz->{
			quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
			return quiz;
		}).collect(Collectors.toList());
		return quizzesWithQue;
	}

	@Override
	public Quiz createQuiz(Quiz quiz) {
		return quizRepository.save(quiz);
	}

}
