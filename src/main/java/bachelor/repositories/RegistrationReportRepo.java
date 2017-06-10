package bachelor.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import bachelor.beans.ReportRegistration;

public interface RegistrationReportRepo extends CrudRepository<ReportRegistration, Integer> {

	List<ReportRegistration> findByExecuted(boolean exec);
	
}
