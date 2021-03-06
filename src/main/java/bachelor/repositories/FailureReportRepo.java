package bachelor.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import bachelor.beans.ReportFailure;

public interface FailureReportRepo extends CrudRepository<ReportFailure, Integer> {
	
	@Transactional
	List<ReportFailure> findByExecuted(boolean exec);
	
}
