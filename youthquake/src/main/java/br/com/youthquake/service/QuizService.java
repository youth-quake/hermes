package br.com.youthquake.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.youthquake.model.Questions;
import br.com.youthquake.repository.QuizRepository;

@Service
public class QuizService {

	@Autowired
	private QuizRepository repository;
	
	public Questions getQuestionById(long idQuestion) {
		return repository.getQuestion(idQuestion);
	}
}
