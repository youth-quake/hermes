package br.com.youthquake.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.youthquake.dto.UserDTO;
import br.com.youthquake.model.Questions;
import br.com.youthquake.model.User;
import br.com.youthquake.repository.QuizRepository;
import br.com.youthquake.repository.UserRepository;

@Service
public class QuizService {

	@Autowired
	private QuizRepository repository;
	
	@Autowired
	private UserRepository repositoryUser;
	
	
	public Questions getQuestionById(long idQuestion) {
		return repository.getQuestion(idQuestion);
	}

	public User updateScore(long idUser, UserDTO dto) {
		User user = new User();
		user = repositoryUser.findFirstByIdUser(idUser);
		if(user != null)
			user.updateScoreUser(dto);
		
		return repositoryUser.save(user);
	}
}
