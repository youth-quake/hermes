package br.com.youthquake.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.youthquake.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findFirstByLoginAndPassword(String login, String password);

}
