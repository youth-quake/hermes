package br.com.youthquake.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.youthquake.model.Friends;
import br.com.youthquake.model.User;
import br.com.youthquake.repository.FriendsRepository;

@Service
public class FriendsService {
	
	@Autowired
	private FriendsRepository friendsRepository;
	
	@Autowired
	HttpSession session;
	
	private static String SESSION_USER = "SessionUser";

	
	public List<Friends> getAll(){
		return friendsRepository.findAll();
	}
	
	public List<Friends> verifyFriends() {
		User u = (User)this.session.getAttribute(SESSION_USER);
		return friendsRepository.findFirstByUser1AndUser2(u);
	}
	
	public void deleteFriends(long idFriend) {
		friendsRepository.deleteById(idFriend);
	}
}
