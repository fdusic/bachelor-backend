package bachelor.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import bachelor.beans.Link;
import bachelor.beans.Process;

public interface LinkRepo extends CrudRepository<Link, Integer> {
	
	List<Link> findByProcess(Process p);
}
