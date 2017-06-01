package bachelor.repositories;

import org.springframework.data.repository.CrudRepository;

import bachelor.beans.ReportRegistration;

public interface RegistrationReportRepo extends CrudRepository<ReportRegistration, Integer> {

}
