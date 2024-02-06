package com.question.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.question.entities.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Long>{

	public List<Question> findByQuizId(Long quizId);
}
