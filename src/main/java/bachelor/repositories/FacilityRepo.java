package bachelor.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import bachelor.beans.Facility;

public interface FacilityRepo extends CrudRepository<Facility, Integer> {

	
	@Transactional
	List<Facility> findFacilityByIdF(int id);
}
