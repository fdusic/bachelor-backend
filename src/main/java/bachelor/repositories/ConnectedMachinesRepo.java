package bachelor.repositories;

import org.springframework.data.repository.CrudRepository;

import bachelor.beans.ConnectedMachines;

public interface ConnectedMachinesRepo extends CrudRepository<ConnectedMachines, Integer>{

}
