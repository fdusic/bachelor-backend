package bachelor.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import bachelor.beans.ConnectedMachines;
import bachelor.beans.Topology;

public interface ConnectedMachinesRepo extends CrudRepository<ConnectedMachines, Integer> {

	List<ConnectedMachines> findByTopology(Topology t);
	
}
