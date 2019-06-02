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

@Service
public class BetService {
	@Autowired
	private BetRepository betRepository;
	
	@Autowired
	private FriendsRepository friendRepository;
	
	@Autowired
	HttpSession session;
	private static String SESSION_USER = "SessionUser";
	
	public Bet betInclude(BetDTO dto) {
		Bet bet = new Bet();
		
		Friends friendId = friendRepository.findFirstByIdFriends(dto.getIdFriends());
		bet.setIdFriends(friendId);
		bet.setName(dto.getName());
		bet.setDescription(dto.getDescription());
		bet.setTime(dto.getTime());
		bet.setValue(dto.getValue());
		bet.setResult(dto.getResult());
		return betRepository.save(bet);
	}

	public List<Bet> getBetInfo() {
		User u = (User)this.session.getAttribute(SESSION_USER);
		return betRepository.GetInformationBetByIdUser(u.getIdUser());
	}
}
