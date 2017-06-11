package bachelor.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import bachelor.beans.Machine;

public interface MachineRepo extends CrudRepository<Machine, Integer>{
	
	@Transactional
	List<Machine> findByIdM(int idM);

}
