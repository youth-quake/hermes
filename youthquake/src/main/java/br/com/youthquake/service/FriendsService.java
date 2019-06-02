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
	HttpSession session;
	
	private static String SESSION_USER = "SessionUser";
	public List<Friends> getAll(){
		return friendsRepository.findAll();
	}
	
	public Friends friendInclude(FriendsDTO dto) {
		Friends friends = new Friends();
		
		User user1 = userRepository.findFirstByIdUser(dto.getUser1());
		User user2 = userRepository.findFirstByIdUser(dto.getUser2());
		
		friends.setUser1(user1);
		friends.setUser2(user2);
		
		return friendsRepository.save(friends);
	}
	
	
	public boolean verifyFriends(FriendsDTO friends) {
		Friends friend = friendsRepository.findFirstByUser1AndUser2(friends.getUser1(), friends.getUser2());

		if (friend != null)
			return true;
		return false;
	}
	
	public List<Friends> verifyFriends() {
		User u = (User)this.session.getAttribute(SESSION_USER);
		return friendsRepository.findFirstByUser1AndUser2(u);
	}
	
	public void deleteFriends(long idFriend) {
		friendsRepository.deleteById(idFriend);
	}

	public List<Friends> getFriendInfo() {
		User u = (User)this.session.getAttribute(SESSION_USER);
		return friendsRepository.GetInformationFriendByIdUser(u.getIdUser());
	}
}
