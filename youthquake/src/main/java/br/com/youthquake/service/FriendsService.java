package br.com.youthquake.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.youthquake.dto.FriendsDTO;
import br.com.youthquake.model.Friends;
import br.com.youthquake.model.User;
import br.com.youthquake.repository.FriendsRepository;
import br.com.youthquake.repository.UserRepository;

@Service
public class FriendsService {
	
	@Autowired
	private FriendsRepository friendsRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	HttpSession session;
	
	private static String SESSION_USER = "SessionUser";
	
	public List<Friends> getAll(){
		return friendsRepository.findAll();
	}
	
	public Friends friendInclude(FriendsDTO dto) {
		Friends friends = new Friends();
		
		User user1 = (User)this.session.getAttribute(SESSION_USER);
		//User user2 = userRepository.findFirstByIdUser(dto.getUser2());				
		User user2 = userRepository.findFirstByName(dto.getUser2());
		
		friends.setUser1(userRepository.findFirstByIdUser(user1.getIdUser()));
		friends.setUser2(user2);
		
		return friendsRepository.save(friends);
	}
		
	public List<Friends> verifyFriends(long idUser) {
		List<Friends> friends = null;
		User u = (User)this.session.getAttribute(SESSION_USER);	
		friends = friendsRepository.findFriendsUser(idUser);
		return friends;
	}
	
	public void deleteFriends(long idFriend) {
		friendsRepository.deleteById(idFriend);
	}
}
