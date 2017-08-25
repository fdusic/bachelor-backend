package bachelor.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import bachelor.beans.Section;
import bachelor.beans.Topology;

public interface TopologyRepo extends CrudRepository<Topology, Integer>{
	
	List<Topology> findBySection(Section s);
	
}
