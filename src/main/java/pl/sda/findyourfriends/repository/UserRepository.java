package pl.sda.findyourfriends.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.findyourfriends.users.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByUsername(String username);
}
