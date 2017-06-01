package bachelor.repositories;

import org.springframework.data.repository.CrudRepository;

import bachelor.beans.Facility;

public interface FacilityRepo extends CrudRepository<Facility, Integer> {

}
