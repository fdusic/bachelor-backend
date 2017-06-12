package bachelor.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import bachelor.beans.ReportFailure;

public interface FailureReportRepo extends CrudRepository<ReportFailure, Integer> {
	
	List<ReportFailure> findByExecuted(boolean exec);
	
}
