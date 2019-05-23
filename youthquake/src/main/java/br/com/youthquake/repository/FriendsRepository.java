package br.com.youthquake.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.youthquake.model.Friends;

public interface FriendsRepository extends JpaRepository<Friends, Long>{
	
	@Query("from Friends where user1 = ?1 and user2 = ?2")
	Friends findFirstByUser1AndUser2(Long user1, Long User2);

}
