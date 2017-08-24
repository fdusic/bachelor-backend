package bachelor.services;

import java.util.List;

import bachelor.beans.ReportRegistration;
import bachelor.beans.User;

public interface LoginRegisterService {

	public User login(User user);
	public void createRegistrationReport(ReportRegistration rr, User user);
	public List<ReportRegistration> getReportRegistrations();
	public void register(ReportRegistration rr, User user);
	
}
