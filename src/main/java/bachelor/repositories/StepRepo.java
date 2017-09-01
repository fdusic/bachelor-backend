package bachelor.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import bachelor.beans.Machine;
import bachelor.beans.Step;

public interface StepRepo extends CrudRepository<Step, Integer> {

	List<Step> findByMachine(Machine m);
	
}
