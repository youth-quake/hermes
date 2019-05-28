package br.com.youthquake.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.youthquake.model.Friends;
import br.com.youthquake.model.User;

public interface FriendsRepository extends JpaRepository<Friends, Long>{
	
	@Query("from Friends where user1 = ?1")
	List<Friends> findFirstByUser1AndUser2(User user1);

}
