package bachelor.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import bachelor.beans.User;

public interface UserRepo extends CrudRepository<User, Integer>{

	public List<User> findByUsername(String username);
	
}
