package pl.sda.findyourfriends.repository;

import org.springframework.data.repository.CrudRepository;
import pl.sda.findyourfriends.users.User;

import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {

}
