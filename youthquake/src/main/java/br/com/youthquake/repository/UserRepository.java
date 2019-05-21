package br.com.youthquake.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.youthquake.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("from User where login = ?1 and password = ?2")
	User findFirstByLoginAndPassword(String login, String password);
	
}
