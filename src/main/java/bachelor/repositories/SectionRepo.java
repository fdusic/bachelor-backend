package bachelor.repositories;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import bachelor.beans.Facility;
import bachelor.beans.Section;

public interface SectionRepo extends CrudRepository<Section, Integer>{
	
	@Transactional
	List<Section> findSectionByIdS(int idS);
	
	@Transactional
	List<Section> findByFacility(Facility facility);


}
