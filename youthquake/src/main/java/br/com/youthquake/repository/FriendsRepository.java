package br.com.youthquake.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.youthquake.model.Friends;
import br.com.youthquake.model.User;

@Repository
public interface FriendsRepository extends JpaRepository<Friends, Long>{
	@Query("from Friends where user1.idUser = ?1 and user2.idUser = ?2")
	Friends findFirstByUser1AndUser2(Long user1, Long User2);
	
	@Query("from Friends where user1.idUser = ?1")
	User findFirstByUser1(Long user1);
	
	@Query("from Friends where user2.idUser = ?1")
	User findFirstByUser2(Long user2);

	Friends findFirstByIdFriends(Long idFriends);
	@Query("from Friends where user1 = ?1 or user2 = ?1")
	List<Friends> findFirstByUser1AndUser2(User user1);

	@Query("from Friends where user1.idUser = ?1")
	List<Friends> GetInformationFriendByIdUser(long idUser);

}
