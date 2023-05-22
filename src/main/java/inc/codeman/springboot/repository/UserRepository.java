package inc.codeman.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import inc.codeman.springboot.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String Email);

}
