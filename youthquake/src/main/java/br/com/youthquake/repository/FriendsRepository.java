package br.com.youthquake.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.youthquake.model.Bet;
import br.com.youthquake.model.Friends;
import br.com.youthquake.model.User;

@Repository
public interface FriendsRepository extends JpaRepository<Friends, Long>{
	
	@Query("from Friends where user1.idUser = ?1 or user2.idUser = ?1")
	List<Friends> findFriendsUser(long user);
	
	@Query("from Friends where user1 = ?1")
	List<Friends> findFriendsUser2(User user2);
	
	Friends findFirstByUser1_idUserAndUser2_idUser(Long idUser1, Long idUser2);

	@Query("from Friends where user1.idUser = ?1 or user2.idUser = ?1")
	List<Bet> findFirstByIdFriendsList(long idUser);
}
