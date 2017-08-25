package bachelor.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import bachelor.beans.Process;
import bachelor.beans.Topology;

public interface ProcessRepo extends CrudRepository<Process, Integer> {

	List<Process> findByTopology(Topology t);
	
}
