package br.com.youthquake.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.youthquake.dto.BetDTO;
import br.com.youthquake.model.Bet;
import br.com.youthquake.model.Friends;
import br.com.youthquake.model.User;
import br.com.youthquake.repository.BetRepository;
import br.com.youthquake.repository.FriendsRepository;
import br.com.youthquake.repository.UserRepository;

@Service
public class BetService {
	@Autowired
	private BetRepository betRepository;
	
	@Autowired
	private FriendsRepository friendRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	HttpSession session;
	private static String SESSION_USER = "SessionUser";
	
	public Bet betInclude(BetDTO dto) {
		Bet bet = new Bet();		
		
		User user1 = userRepository.findFirstByIdUser(dto.getIdUser1());	
		User user2 = userRepository.findFirstByIdUser(dto.getIdUser2());
		
		Friends friend = friendRepository.findFriendByUsers(user1.getIdUser(), user2.getIdUser());
		
		bet.setIdFriends(friend);
		bet.setName(dto.getName());
		bet.setDescription(dto.getDescription());
		bet.setTime(dto.getTime());
		bet.setValue(dto.getValue());
		return betRepository.save(bet);
	}

	public Bet updateBet(long idBet, BetDTO dto) {
		Bet bet = betRepository.getOne(idBet);
		bet.updateBet(dto);
		return betRepository.save(bet);
	}
}
