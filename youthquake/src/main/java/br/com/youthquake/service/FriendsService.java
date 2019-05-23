package br.com.youthquake.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.youthquake.dto.FriendsDTO;
import br.com.youthquake.model.Friends;
import br.com.youthquake.repository.FriendsRepository;

@Service
public class FriendsService {
	
	@Autowired
	private FriendsRepository friendsRepository;
	
	public List<Friends> getAll(){
		return friendsRepository.findAll();
	}
	
	public boolean verifyFriends(FriendsDTO friends) {
		Friends friend = friendsRepository.findFirstByUser1AndUser2(friends.getUser1().getIdUser(), friends.getUser2().getIdUser());

		if (friend != null)
			return true;
		return false;
	}
}
